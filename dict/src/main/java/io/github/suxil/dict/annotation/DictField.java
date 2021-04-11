package io.github.suxil.dict.annotation;

import io.github.suxil.dict.constant.DictConstant;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 字典转换字段
 * 该注解使用在需要转换的字段上
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
public @interface DictField {

    /**
     * 默认缓存类型（数据字典）
     * @return
     */
    String key() default DictConstant.DICT_KEY;

    /**
     * 字典类别
     */
    String category();

    /**
     * 字段名称
     * 当字段为空时，使用当前字段属性名
     * @return
     */
    String fieldName() default "";

    /**
     * 目标字段名称
     * @return
     */
    String targetFieldName();

}
