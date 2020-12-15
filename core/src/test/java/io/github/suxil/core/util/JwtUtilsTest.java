package io.github.suxil.core.util;

import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * <p> Title: 标题 </p>
 * <pre> Description: 描述 </pre>
 * date: 2020/4/4 19:04
 * <p>
 * Copyright: © 2012-2020 . All rights reserved.
 * Company:
 *
 * @author lu_it
 * @version V1.0
 * @Package io.github.suxil.core.util
 */
public class JwtUtilsTest {

    @Test
    public void tokenTest() {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", "userId");
        String token = JwtUtils.create(map);

        DecodedJWT jwt = JwtUtils.verify(token);

        Map<String, Object> resultMap = jwt.getClaim("map").asMap();

        System.out.println("token: " + token);
    }

}
