package com.learn.rsql.asm.support;

import com.learn.rsql.RSQLOperator;
import com.learn.rsql.asm.*;
import com.learn.rsql.util.StringUtils;

import java.util.List;

/**
 * <p> Title: 标题 </p>
 * <pre> Description: 描述 </pre>
 * date: 2019/11/20 21:18
 * <p>
 * Copyright: © 2012-2019 CSG. All rights reserved.
 * Company: CSG
 *
 * @author lu_it:1300815418@qq.com
 * @version V1.0
 * @Package com.learn.rsql.visit
 */
public class DefaultJdbcNodeVisitor extends BaseNodeVisitor<String, Void> {

    public String visitOrAndNode(List<Node> nodeList, ConditionSymbol conditionSymbol, Void param) {
        List<String> result = handlerChildren(nodeList, param);

        if (result != null && result.size() > 0) {
            String symbol = conditionSymbol.name();
            return String.format("(%s)", StringUtils.join(result, String.format(" %s ", symbol)));
        }
        return "";
    }

    @Override
    public String visit(OrNode node, Void param) {
        return visitOrAndNode(node.getChildren(), node.getConditionSymbol(), param);
    }

    @Override
    public String visit(AndNode node, Void param) {
        return visitOrAndNode(node.getChildren(), node.getConditionSymbol(), param);
    }

    @Override
    public String visit(WhereNode node, Void param) {
        String fieldName = node.getFieldName();

        String value = String.format("'%s'", StringUtils.join(node.getValue(), "','"));
        if (node.getOperator().isMultiValue()) {
            value = String.format("(%s)", value);
        }

        switch (node.getOperator().getSymbolStr()) {
            case RSQLOperator.EQ:
                return fieldName + " = " + value;
            case RSQLOperator.NEQ:
                return fieldName + " != " + value;
            case RSQLOperator.GT:
            case RSQLOperator.GT2:
                return fieldName + " > " + value;
            case RSQLOperator.GE:
            case RSQLOperator.GE2:
                return fieldName + " >= " + value;
            case RSQLOperator.LT:
            case RSQLOperator.LT2:
                return fieldName + " < " + value;
            case RSQLOperator.LE:
            case RSQLOperator.LE2:
                return fieldName + " <= " + value;
            case RSQLOperator.NULL:
                return fieldName + " is null ";
            case RSQLOperator.NOT_NULL:
                return fieldName + " is not null ";
            case RSQLOperator.LIKE:
                return fieldName + " like " + "'%" + StringUtils.join(node.getValue(), "") + "%'";
            case RSQLOperator.NOT_LIKE:
                return fieldName + " not like " + "'%" + StringUtils.join(node.getValue(), "") + "%'";
            case RSQLOperator.L_LIKE:
                return fieldName + " like " + "'%" + StringUtils.join(node.getValue(), "") + "'";
            case RSQLOperator.R_LIKE:
                return fieldName + " like " + "'" + StringUtils.join(node.getValue(), "") + "%'";
            case RSQLOperator.IN:
                return fieldName + " in " + value;
            case RSQLOperator.OUT:
                return fieldName + " not in " + value;
        }

        return "";
    }

}
