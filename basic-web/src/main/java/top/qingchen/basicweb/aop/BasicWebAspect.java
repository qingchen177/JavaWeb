package top.qingchen.basicweb.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.qingchen.basicweb.service.IAuditRecordService;

/**
 * @author qingchen
 * @date 17/10/2023 下午 5:12
 */
@Slf4j
@Component
@Aspect
public class BasicWebAspect {

    @Autowired
    private IAuditRecordService auditRecordService;

    @Pointcut("execution(public * top..*.controller..*.*(..))")
    private void auditLog(){}


    @Before("auditLog()")
    public void before(JoinPoint point){
        log.info("前-进入切面");

    }

    @After("@annotation(BasicWebLog)")
    public void after(JoinPoint point){
        log.info("后-进入切面");
    }

}
