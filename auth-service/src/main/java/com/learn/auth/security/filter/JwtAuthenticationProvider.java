package com.learn.auth.security.filter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * <p> Title: 标题 </p>
 * <pre> Description: 描述 </pre>
 * date: 2020/4/4 15:45
 * <p>
 * Copyright: © 2012-2020 . All rights reserved.
 * Company:
 *
 * @author lu_it
 * @version V1.0
 * @Package com.learn.auth.security.filter
 */
@Component
@Order(-10)
public final class JwtAuthenticationProvider implements AuthenticationProvider {

    private static final Logger log = LogManager.getLogger(JwtAuthenticationProvider.class);

    @Override
    public boolean supports(Class<?> aClass) {
        log.info("supports: " + aClass);
        return false;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        log.info("authentication: " + authentication);
        return null;
    }

}
