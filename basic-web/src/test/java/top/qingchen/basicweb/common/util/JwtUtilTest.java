package top.qingchen.basicweb.common.util;

import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;
import top.qingchen.JwtUtil;

import java.util.HashMap;

/**
 * @author qingchen
 * @date 13/10/2023 下午 3:41
 */

public class JwtUtilTest {

    @Test
    public void testGenJWT() throws Exception {
        String result = JwtUtil.genJWT(new HashMap() {{
            put("name", "password");
        }});
        System.out.println("result = " + result);
    }

    @Test
    public void testParseJWT() throws Exception {
        String token ="eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoiYWRtaW5zdHJhdG9yIiwicGFzc3dvcmQiOiIxMjM0NTYiLCJpZCI6bnVsbCwiZXhwIjoxNjk3NTMxMDE1LCJhY2NvdW50IjpudWxsfQ.Fkqkk2V7wK008OryqrVOVCyFJPRO8jsuJ0jGRuSqWQs";
        Claims claims = JwtUtil.parseJWT(token);
        System.out.println("claims = " + claims);
    }
}
