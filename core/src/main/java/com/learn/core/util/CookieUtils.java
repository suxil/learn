package com.learn.core.util;

import lombok.extern.slf4j.Slf4j;

import javax.annotation.Nullable;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/5/30 0030 22:17
 */
@Slf4j
public final class CookieUtils {

    private static final String ENCODE = "UTF-8";
    private static final int DEFAULT_MAX_AGE = -1;

    private CookieUtils() {
    }

    /**
     * 得到Cookie的值, 不编码
     *
     * @param cookieName
     * @return
     */
    public static String getCookie(String cookieName) {
        return getCookie(WebUtils.getRequest(), cookieName, false);
    }

    /**
     * 得到Cookie的值, 不编码
     *
     * @param request
     * @param cookieName
     * @return
     */
    public static String getCookie(HttpServletRequest request, String cookieName) {
        return getCookie(request, cookieName, false);
    }

    /**
     * 得到Cookie的值,
     *
     * @param request
     * @param cookieName
     * @return
     */
    public static String getCookie(HttpServletRequest request, String cookieName, boolean isDecoder) {
        return getCookie(request, cookieName, isDecoder, ENCODE);
    }

    /**
     * 得到Cookie的值,
     *
     * @param request
     * @param cookieName
     * @return
     */
    public static String getCookie(@Nullable HttpServletRequest request, String cookieName, boolean isDecoder, String encodeString) {
        Cookie[] cookieList = request.getCookies();
        if (cookieList == null || cookieName == null) {
            return null;
        }
        String retValue = null;
        try {
            for (int i = 0; i < cookieList.length; i++) {
                if (cookieList[i].getName().equals(cookieName)) {
                    if (isDecoder) {
                        retValue = URLDecoder.decode(cookieList[i].getValue(), ENCODE);
                    } else {
                        retValue = cookieList[i].getValue();
                    }
                    break;
                }
            }
        } catch (UnsupportedEncodingException e) {
            log.error("Cookie Decode Error.", e);
        }
        return retValue;
    }

    /**
     * 设置Cookie的值 不设置生效时间默认浏览器关闭即失效,也不编码
     */
    public static void setCookie(String cookieName, String cookieValue) {
        setCookie(null, WebUtils.getResponse(), cookieName, cookieValue, DEFAULT_MAX_AGE);
    }

    /**
     * 设置Cookie的值 不设置生效时间默认浏览器关闭即失效,也不编码
     */
    public static void setCookie(HttpServletResponse response, String cookieName, String cookieValue) {
        setCookie(null, response, cookieName, cookieValue, DEFAULT_MAX_AGE);
    }

    /**
     * 设置Cookie的值 不设置生效时间默认浏览器关闭即失效,也不编码
     */
    public static void setCookie(HttpServletRequest request, HttpServletResponse response, String cookieName, String cookieValue) {
        setCookie(request, response, cookieName, cookieValue, DEFAULT_MAX_AGE);
    }

    /**
     * 设置Cookie的值 在指定时间内生效,但不编码
     */
    public static void setCookie(HttpServletRequest request, HttpServletResponse response, String cookieName, String cookieValue, int cookieMaxage) {
        setCookie(request, response, cookieName, cookieValue, cookieMaxage, false);
    }

    /**
     * 设置Cookie的值 不设置生效时间,但编码
     */
    public static void setCookie(HttpServletRequest request, HttpServletResponse response, String cookieName, String cookieValue, boolean isEncode) {
        setCookie(request, response, cookieName, cookieValue, DEFAULT_MAX_AGE, isEncode);
    }

    /**
     * 设置Cookie的值 在指定时间内生效, 编码参数
     */
    public static void setCookie(HttpServletRequest request, HttpServletResponse response, String cookieName, String cookieValue, int cookieMaxage, boolean isEncode) {
        setCookie(request, response, cookieName, cookieValue, cookieMaxage, isEncode, ENCODE);
    }

    /**
     * 设置Cookie的值 在指定时间内生效, 编码参数(指定编码)
     */
    public static void setCookie(HttpServletRequest request, HttpServletResponse response, String cookieName, String cookieValue, int cookieMaxage, String encodeString) {
        setCookie(request, response, cookieName, cookieValue, cookieMaxage, true, encodeString);
    }

    /**
     * 删除Cookie带cookie域名
     */
    public static void deleteCookie(HttpServletRequest request, HttpServletResponse response, String cookieName) {
        setCookie(request, response, cookieName, "", DEFAULT_MAX_AGE, false);
    }

    /**
     * 删除Cookie带cookie域名
     */
    public static void deleteCookie(HttpServletResponse response, String cookieName) {
        setCookie(null, response, cookieName, "", DEFAULT_MAX_AGE, false);
    }

    /**
     * 设置Cookie的值，并使其在指定时间内生效
     *
     * @param cookieMaxage cookie生效的最大秒数
     */
    private static final void setCookie(HttpServletRequest request, @Nullable HttpServletResponse response, String cookieName, String cookieValue, int cookieMaxage, boolean isEncode, String encodeString) {
        try {
            if (cookieValue == null) {
                cookieValue = "";
            } else if (isEncode) {
                cookieValue = URLEncoder.encode(cookieValue, encodeString);
            }
            Cookie cookie = new Cookie(cookieName, cookieValue);
            if (cookieMaxage > 0) {
                log.debug("设置cookie，自定义 cookie 过期时间");
                cookie.setMaxAge(cookieMaxage);
            } else {
                log.debug("设置cookie，浏览器关闭 cookie 过期");
                cookie.setMaxAge(DEFAULT_MAX_AGE);
            }
            if (null != request) {
                // 设置域名的cookie
                cookie.setDomain(getDomainName(request));
            }

            cookie.setPath("/");
            response.addCookie(cookie);
        } catch (Exception e) {
            log.error("Cookie Encode Error.", e);
        }
    }

    /**
     * 得到cookie的域名
     */
    private static final String getDomainName(HttpServletRequest request) {
        String domainName = null;

        String serverName = request.getRequestURL().toString();
        if (serverName == null || serverName.equals("")) {
            domainName = "";
        } else {
            serverName = serverName.toLowerCase();
            serverName = serverName.substring(7);
            final int end = serverName.indexOf("/");
            domainName = serverName.substring(0, end);
        }

        if (domainName != null && domainName.indexOf(":") > 0) {
            String[] ary = domainName.split("\\:");
            domainName = ary[0];
        }
        return domainName;
    }

}
