package top.qingchen.basicweb.common.util;

import org.junit.jupiter.api.Test;

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
        JwtUtil.parseJWT("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoicGFzc3dvcmQiLCJleHAiOjE2OTcxODY2MzV9.ILqCYq0VUjnpWRKYm3jxpvJgbFtHgRgZm0K_RtHCDRQ");
    }
}
