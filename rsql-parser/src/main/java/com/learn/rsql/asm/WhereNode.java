package com.learn.rsql.asm;

import com.learn.rsql.util.Assert;
import com.learn.rsql.util.StringUtils;

import java.util.List;

/**
 * <p> Title: 标题 </p>
 * <pre> Description: 描述 </pre>
 * date: 2019/11/19 23:10
 * <p>
 * Copyright: © 2012-2019 CSG. All rights reserved.
 * Company: CSG
 *
 * @author lu_it:1300815418@qq.com
 * @version V1.0
 * @Package com.learn.rsql.asm
 */
public class WhereNode implements Node {

    private final WhereOperator operator;
    private final String fieldName;
    private final List<String> value;

    public WhereNode(WhereOperator operator, String fieldName, List<String> value) {
        Assert.notNull(operator, "operator must not be null");
        Assert.hasText(fieldName, "fieldName must not be text");
        Assert.notEmpty(value, "value list must not be empty");

        this.operator = operator;
        this.fieldName = fieldName;
        this.value = value;
    }

    public WhereOperator getOperator() {
        return operator;
    }

    public String getFieldName() {
        return fieldName;
    }

    public List<String> getValue() {
        return value;
    }

    @Override
    public String toString() {
        String valueStr = value.size() > 1 ? "('" + StringUtils.join(value, "','") + "')": "'" + value.get(0) + "'";
        return fieldName + operator + valueStr;
    }

}
