package top.qingchen.basicweb.aop;

import com.alibaba.fastjson2.JSONObject;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.qingchen.JwtUtil;
import top.qingchen.basicweb.common.constant.GlobalConstant;
import top.qingchen.basicweb.common.constant.myenum.AuditRecordOperation;
import top.qingchen.basicweb.entity.AuditRecord;
import top.qingchen.basicweb.service.IAuditRecordService;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.UUID;

/**
 * @author qingchen
 * @date 17/10/2023 下午 5:12
 */
@Slf4j
@Component
@Aspect
public class BasicWebAspect {

    private static final String USER_ID = "id";

    @Autowired
    private IAuditRecordService auditRecordService;

    @Autowired
    private HttpServletRequest request;

    @Pointcut("execution(public * top..*.controller..*.*(..))")
    private void auditLog() {
    }

    @Before("auditLog()")
    public void before(JoinPoint point) {
        log.info("前-进入切面");
    }

    @After("auditLog()")
    public void after(JoinPoint point) {
        log.info("后-进入切面");
    }

    @Around("@annotation(BasicWebLog)")
    public Object aopAuditRecord(ProceedingJoinPoint point) throws Throwable {
        log.info(GlobalConstant.LOG_PREFIX + "进入WebLog!");

        AuditRecord record = new AuditRecord();
        String uuid = UUID.randomUUID().toString().toUpperCase().replaceAll("-", "");
        LocalDateTime time = LocalDateTime.now();
        String userId = null;

        //获取类名
        String className = point.getTarget().getClass().getName();
        //从切面织入点处通过反射机制获取织入点处的方法
        MethodSignature signature = (MethodSignature) point.getSignature();
        //获取切入点所在的方法
        Method method = signature.getMethod();

        //计算操作耗时
        long begin = System.currentTimeMillis();
        Object returnValue = point.proceed();
        long end = System.currentTimeMillis();
        long costTime = end - begin;
        //方法返回值
        String returnValueString = JSONObject.toJSONString(returnValue);

        //获取注解
        BasicWebLog annotation = method.getAnnotation(BasicWebLog.class);
        if (annotation != null) {
            AuditRecordOperation auditRecordOperation = annotation.operationType();
            record.setOperationType(auditRecordOperation.value());
            if (AuditRecordOperation.LOGIN.equals(auditRecordOperation) || AuditRecordOperation.SIGN.equals(auditRecordOperation)) {
                //TODO：登陆注册
                userId="LOGIN|SIGN";
            } else {
                String token = request.getHeader("token");
                Claims claims = JwtUtil.parseJWT(token);
                userId = claims.get(USER_ID, String.class);
            }
        }

        //获取请求sessionId
        String sessionId = request.getRequestedSessionId();
        log.info(GlobalConstant.LOG_PREFIX + "请求sessionId:" + sessionId);
        //请求路径
        String url = request.getRequestURI();
        log.info(GlobalConstant.LOG_PREFIX + "请求路径:" + url);
        //获取请求参数信息
        String paramData = Arrays.toString(point.getArgs());
        //获取客户端ip
        String clientIp = getClientIp(request);
        log.info(GlobalConstant.LOG_PREFIX + "客户端ip:" + clientIp);

        record.setId(uuid)
                .setOperator(userId)
                .setOperationTime(time)
                .setOperationTimeConsumption(costTime)
                .setOperationClassName(className)
                .setOperationMethodName(method.getName())
                .setOperationMethodParams(paramData)
                .setOperationReturnValue(returnValueString);
        auditRecordService.save(record);
        return returnValue;
    }

    /**
     * 获取客户端ip地址
     *
     * @param request
     * @return
     */
    private String getClientIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        String unknown = "unknown";
        if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        // 多个路由时，取第一个非unknown的ip
        final String[] arr = ip.split(",");
        for (final String str : arr) {
            if (!"unknown".equalsIgnoreCase(str)) {
                ip = str;
                break;
            }
        }
        return ip;
    }
}
