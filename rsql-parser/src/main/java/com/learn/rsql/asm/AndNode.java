package com.learn.rsql.asm;

import java.util.List;

/**
 * <p> Title: 标题 </p>
 * <pre> Description: 描述 </pre>
 * date: 2019/11/19 20:32
 * <p>
 * Copyright: © 2012-2019 CSG. All rights reserved.
 * Company: CSG
 *
 * @author lu_it:1300815418@qq.com
 * @version V1.0
 * @Package com.learn.rsql
 */
public class AndNode extends ConditionNode {

    public AndNode(List<Node> children) {
        super(ConditionSymbol.AND, children);
    }

    @Override
    public Node withChildren(List<Node> children) {
        return new AndNode(children);
    }

}
