package com.learn.core.exception;

/**
 * <p> Title: 标题 </p>
 * <pre> Description: 描述 </pre>
 * date: 2019/11/21 22:38
 * <p>
 * Copyright: © 2012-2019 CSG. All rights reserved.
 * Company: CSG
 *
 * @author lu_it:1300815418@qq.com
 * @version V1.0
 * @Package com.learn.core.exception
 */
public class GlobalCommonException extends RuntimeException {

    public GlobalCommonException() {
    }

    public GlobalCommonException(String message) {
        super(message);
    }

    public GlobalCommonException(String message, Throwable cause) {
        super(message, cause);
    }

    public GlobalCommonException(Throwable cause) {
        super(cause);
    }

}
