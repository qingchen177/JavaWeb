package top.qingchen;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qingchen
 * @date 19/10/2023 下午 4:12
 */
@ConfigurationProperties(prefix = "top.qingchen")
public class TokenProperties {

    String name;
    Object value;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Map<String,Object> getClaims() {
        Map<String,Object> claims = new HashMap<>(2);
        claims.put(name, value);
        return claims;
    }
}
