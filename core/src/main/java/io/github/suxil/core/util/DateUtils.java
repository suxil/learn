package io.github.suxil.core.util;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.util.Date;

/**
 * Created by Administrator on 2017/9/16 0016.
 */
@Slf4j
public final class DateUtils {

    private DateUtils() {
    }

    private static String[] parsePatterns = {
            "yyyy-MM-dd",
            "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM", "yyyy/MM/dd",
            "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM", "yyyy.MM.dd",
            "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"
    };

    /**
     * 字符串转日期类型
     * @param value
     * @return
     */
    public static Date parseDate(String value) {
        try {
            return org.apache.commons.lang3.time.DateUtils.parseDate(value, parsePatterns);
        } catch (ParseException e) {
            log.error("parseDate: " + e.getMessage());
        }
        return null;
    }

}
