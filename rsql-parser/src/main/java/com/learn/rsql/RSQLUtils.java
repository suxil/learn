package com.learn.rsql;


import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.learn.rsql.asm.*;
import com.learn.rsql.asm.support.DefaultJdbcNodeVisitor;
import com.learn.rsql.asm.support.DefaultMybatisPlusNodeVisitor;
import com.learn.rsql.parser.RSQLParser;

public class RSQLUtils {

    public static final RSQLParser RSQL_PARSER = new RSQLParser();

    public static Node parse(String search) {
        return RSQL_PARSER.parse(search);
    }

    public static String parseJdbc(String search) {
        return parseJdbc(new DefaultJdbcNodeVisitor(), search);
    }

    public static String parseJdbc(NodeVisitor<String, Void> visitor, String search) {
        Node node = parse(search);

        String result = "";

        if (node instanceof AndNode) {
            result = visitor.visit((AndNode) node, null);
        } else if (node instanceof OrNode) {
            result = visitor.visit((OrNode) node, null);
        } else if (node instanceof WhereNode) {
            result = visitor.visit((WhereNode) node, null);
        }

        return result;
    }

    public static void parseMybatisPlus(String search, AbstractWrapper abstractWrapper) {
        parseMybatisPlus(new DefaultMybatisPlusNodeVisitor(), search, abstractWrapper);
    }

    public static void parseMybatisPlus(NodeVisitor<Void, AbstractWrapper> visitor, String search, AbstractWrapper abstractWrapper) {
        Node node = parse(search);

        if (node instanceof AndNode) {
            visitor.visit((AndNode) node, abstractWrapper);
        } else if (node instanceof OrNode) {
            visitor.visit((OrNode) node, abstractWrapper);
        } else if (node instanceof WhereNode) {
            visitor.visit((WhereNode) node, abstractWrapper);
        }
    }

}
