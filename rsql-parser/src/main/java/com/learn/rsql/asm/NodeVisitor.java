package com.learn.rsql.asm;

/**
 * <p> Title: 标题 </p>
 * <pre> Description: 描述 </pre>
 * date: 2019/11/20 21:16
 * <p>
 *
 * @author lu_it
 * @version V1.0
 * @Package com.learn.rsql.visit
 */
public interface NodeVisitor<R, P> {

    R visit(OrNode node, P param);

    R visit(AndNode node, P param);

    R visit(WhereNode node, P param);

}
