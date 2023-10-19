package top.qingchen;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qingchen
 * @date 19/10/2023 下午 3:28
 */

public class QingChenToken {
    private static final String NAME = "name";
    private static final String VALUE = "qingchen";

    String token;
    String description;

    QingChenToken(String token, String description) {
        this.token = token;
        this.description = description;
    }

    QingChenToken() {
        Map<String, Object> map = new HashMap<>();
        map.put(NAME, VALUE);
        this.token = JwtUtil.genJWT(map);
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
