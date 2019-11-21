package com.learn.rsql;


import com.learn.rsql.asm.Node;
import com.learn.rsql.parser.RSQLParser;

public class RSQLUtils {

    public static final RSQLParser RSQL_PARSER = new RSQLParser();

    public static Node parse(String search) {
        return RSQL_PARSER.parse(search);
    }

}
