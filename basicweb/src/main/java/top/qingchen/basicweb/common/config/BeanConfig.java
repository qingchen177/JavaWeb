package top.qingchen.basicweb.common.config;

import org.dom4j.io.SAXReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.qingchen.basicweb.controller.BasicWebUserController;

/**
 * @author qingchen
 * @date 18/10/2023 下午 2:02
 */
@Configuration
public class BeanConfig {
    @Bean
    public SAXReader SAXReader(BasicWebUserController basicWebUserController){
        //第三方注入类，直接在方法参数上写 System.out.println("basicWebUserController = " + basicWebUserController);
        return new SAXReader();
    }
}
