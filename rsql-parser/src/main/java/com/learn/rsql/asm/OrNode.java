package com.learn.rsql.asm;

import java.util.List;

/**
 * <p> Title: 标题 </p>
 * <pre> Description: 描述 </pre>
 * date: 2019/11/19 20:31
 * <p>
 *
 * @author lu_it
 * @version V1.0
 * @Package com.learn.rsql
 */
public class OrNode extends ConditionNode {

    public OrNode(List<Node> children) {
        super(ConditionSymbol.OR, children);
    }

    @Override
    public Node withChildren(List<Node> children) {
        return new OrNode(children);
    }

}
