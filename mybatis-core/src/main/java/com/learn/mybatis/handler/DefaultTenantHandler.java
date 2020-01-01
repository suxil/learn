package com.learn.mybatis.handler;

import com.baomidou.mybatisplus.extension.plugins.tenant.TenantHandler;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.StringValue;

/**
 * <p> Title: 标题 </p>
 * <pre> Description: 描述 </pre>
 * date: 2019/11/24 22:26
 * <p>
 *
 * @author lu_it
 * @version V1.0
 * @Package com.learn.core.config
 */
public class DefaultTenantHandler implements TenantHandler {

    @Override
    public Expression getTenantId(boolean where) {
        return new StringValue("1");
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
