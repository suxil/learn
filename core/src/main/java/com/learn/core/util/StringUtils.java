package com.learn.core.util;

import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/16 0016.
 */
@Slf4j
public final class StringUtils {

    private StringUtils() {
    }

    /**
     * 是否为空
     *
     * StringUtils.isEmpty(null)      = true
     * StringUtils.isEmpty("")        = true
     * StringUtils.isEmpty(" ")       = false
     * StringUtils.isEmpty("bob")     = false
     * StringUtils.isEmpty("  bob  ") = false
     *
     * @param cs
     * @return
     */
    public static boolean isEmpty(final CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    /**
     * 是否不为空
     *
     * StringUtils.isNotEmpty(null)      = false
     * StringUtils.isNotEmpty("")        = false
     * StringUtils.isNotEmpty(" ")       = true
     * StringUtils.isNotEmpty("bob")     = true
     * StringUtils.isNotEmpty("  bob  ") = true
     *
     * @param cs
     * @return
     */
    public static boolean isNotEmpty(final CharSequence cs) {
        return !isEmpty(cs);
    }

    /**
     * 通过字段名称获取get方法名称
     *
     * StringUtils.getGetMethodByField("iFFlag")        = getIFFlag
     * StringUtils.getGetMethodByField("lForeignPort")  = getLForeignPort
     *
     * @param fieldName
     * @return
     */
    public static String getGetMethodByField(String fieldName) {
        return "get" + getFirstUpper(fieldName);
    }

    /**
     * 通过字段名称获set方法名称
     *
     * StringUtils.getSetMethodByField("iFFlag")        = setIFFlag
     * StringUtils.getSetMethodByField("lForeignPort")  = setLForeignPort
     *
     * @param fieldName
     * @return
     */
    public static String getSetMethodByField(String fieldName) {
        return "set" + getFirstUpper(fieldName);
    }

    /**
     * 字符串首字母大写
     *
     * StringUtils.getFirstUp("iFFlag")        = IFFlag
     * StringUtils.getFirstUp("lForeignPort")  = LForeignPort
     *
     * @param string
     * @return
     */
    public static String getFirstUpper(String string) {
        if (isEmpty(string)) {
            return string;
        }
        return String.valueOf(string.charAt(0)).toUpperCase() + string.substring(1);
    }

    /**
     * 字符串首字母小写
     *
     * StringUtils.getFirstUp("IFFlag")        = iFFlag
     * StringUtils.getFirstUp("LForeignPort")  = lForeignPort
     *
     * @param string
     * @return
     */
    public static String getFirstLower(String string) {
        if (isEmpty(string)) {
            return string;
        }
        return String.valueOf(string.charAt(0)).toLowerCase() + string.substring(1);
    }

    /**
     * 通过属性转换为下划线对应的字段
     *
     * StringUtils.getFieldToColumn("iFFlag")        = I_F_FLAG
     * StringUtils.getFieldToColumn("lForeignPort")  = L_FOREIGN_PORT
     *
     * @param column
     * @return
     */
    public static String getFieldToColumn(String column) {
        if (isNotEmpty(column)) {
            int idx = 0;
            String field = "";
            for (int i = 1; i < column.length(); i++) {
                if (64 < column.charAt(i) && column.charAt(i) < 91) {
                    field += column.substring(idx, i) + "_";
                    idx = i;
                }
            }
            field += column.substring(idx, column.length());
            return field.toUpperCase();
        }
        return column;
    }

    /**
     * 通过字段转换为除第一个字符外首字母大写对应的属性
     *
     * StringUtils.getColumnToField("I_F_FLAG")        = iFFlag
     * StringUtils.getColumnToField("L_FOREIGN_PORT")  = lForeignPort
     *
     * @param field
     * @return
     */
    public static String getColumnToField(String field) {
        if (isNotEmpty(field)) {
            String[] strs = field.toLowerCase().split("_");
            if (strs.length > 0) {
                String column = strs[0];
                for (int i = 1; i < strs.length; i++) {
                    column += String.valueOf(strs[i].charAt(0)).toUpperCase() + strs[i].substring(1, strs[i].length());
                }
                return column;
            }
        }
        return field;
    }

    /**
     * 移除末尾的prefix字符串
     * @param val
     * @param prefix
     * @return
     */
    public static String removeLastPrefix(String val, String prefix) {
        if (isNotEmpty(prefix) && val.lastIndexOf(prefix) > 0) {
            return val.substring(0, val.length() - prefix.length());
        }
        return val;
    }

    /**
     * 补零，长度为4位
     * @param val
     * @return
     */
    public static String formatNo(String val) {
        if (isEmpty(val)) {
            return formatNo(4, 0);
        }
        return formatNo(4, Integer.parseInt(val));
    }

    /**
     * 补零，长度为4位
     * @param val
     * @return
     */
    public static String formatNo(int val) {
        return formatNo(4, val);
    }

    /**
     * 补零
     * @param num
     * @param val
     * @return
     */
    public static String formatNo(int num, int val) {
        return String.format("%0" + num + "d", val);
    }

    /**
     * 通过prefix连接字符串数组
     * @param list
     * @param regex
     * @return
     */
    public static String join(List<String> list, String regex) {
        return join(list.toArray(), regex);
    }

    /**
     * 通过prefix连接字符串数组
     * @param objects
     * @param regex
     * @return
     */
    public static String join(Object[] objects, String regex) {
        StringBuilder builder = new StringBuilder();
        for (Object obj : objects) {
            builder.append(obj.toString() + regex);
        }
        if (builder.length() > regex.length()) {
            builder.setLength(builder.length() - regex.length());
        }
        return builder.toString();
    }

    /**
     * 将字符串通过regex并转换为list
     * @param string
     * @param regex
     * @return
     */
    public static List<String> convert(String string, String regex) {
        if (isNotEmpty(string)) {
            List<String> list = new ArrayList<>();
            for (String str : string.split(regex)) {
                if (isNotEmpty(str)) {
                    list.add(str);
                }
            }
            return list;
        }
        return null;
    }

    /**
     * 获取多个重复字符串
     * @param num
     * @param str
     * @return
     */
    public static String getRepeatStr(int num, String str) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < num; i ++) {
            builder.append(str);
        }
        return builder.toString();
    }

    /**
     * 计算text的长度（一个中文算两个字符）
     * @param text
     * @return
     */
    public static int getLength(String text) {
        int length = 0;
        for (int i = 0; i < text.length(); i++) {
            if (String.valueOf(text.charAt(i)).getBytes().length > 1) {
                length += 2;
            } else {
                length += 1;
            }
        }
        return length / 2;
    }

    /**
     * 编码文件名
     * @param fileName
     * @return
     */
    public static String encodeFileName(String fileName) {
        return encodeFileName("", fileName);
    }

    /**
     * 编码文件名
     * @param bowser
     * @param fileName
     * @return
     */
    public static String encodeFileName(String bowser, String fileName) {
        try {
            switch (bowser) {
                case "FF":
                    // 火狐浏览器 设置编码new String(realName.getBytes("GB2312"), "ISO-8859-1");
                    fileName = new String(fileName.getBytes("GB2312"), "ISO-8859-1");
                    break;
                default:
                    fileName = URLEncoder.encode(fileName, "UTF-8");//encode编码UTF-8 解决大多数中文乱码
                    fileName = fileName.replace("+", "%20");//encode后替换空格  解决空格问题
                    break;
            }
        } catch (UnsupportedEncodingException e) {
            log.error("encode file name: " + e.getMessage());
        }
        return fileName;
    }

    /**
     * url地址追加参数
     * @param url
     * @param key
     * @param val
     * @return
     */
    public static String appendParam(String url, String key, String val) {
        if (url.indexOf("?") > -1) {
            url += "&";
        } else {
            url += "?";
        }
        return url  + key + "=" + val;
    }

}
