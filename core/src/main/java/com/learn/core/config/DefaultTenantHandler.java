package com.learn.core.config;

import com.baomidou.mybatisplus.extension.plugins.tenant.TenantHandler;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.StringValue;

/**
 * <p> Title: 标题 </p>
 * <pre> Description: 描述 </pre>
 * date: 2019/11/24 22:26
 * <p>
 * Copyright: © 2012-2019 CSG. All rights reserved.
 * Company: CSG
 *
 * @author lu_it:1300815418@qq.com
 * @version V1.0
 * @Package com.learn.core.config
 */
public class DefaultTenantHandler implements TenantHandler {

    @Override
    public Expression getTenantId() {
        // 该 where 条件 3.2.0 版本开始添加的，用于分区是否为在 where 条件中使用
        // 此判断用于支持返回多个租户 ID 场景，具体使用查看示例工程
        return new StringValue("0");
    }

    @Override
    public String getTenantIdColumn() {
        return "tenant_id";
    }

    @Override
    public boolean doTableFilter(String tableName) {
        // 这里可以判断是否过滤表
        /*
        if ("user".equals(tableName)) {
            return true;
        }*/
        return false;
    }

}
