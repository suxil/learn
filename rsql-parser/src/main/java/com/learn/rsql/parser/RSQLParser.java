package com.learn.rsql.parser;

import com.learn.rsql.RSQLOperator;
import com.learn.rsql.asm.Node;
import com.learn.rsql.asm.NodeFactory;
import com.learn.rsql.asm.WhereOperator;
import com.learn.rsql.asm.support.DefaultNodeFactory;
import com.learn.rsql.exception.RSQLCommonException;
import com.learn.rsql.util.Assert;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Set;

/**
 * <p> Title: 标题 </p>
 * <pre> Description: 描述 </pre>
 * date: 2019/11/19 21:11
 * <p>
 * Copyright: © 2012-2019 CSG. All rights reserved.
 * Company: CSG
 *
 * @author lu_it:1300815418@qq.com
 * @version V1.0
 * @Package com.learn.rsql
 */
public class RSQLParser {

    private static final Charset ENCODING = StandardCharsets.UTF_8;

    private final NodeFactory nodeFactory;

    public RSQLParser() {
        this(RSQLOperator.defaultOperator());
    }

    public RSQLParser(Set<WhereOperator> whereOperatorSet) {
        if (whereOperatorSet == null || whereOperatorSet.isEmpty()) {
            throw new RSQLCommonException("operator must not be null or empty");
        }

        nodeFactory = new DefaultNodeFactory(whereOperatorSet);
    }

    public RSQLParser(NodeFactory nodeFactory) {
        this.nodeFactory = nodeFactory;
    }

    public Node parse(String search) {
        Assert.notNull(search, "search must not be null");

        InputStream inputStream = new ByteArrayInputStream(search.getBytes(ENCODING));
        Parser parser = new Parser(inputStream, ENCODING.name(), nodeFactory);

        try {
            return parser.parse();
        } catch (Exception e) {
            throw new RSQLCommonException("parse resolve error");
        }
    }

}
