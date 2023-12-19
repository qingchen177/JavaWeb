package top.qingchen.basicweb.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.qingchen.basicweb.interceptor.BasicWebInterceptor;

/**
 * @author qingchen
 * @date 13/10/2023 下午 5:52
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private BasicWebInterceptor basicWebInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(basicWebInterceptor).addPathPatterns("/**").excludePathPatterns("/**/login","/**/sign","/**/auto/**");
    }
}
