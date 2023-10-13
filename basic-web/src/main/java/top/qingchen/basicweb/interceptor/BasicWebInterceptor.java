package top.qingchen.basicweb.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import top.qingchen.basicweb.common.constant.GlobalConstant;

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
    @Override // 目标方法前执行，放行 true , 不放行 false
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info(GlobalConstant.LOG_PREFIX + "进入全局拦截器！--执行前");
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override // 目标方法后执行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info(GlobalConstant.LOG_PREFIX + "进入全局拦截器！--执行后");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override //视图渲染完执行
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info(GlobalConstant.LOG_PREFIX + "进入全局拦截器！--视图渲染后");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
