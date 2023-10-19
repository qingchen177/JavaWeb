package top.qingchen;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author qingchen
 * @date 19/10/2023 下午 4:10
 */

public class TokenService {

    @Autowired
    private TokenProperties tokenProperties;

    public String getToken() {
        return JwtUtil.genJWT(tokenProperties.getClaims());
    }
}
