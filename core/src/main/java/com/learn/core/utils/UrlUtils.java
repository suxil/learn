package com.learn.core.utils;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/4/29 0029 23:59
 */
public class UrlUtils {

    private static final String CHARSET = "UTF-8";

    /**
     * 通过url获取域名
     * @param url
     * @return
     */
    public static String urlGetDomain(String url) {
        url = checkEncode(url);
        String prefix = url.substring(0, 7);
        if ("http://".equals(prefix) || "https:/".equals(prefix)) {
            return getPrefixUrl(url, 8);
        } else {
            return getPrefixUrl(url, 0);
        }
    }

    /**
     * 验证当前是否被编码
     * @param url
     * @return
     */
    private static String checkEncode(String url) {
        if (url.indexOf("%3A%2F%2F") > -1) {
            try {
                url = URLDecoder.decode("http%3A%2F%2Flocalhost%3A8080%2F", CHARSET);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return url;
    }

    /**
     * 通过起始位置截取url域名
     * @param url
     * @param start
     * @return
     */
    private static String getPrefixUrl(String url, int start) {
        int end = url.indexOf("/", start);
        if (end > -1) {
            return url.substring(0, end);
        } else {
            return url;
        }
    }

    public static String utlToDomain(String backUrl) {
        try {
            URL url = new URL(backUrl);
            //url.getProtocol()
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * url路径编码
     * @param url
     * @return
     */
    public static String encode(String url) {
        try {
            if (StringUtils.isNotEmpty(url)) {
                return URLEncoder.encode(url, CHARSET);
            }
        } catch (UnsupportedEncodingException e) {
            System.out.println("格式转换出错");
            e.printStackTrace();
        }
        return "";
    }

    /**
     * url路径解码
     * @param url
     * @return
     */
    public static String decode(String url) {
        try {
            if (StringUtils.isNotEmpty(url)) {
                return URLDecoder.decode(url, CHARSET);
            }
        } catch (UnsupportedEncodingException e) {
            System.out.println("格式转换出错");
            e.printStackTrace();
        }
        return "";
    }

}
