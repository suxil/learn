package io.github.suxil.dict.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 启用数据字典转换
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface DictEnable {

    /**
     * 是否启用数据字典转换
     * @return
     */
    boolean value() default true;

}
