package com.learn.rsql.exception;

/**
 * <p> Title: 标题 </p>
 * <pre> Description: 描述 </pre>
 * date: 2019/11/20
 * <p>
 * Copyright: © 2012-2019 CSG. All rights reserved.
 * Company: CSG
 *
 * @author lu_it:1300815418@qq.com
 * @version V1.0
 * @Package com.learn.rsql.exception
 */
public class RSQLCommonException extends RuntimeException {

    public RSQLCommonException() {

    }

    public RSQLCommonException(String message) {
        super(message);
    }

    public RSQLCommonException(String message, Throwable cause) {
        super(message, cause);
    }

    public RSQLCommonException(Throwable cause) {
        super(cause);
    }

}
