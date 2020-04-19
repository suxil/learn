package com.learn.auth.util;

import com.learn.auth.domain.UaaUser;
import com.learn.core.exception.GlobalCommonException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Map;

/**
 * <p> Title: 标题 </p>
 * <pre> Description: 描述 </pre>
 * date: 2020/4/5 10:08
 * <p>
 * Copyright: © 2012-2020 . All rights reserved.
 * Company:
 *
 * @author lu_it
 * @version V1.0
 * @Package com.learn.auth.util
 */
public class UserUtils {

    /**
     * 获取当前登录用户
     * @return
     */
    public static UaaUser getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object details = authentication.getDetails();
        if (details instanceof Map) {
            Map<String, Object> userMap = (Map<String, Object>) details;

            UaaUser uaaUser = new UaaUser();
            uaaUser.setUserCode((String) userMap.get("userCode"));
            uaaUser.setUserName((String) userMap.get("userName"));
            uaaUser.setJp((String) userMap.get("jp"));
            uaaUser.setLoginName((String) userMap.get("loginName"));
            uaaUser.setPassword((String) userMap.get("password"));
            uaaUser.setMobile((String) userMap.get("mobile"));
            uaaUser.setEmail((String) userMap.get("email"));
            uaaUser.setAdmin((Boolean) userMap.get("admin"));

            return uaaUser;
        } else if (details == null) {
            throw new GlobalCommonException("error.login.expire");
        } else {
            throw new GlobalCommonException("error.user.resolve");
        }
    }

}
