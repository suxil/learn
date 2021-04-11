//package io.github.suxil.core.util;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.JWTVerifier;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.auth0.jwt.interfaces.DecodedJWT;
//import org.apache.commons.lang3.time.DateUtils;
//
//import java.util.*;
//
///**
// * @Author: luxq
// * @Description:
// * @Date: Created in 2018/5/30 0030 22:31
// */
//public final class JwtUtils {
//
//    private static final String ISSUER = "auth0";
//    private static final String SECRET = "secret";
//    private static final Algorithm ALGORITHM = Algorithm.HMAC256(SECRET);
//    private static final int CALENDAR_NUM = 8;
//
//    private JwtUtils() {
//    }
//
//    /**
//     * 创建token
//     * @param map
//     * @return
//     */
//    public static String create(Map<String, ?> map) {
//        return create(ALGORITHM, map);
//    }
//
//    /**
//     * 过滤map中jwt不支持的属性
//     * @param map
//     * @return
//     */
//    public static Map<String, Object> filter(Map<String, ?> map) {
//        Map<String, Object> result = new HashMap<>();
//        map.forEach((k, v) -> {
//            if (Objects.isNull(v)) {
//                return;
//            }
//            if (v instanceof List
//                    || v instanceof Boolean
//                    || v instanceof Integer
//                    || v instanceof Long
//                    || v instanceof Double
//                    || v instanceof String
//                    || v instanceof Date) {
//                result.put(k, v);
//            }
//        });
//        return result;
//    }
//
//    private static String create(Algorithm algorithm, Map<String, ?> map) {
//        Date issuerAt = new Date();
//        Date expireAt = DateUtils.addHours(issuerAt, CALENDAR_NUM);
//
//        return JWT.create()
//                .withIssuer(ISSUER)
//                .withIssuedAt(issuerAt)
//                .withExpiresAt(expireAt)
//                .withClaim("map", filter(map))
//                .sign(algorithm);
//    }
//
//    /**
//     * 解析token
//     * @param token
//     * @return
//     */
//    public static DecodedJWT verify(String token) {
//        return verify(ALGORITHM, token);
//    }
//
//    private static DecodedJWT verify(Algorithm algorithm, String token) {
//        JWTVerifier verifier = JWT.require(algorithm).build();
//        return verifier.verify(token);
//    }
//
//}
