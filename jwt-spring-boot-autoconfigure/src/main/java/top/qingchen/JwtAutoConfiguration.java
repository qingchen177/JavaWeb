package top.qingchen;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author qingchen
 * @date 19/10/2023 下午 3:34
 */

@Configuration
@ConditionalOnMissingBean(TokenService.class)
@EnableConfigurationProperties(TokenProperties.class)
public class JwtAutoConfiguration {

    @Bean
    public QingChenToken qingChenToken(){
        return new QingChenToken();
    }

    @Bean
    public TokenService tokenService(){
        return new TokenService();
    }
}
