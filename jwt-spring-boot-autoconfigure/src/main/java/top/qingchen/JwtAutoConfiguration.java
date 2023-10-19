package top.qingchen;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author qingchen
 * @date 19/10/2023 下午 3:34
 */

@Configuration
public class JwtAutoConfiguration {

    @Bean
    public QingChenToken qingChenToken(){
        return new QingChenToken();
    }

    @Bean
    public JwtUtil JwtUtil(){
        return new JwtUtil();
    }
}
