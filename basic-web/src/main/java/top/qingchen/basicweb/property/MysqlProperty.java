package top.qingchen.basicweb.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author qingchen
 * @date 12/10/2023 下午 7:12
 */
@Data
@Component
@ConfigurationProperties(prefix = "spring.datasource")
public class MysqlProperty {
    String url;
    String username;
    String password;
}
