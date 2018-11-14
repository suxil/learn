package com.learn.core.anotation;

import java.lang.annotation.*;

/**
 * Created by Administrator on 2017/5/18 0018.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Documented
public @interface BaseWhere {
    String value() default "";
}
