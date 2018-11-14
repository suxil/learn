package com.learn.core.utils;

import com.learn.core.dto.SearchType;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: luxq
 * @Description: 基础查询参数处理工具类
 * @Date: Created in 2018/4/13 0013 17:17
 */
public class ParamUtils {

    private static final String LINK_CHAR = "_"; // 查询规则连接符

    public static final String EQ = "eq"; // 相等
    public static final String NOT = "not"; // 不相等
    public static final String NE = "ne"; // 不相等
    public static final String NEQ = "neq"; // 不相等
    public static final String GT = "gt"; // 大于
    public static final String LT = "lt"; // 小于
    public static final String GTE = "gte"; // 大于等于
    public static final String GE = "ge"; // 大于等于
    public static final String LTE = "lte"; // 小于等于
    public static final String LE = "le"; // 小于等于
    public static final String NULL = "null"; // 为null
    public static final String LIKE = "like"; // 左模糊查询
    public static final String L_LIKE = "llike"; // 左模糊查询
    public static final String R_LIKE = "rlike"; // 右模糊查询
    public static final String IN = "in"; // in查询
    public static final String OR = "or";  //或者

    public static final List<String> RULE = Arrays.asList(EQ, NOT, NE, NEQ, GT, LT, GTE, GE, LTE, LE, NULL, LIKE, L_LIKE, R_LIKE, IN, OR);

    /**
     * 通过参数名，返回是否查询条件
     * @param param
     * @return
     */
    public static SearchType getFieldName(String param) {
        if (StringUtils.isNotEmpty(param)) {
            SearchType type = new SearchType();
            if (param.lastIndexOf(LINK_CHAR) < 0) {
                type.setField(param);
                type.setType(EQ);
                type.setSearch(true);
            } else {
                for (String rule : RULE) {
                    if (param.lastIndexOf(LINK_CHAR + rule) > 0) {
                        String field = param.substring(0, param.length() - (rule.length() + LINK_CHAR.length()));
                        type.setField(field);
                        type.setType(rule);
                        type.setSearch(true);
                        switch (rule) {
                            case EQ:
                                break;
                            case NOT:
                            case NE:
                            case NEQ:
                                break;
                            case GT:
                                break;
                            case LT:
                                break;
                            case GTE:
                            case GE:
                                break;
                            case LTE:
                            case LE:
                                break;
                            case NULL:
                                break;
                            case LIKE:
                                type.setLeft("%");
                                type.setRight("%");
                                break;
                            case L_LIKE:
                                type.setLeft("%");
                                break;
                            case R_LIKE:
                                type.setRight("%");
                                break;
                            case OR:
                                break;
                            case IN:
                                break;
                            default:
                                break;
                        }
                        break;
                    }
                }
            }
            return type;
        }
        return null;
    }

}
