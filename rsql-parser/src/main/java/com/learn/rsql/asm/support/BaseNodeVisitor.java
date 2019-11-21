package com.learn.rsql.asm.support;

import com.learn.rsql.asm.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * <p> Title: 标题 </p>
 * <pre> Description: 描述 </pre>
 * date: 2019/11/20 22:26
 * <p>
 * Copyright: © 2012-2019 CSG. All rights reserved.
 * Company: CSG
 *
 * @author lu_it:1300815418@qq.com
 * @version V1.0
 * @Package com.learn.rsql.visit
 */
public abstract class BaseNodeVisitor<R, P> implements NodeVisitor<R, P> {

    protected List<R> handlerChildren(List<Node> nodeList, P param) {
        return handlerChildren(nodeList, param, null);
    }

    protected List<R> handlerChildren(List<Node> nodeList, P param, Consumer<P> consumer) {
        List<R> result = new ArrayList<>();
        if (nodeList == null || nodeList.size() == 0) {
            return result;
        }

        for (Node itemNode : nodeList) {
            if (itemNode instanceof OrNode) {
                result.add(visit((OrNode) itemNode, param));
            } else if (itemNode instanceof AndNode) {
                result.add(visit((AndNode) itemNode, param));
            } else if (itemNode instanceof WhereNode) {
                result.add(visit((WhereNode) itemNode, param));
            }
            if (consumer != null) consumer.accept(param);
        }

        return result;
    }

}
