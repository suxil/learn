package com.learn.rsql.asm;

import java.util.List;

/**
 * <p> Title: 标题 </p>
 * <pre> Description: 描述 </pre>
 * date: 2019/11/19 21:28
 * <p>
 * Copyright: © 2012-2019 CSG. All rights reserved.
 * Company: CSG
 *
 * @author lu_it
 * @version V1.0
 * @Package com.learn.rsql
 */
public interface NodeFactory {

    Node createConditionNode(ConditionSymbol conditionSymbol, List<Node> nodeList);

    WhereNode createWhereNode(String fieldName, String operate, List<String> value);

}
