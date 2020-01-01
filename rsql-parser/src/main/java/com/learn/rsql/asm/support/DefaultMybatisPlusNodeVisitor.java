package com.learn.rsql.asm.support;

import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.interfaces.Join;
import com.learn.rsql.RSQLOperator;
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
 *
 * @author lu_it
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
            case RSQLOperator.EQ:
                wrapper.eq(fieldName, value);
                break;
            case RSQLOperator.NEQ:
                wrapper.ne(fieldName, value);
                break;
            case RSQLOperator.GT:
            case RSQLOperator.GT2:
                wrapper.gt(fieldName, value);
                break;
            case RSQLOperator.GE:
            case RSQLOperator.GE2:
                wrapper.ge(fieldName, value);
                break;
            case RSQLOperator.LT:
            case RSQLOperator.LT2:
                wrapper.lt(fieldName, value);
                break;
            case RSQLOperator.LE:
            case RSQLOperator.LE2:
                wrapper.le(fieldName, value);
                break;
            case RSQLOperator.NULL:
                wrapper.isNull(fieldName);
                break;
            case RSQLOperator.NOT_NULL:
                wrapper.isNotNull(fieldName);
                break;
            case RSQLOperator.LIKE:
                wrapper.like(fieldName, value);
                break;
            case RSQLOperator.NOT_LIKE:
                wrapper.notLike(fieldName, value);
                break;
            case RSQLOperator.L_LIKE:
                wrapper.likeLeft(fieldName, value);
                break;
            case RSQLOperator.R_LIKE:
                wrapper.likeRight(fieldName, value);
                break;
            case RSQLOperator.IN:
                wrapper.in(fieldName, node.getValue());
                break;
            case RSQLOperator.OUT:
                wrapper.notIn(fieldName, node.getValue());
                break;
        }

        return null;
    }

}
