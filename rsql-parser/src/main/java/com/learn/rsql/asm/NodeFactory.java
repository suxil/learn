package com.learn.rsql.asm;

import com.learn.rsql.exception.GlobalCommonException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p> Title: 标题 </p>
 * <pre> Description: 描述 </pre>
 * date: 2019/11/19 21:28
 * <p>
 * Copyright: © 2012-2019 CSG. All rights reserved.
 * Company: CSG
 *
 * @author lu_it:1300815418@qq.com
 * @version V1.0
 * @Package com.learn.rsql
 */
public class NodeFactory {

    private final Map<String, WhereOperator> whereOperatorMap;

    public NodeFactory(Set<WhereOperator> whereOperatorSet) {
        this.whereOperatorMap = new HashMap<>(whereOperatorSet.size());

        for (WhereOperator operator : whereOperatorSet) {
            for (String s : operator.getSymbol()) {
                whereOperatorMap.put(s, operator);
            }
        }
    }

    public Node createConditionNode(ConditionSymbol conditionSymbol, List<Node> nodeList) {
        switch (conditionSymbol) {
            case OR: return new OrNode(nodeList);
            case AND: return new AndNode(nodeList);
            default: throw new GlobalCommonException();
        }
    }

    public WhereNode createWhereNode(String fieldName, String operate, List<String> value) {
        WhereOperator whereOperator = whereOperatorMap.get(operate);
        if (whereOperator == null) {
            throw new GlobalCommonException();
        }
        return new WhereNode(whereOperator, fieldName, value);
    }

}
