package com.learn.rsql;

import com.learn.rsql.asm.WhereOperator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p> Title: 标题 </p>
 * <pre> Description: 描述 </pre>
 * date: 2019/11/20 19:57
 * <p>
 * Copyright: © 2012-2019 CSG. All rights reserved.
 * Company: CSG
 *
 * @author lu_it:1300815418@qq.com
 * @version V1.0
 * @Package com.learn.rsql
 */
public class RSQLOperator {

    public static final WhereOperator EQUAL = new WhereOperator("==");
    public static final WhereOperator NOT_EQUAL = new WhereOperator("!=");
    public static final WhereOperator GREATER_THAN = new WhereOperator("=gt=", ">");
    public static final WhereOperator GREATER_THAN_OR_EQUAL = new WhereOperator("=ge=", ">=");
    public static final WhereOperator LESS_THAN = new WhereOperator("=lt=", "<");
    public static final WhereOperator LESS_THAN_OR_EQUAL = new WhereOperator("=le=", "<=");
    public static final WhereOperator IS_NULL = new WhereOperator("=nu=");
    public static final WhereOperator IS_NOT_NULL = new WhereOperator("=nnu=");
    public static final WhereOperator IN = new WhereOperator("=in=", true);
    public static final WhereOperator NOT_IN = new WhereOperator("=out=", true);

    public static Set<WhereOperator> defaultOperator() {
        List<WhereOperator> operatorList = Arrays.asList(EQUAL, NOT_EQUAL, GREATER_THAN, GREATER_THAN_OR_EQUAL, LESS_THAN, LESS_THAN_OR_EQUAL, IS_NULL, IS_NOT_NULL, IN, NOT_IN);
        return new HashSet<>(operatorList);
    }

}
