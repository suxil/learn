package com.learn.rsql;

import com.learn.rsql.asm.AndNode;
import com.learn.rsql.asm.Node;
import com.learn.rsql.visit.suport.DefaultJdbcRSQLNodeVisitor;
import com.learn.rsql.visit.RSQLNodeVisitor;
import org.junit.Test;

/**
 * <p> Title: 标题 </p>
 * <pre> Description: 描述 </pre>
 * date: 2019/11/20 21:21
 * <p>
 * Copyright: © 2012-2019 CSG. All rights reserved.
 * Company: CSG
 *
 * @author lu_it:1300815418@qq.com
 * @version V1.0
 * @Package PACKAGE_NAME
 */
public class RSQLNodeVisitorTest {

    @Test
    public void visitTest() {
        String search = "a=in=(1,2);((b=out=(1,2,3),c=='test*');((d==1;e==1;f==1);h==2;i==3));j==1";

        System.out.println(search);

        Node node = RSQLUtils.parse(search);

        RSQLNodeVisitor<String, Void> visitor = new DefaultJdbcRSQLNodeVisitor();

        if (node instanceof AndNode) {
            String result = visitor.visit((AndNode) node, null);

            System.out.println(result);
        }


    }

}
