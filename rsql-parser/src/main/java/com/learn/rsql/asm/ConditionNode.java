package com.learn.rsql.asm;

import com.learn.rsql.util.StringUtils;

import java.util.List;
import java.util.Objects;

/**
 * <p> Title: 标题 </p>
 * <pre> Description: 描述 </pre>
 * date: 2019/11/19 21:00
 * <p>
 * Copyright: © 2012-2019 CSG. All rights reserved.
 * Company: CSG
 *
 * @author lu_it:1300815418@qq.com
 * @version V1.0
 * @Package com.learn.rsql
 */
public abstract class ConditionNode implements Node {

    private final ConditionSymbol conditionSymbol;
    private final List<Node> children;

    public ConditionNode(ConditionSymbol conditionSymbol, List<Node> children) {
        this.conditionSymbol = conditionSymbol;
        this.children = children;
    }

    public ConditionSymbol getConditionSymbol() {
        return conditionSymbol;
    }

    public List<Node> getChildren() {
        return children;
    }

    public abstract Node withChildren(List<Node> children);

    @Override
    public String toString() {
        return "(" + StringUtils.join(children, conditionSymbol.toString()) + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ConditionNode)) return false;
        ConditionNode that = (ConditionNode) o;
        return Objects.equals(conditionSymbol, that.conditionSymbol) &&
                Objects.equals(children, that.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(conditionSymbol, children);
    }

}
