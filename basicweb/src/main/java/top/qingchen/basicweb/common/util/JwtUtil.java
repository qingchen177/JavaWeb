//package top.qingchen.basicweb.common.util;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//
//import java.util.Date;
//import java.util.Map;
//
///**
// * JWT工具类
// *
// * @author qingchen
// * @date 13/10/2023 下午 3:33
// */
//
//public class JwtUtil {
//
//    /**
//     * token签名*
//     */
//    private static final String SIGN = "qingchen";
//    /**
//     * token过期时间*
//     */
//    private static final Long EXPIRATION_TIME = 3600 * 1000L;
//
//    /**
//     * 生成JWT令牌*
//     *
//     * @param claims
//     * @return
//     */
//    public static String genJWT(Map claims) {
//        return Jwts.builder()
//                //签名算法
//                .signWith(SignatureAlgorithm.HS256, SIGN)
//                //自定义内容（载荷）
//                .setClaims(claims)
//                //设置有效时间1H
//                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
//                .compact();
//
//    }
//
//    public static Claims parseJWT(String token) throws Exception{
//        return Jwts.parser().setSigningKey(SIGN).parseClaimsJws(token).getBody();
//    }
//
//}
