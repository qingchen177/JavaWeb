package top.qingchen.basicweb.interceptor;

import com.alibaba.fastjson2.JSONObject;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import top.qingchen.JwtUtil;
import top.qingchen.basicweb.common.constant.GlobalConstant;
import top.qingchen.basicweb.common.pojo.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器
 *
 * @author qingchen
 * @date 13/10/2023 下午 5:45
 */
@Slf4j
@Component
public class BasicWebInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 目标方法前执行，放行 true , 不放行 false
        log.info(GlobalConstant.LOG_PREFIX + "进入全局拦截器！--执行前");

        // token验证
        String requestURI = request.getRequestURI();
        log.info(GlobalConstant.LOG_PREFIX + "请求路径为："+requestURI);
        String token = request.getHeader("token");

        if (!StringUtils.hasLength(token)){
            Result<String> result = Result.error("NOT LOGIN!!!");
            String s = JSONObject.toJSONString(result);
            response.getWriter().write(s);
            return false;
        }

        try {
            Claims claims = JwtUtil.parseJWT(token);
        }catch (Exception e) {
            Result<String> result = Result.error("INVALID TOKEN!!!");
            String s = JSONObject.toJSONString(result);
            response.getWriter().write(s);
            return false;

        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // 目标方法后执行
        log.info(GlobalConstant.LOG_PREFIX + "进入全局拦截器！--执行后");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //视图渲染完执行
        log.info(GlobalConstant.LOG_PREFIX + "进入全局拦截器！--视图渲染后");
    }
}
