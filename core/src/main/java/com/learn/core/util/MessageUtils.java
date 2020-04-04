package com.learn.core.util;

import com.learn.core.consumer.SpringContextHolder;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

/**
 * <p> Title: 标题 </p>
 * <pre> Description: spring i18n 文件消息获取 </pre>
 * date: 2020/4/4 16:42
 * <p>
 * Copyright: © 2012-2020 . All rights reserved.
 * Company:
 *
 * @author lu_it
 * @version V1.0
 * @Package com.learn.core.util
 */
public final class MessageUtils {

    public static MessageSource getMessageSource() {
        return SpringContextHolder.getBean(MessageSource.class);
    }

    public static String getMessage(String code, Object... args) {
        if (args == null) {
            args = new Object[0];
        }
        return getMessageSource().getMessage(code, args, LocaleContextHolder.getLocale());
    }

}
