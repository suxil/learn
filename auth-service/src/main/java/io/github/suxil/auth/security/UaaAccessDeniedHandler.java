package io.github.suxil.auth.security;

import io.github.suxil.core.common.ResponseResult;
import io.github.suxil.core.constance.Constants;
import io.github.suxil.core.util.JsonUtils;
import io.github.suxil.core.util.MessageUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p> Title: 标题 </p>
 * <pre> Description: 描述 </pre>
 * date: 2020/4/4 16:03
 * <p>
 * Copyright: © 2012-2020 . All rights reserved.
 * Company:
 *
 * @author lu_it
 * @version V1.0
 * @Package io.github.suxil.auth.security
 */
@Slf4j
public class UaaAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        log.error("access denied: " + accessDeniedException.getMessage());

        response.setCharacterEncoding(Constants.UFT8);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.getWriter().write(JsonUtils.toJson(ResponseResult.accessAuthError(MessageUtils.getMessage("error.not.access"))));
    }

}
