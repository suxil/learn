package com.learn.generator.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 合并sp方法和替换参数
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface GeneratorMergeSp {

	String[] ids() default {};//合并sp的id
	String[] paramField() default {};//合并哪些字段
	boolean isList() default true;//是否是结合子节点，默认true
	ReplaceParam[] replaceParam() default {};//替换参数，只有isList是true时生效
	
}
