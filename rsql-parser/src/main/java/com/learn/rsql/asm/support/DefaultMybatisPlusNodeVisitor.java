package com.learn.rsql.asm.support;

import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.interfaces.Join;
import com.learn.rsql.asm.AndNode;
import com.learn.rsql.asm.OrNode;
import com.learn.rsql.asm.WhereNode;
import com.learn.rsql.util.StringUtils;

import java.util.function.Consumer;

/**
 * <p> Title: 标题 </p>
 * <pre> Description: 描述 </pre>
 * date: 2019/11/21
 * <p>
 * Copyright: © 2012-2019 CSG. All rights reserved.
 * Company: CSG
 *
 * @author lu_it:1300815418@qq.com
 * @version V1.0
 * @Package com.learn.rsql.asm.support
 */
public class DefaultMybatisPlusNodeVisitor extends BaseNodeVisitor<Void, AbstractWrapper> {

    private static final Consumer<AbstractWrapper> OR_NODE_CONSUMER = (Join::or);

    @Override
    public Void visit(OrNode node, AbstractWrapper wrapper) {
        wrapper.or(childWrapper -> {
            handlerChildren(node.getChildren(), (AbstractWrapper) childWrapper, OR_NODE_CONSUMER);
            return childWrapper;
        });
        return null;
    }

    @Override
    public Void visit(AndNode node, AbstractWrapper wrapper) {
        wrapper.and(childWrapper -> {
            handlerChildren(node.getChildren(), (AbstractWrapper) childWrapper);
            return childWrapper;
        });
        return null;
    }

    @Override
    public Void visit(WhereNode node, AbstractWrapper wrapper) {
        String fieldName = node.getFieldName();

        String value = StringUtils.join(node.getValue(), ",");

        switch (node.getOperator().getSymbolStr()) {
            case "==":
                wrapper.eq(fieldName, value);
                break;
            case "!=":
                wrapper.ne(fieldName, value);
                break;
            case "=gt=":
            case ">":
                wrapper.gt(fieldName, value);
                break;
            case "=ge=":
            case ">=":
                wrapper.ge(fieldName, value);
                break;
            case "=lt=":
            case "<":
                wrapper.lt(fieldName, value);
                break;
            case "=le=":
            case "<=":
                wrapper.le(fieldName, value);
                break;
            case "=nu=":
                wrapper.isNull(fieldName);
                break;
            case "=nnu=":
                wrapper.isNotNull(fieldName);
                break;
            case "=in=":
                wrapper.in(fieldName, node.getValue());
                break;
            case "=out=":
                wrapper.notIn(fieldName, node.getValue());
                break;
        }

        return null;
    }

}
