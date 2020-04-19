package com.learn.auth.security.filter;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.learn.core.constance.Constants;
import com.learn.core.security.AuthoritiesConstants;
import com.learn.core.util.JwtUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
public final class JwtAuthenticationFilter extends OncePerRequestFilter {

    private static final Logger log = LogManager.getLogger(JwtAuthenticationFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String accessToken = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (StringUtils.isEmpty(accessToken)) {
            accessToken = request.getHeader(Constants.ACCESS_TOKEN);
        } else if (accessToken.startsWith(Constants.ACCESS_TOKEN_PREFIX)) {
            accessToken = accessToken.replace(Constants.ACCESS_TOKEN_PREFIX, "");
        }

        if (StringUtils.isEmpty(accessToken)) {
            filterChain.doFilter(request, response);
            return;
        }

        DecodedJWT decodedJWT = JwtUtils.verify(accessToken);

        Map<String, Object> map = decodedJWT.getClaim("map").asMap();

        List<GrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(new SimpleGrantedAuthority(AuthoritiesConstants.USER));

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(map.get("loginName"), "", authorityList);
        authentication.setDetails(map);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        log.debug("access token {}", accessToken);

        filterChain.doFilter(request, response);
    }

}
