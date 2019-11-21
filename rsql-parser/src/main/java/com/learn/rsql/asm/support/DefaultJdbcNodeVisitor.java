package com.learn.rsql.asm.support;

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
            case "==":
                return fieldName + " = " + value;
            case "!=":
                return fieldName + " != " + value;
            case "=gt=":
            case ">":
                return fieldName + " > " + value;
            case "=ge=":
            case ">=":
                return fieldName + " >= " + value;
            case "=lt=":
            case "<":
                return fieldName + " < " + value;
            case "=le=":
            case "<=":
                return fieldName + " <= " + value;
            case "=nu=":
                return fieldName + " is null ";
            case "=nnu=":
                return fieldName + " is not null ";
            case "=in=":
                return fieldName + " in " + value;
            case "=out=":
                return fieldName + " not in " + value;
        }

        return "";
    }

}
