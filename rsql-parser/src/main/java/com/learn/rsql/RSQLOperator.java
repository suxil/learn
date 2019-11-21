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

    public static final String EQ = "=="; // 相等
    public static final String NEQ = "!="; // 不相等
    public static final String GT = "=gt="; // 大于
    public static final String GT2 = ">"; // 大于
    public static final String GE = "=ge="; // 大于等于
    public static final String GE2 = ">="; // 大于等于
    public static final String LT = "=lt="; // 小于
    public static final String LT2 = "<"; // 小于
    public static final String LE = "=le="; // 小于等于
    public static final String LE2 = "<="; // 小于等于
    public static final String NULL = "=nu="; // 为null
    public static final String NOT_NULL = "=nnu="; // 不为null
    public static final String LIKE = "=li="; // 模糊查询
    public static final String NOT_LIKE = "=nli="; // 非模糊查询
    public static final String L_LIKE = "=lli="; // 左模糊查询
    public static final String R_LIKE = "=rli="; // 右模糊查询
    public static final String IN = "=in="; // in查询
    public static final String OUT = "=out=";  //或者

    public static final WhereOperator EQ_OP = new WhereOperator(EQ);
    public static final WhereOperator NEQ_OP = new WhereOperator(NEQ);
    public static final WhereOperator GT_OP = new WhereOperator(GT, GT2);
    public static final WhereOperator GE_OP = new WhereOperator(GE, GE2);
    public static final WhereOperator LT_OP = new WhereOperator(LT, LT2);
    public static final WhereOperator LE_OP = new WhereOperator(LE, LE2);
    public static final WhereOperator NULL_OP = new WhereOperator(NULL);
    public static final WhereOperator NOT_NULL_OP = new WhereOperator(NOT_NULL);
    public static final WhereOperator LIKE_OP = new WhereOperator(LIKE);
    public static final WhereOperator NOT_LIKE_OP = new WhereOperator(NOT_LIKE);
    public static final WhereOperator L_LIKE_OP = new WhereOperator(L_LIKE);
    public static final WhereOperator R_LIKE_OP = new WhereOperator(R_LIKE);
    public static final WhereOperator IN_OP = new WhereOperator(IN, true);
    public static final WhereOperator OUT_OP = new WhereOperator(OUT, true);

    public static Set<WhereOperator> defaultOperator() {
        List<WhereOperator> operatorList = Arrays.asList(EQ_OP, NEQ_OP, GT_OP, GE_OP, LT_OP, LE_OP, NULL_OP, NOT_NULL_OP, LIKE_OP, NOT_LIKE_OP, L_LIKE_OP, R_LIKE_OP, IN_OP, OUT_OP);
        return new HashSet<>(operatorList);
    }

}
