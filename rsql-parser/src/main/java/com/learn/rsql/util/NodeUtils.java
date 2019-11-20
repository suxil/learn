package com.learn.rsql.util;

import com.learn.rsql.asm.WhereNode;
import com.learn.rsql.exception.GlobalCommonException;

import java.util.List;

/**
 * <p> Title: 标题 </p>
 * <pre> Description: 描述 </pre>
 * date: 2019/11/20 22:35
 * <p>
 * Copyright: © 2012-2019 CSG. All rights reserved.
 * Company: CSG
 *
 * @author lu_it:1300815418@qq.com
 * @version V1.0
 * @Package com.learn.rsql.util
 */
public class NodeUtils {

    private static String getJdbcOperate(String op) {
        switch (op) {
            case "==":
                return " = ";
            case "!=":
                return " != ";
            case "=gt=":
            case ">":
                return " > ";
            case "=ge=":
            case ">=":
                return " >= ";
            case "=lt=":
            case "<":
                return " < ";
            case "=le=":
            case "<=":
                return " <= ";
            case "=in=":
                return " in ";
            case "=out=":
                return " not int ";
            default: throw new GlobalCommonException("not fund operate");
        }
    }

    public static String getJdbcWhere(WhereNode whereNode) {
        String value = String.format("'%s'", StringUtils.join(whereNode.getValue(), "','"));
        if (whereNode.getOperator().isMultiValue()) {
            value = String.format("(%s)", value);
        }

        String fieldName = whereNode.getFieldName();
        String operate = getJdbcOperate(whereNode.getOperator().getSymbolStr());

        return fieldName + operate + value;
    }

    public static String getJdbcMultiWhere(List<String> whereList, String symbol) {
        return whereList != null && whereList.size() > 0 ? String.format("(%s)", StringUtils.join(whereList, String.format(" %s ", symbol))) : "";
    }

}
