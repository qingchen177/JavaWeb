package top.qingchen;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * @author qingchen
 * @date 19/10/2023 下午 4:10
 */

public class TokenService {

    @Autowired
    private TokenProperties tokenProperties;

    public String getToken() {
        Map<String, Object> claims = tokenProperties.getClaims();
        if (claims == null || claims.size() <= 0) {
            claims.put("unknown","unknown");
        }
        return JwtUtil.genJWT(claims);
    }
}
