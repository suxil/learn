package com.learn.generator.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 列别名，如：数据库查询字段名与实体对应字段名不一致时添加
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ColumnAlias {
	
	String id() default "";//主键列名,返回id节点
	String value();//查询列别名,返回result节点
	
}
