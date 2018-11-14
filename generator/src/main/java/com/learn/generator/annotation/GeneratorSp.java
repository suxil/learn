package com.learn.generator.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * sp及对应方法
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface GeneratorSp {

	String value();//sp名
	String name();//方法名，唯一
	String desc() default "";//方法描述
	String[] param();//参数，String类型（sp中用到的参数）
	String[] otherParam() default {};//其他参数（方法中多添加的参数），String类型
	String returnType() default "";//返回类型
	Class<?> clazzType();//对应实体类型
	ReplaceParam[] iterParam() default {};//遍历对象时，定义的临时变量
	GeneratorMergeSp[] mergeType() default {};//对应子查询类型
	
}
