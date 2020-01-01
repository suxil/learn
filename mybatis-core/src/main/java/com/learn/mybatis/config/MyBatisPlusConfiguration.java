package com.learn.mybatis.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.core.parser.SqlParserHelper;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.tenant.TenantSqlParser;
import com.learn.mybatis.handler.DefaultGlobalMetaObjectHandler;
import com.learn.mybatis.handler.DefaultTenantHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

public class MyBatisPlusConfiguration {

    @Bean
    @ConditionalOnMissingBean(value = MetaObjectHandler.class)
    public MetaObjectHandler metaObjectHandler() {
        return new DefaultGlobalMetaObjectHandler();
    }

    /**
     * 分页插件
     */
    @Bean
    @ConditionalOnMissingBean(value = PaginationInterceptor.class)
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();

        /*
         * 【测试多租户】 SQL 解析处理拦截器<br>
         * 这里固定写成住户 1 实际情况你可以从cookie读取，因此数据看不到 【 麻花藤 】 这条记录（ 注意观察 SQL ）<br>
         */
        List<ISqlParser> sqlParserList = new ArrayList<>();

        TenantSqlParser tenantSqlParser = new TenantSqlParser();
        tenantSqlParser.setTenantHandler(new DefaultTenantHandler());

        sqlParserList.add(tenantSqlParser);

        paginationInterceptor.setSqlParserList(sqlParserList);
        paginationInterceptor.setSqlParserFilter(metaObject -> {
            MappedStatement ms = SqlParserHelper.getMappedStatement(metaObject);
            // 过滤自定义查询此时无租户信息约束【 麻花藤 】出现
            /*
            if ("com.baomidou.springboot.mapper.UserMapper.selectListBySQL".equals(ms.getId())) {
                return true;
            }*/
            return false;
        });

        return paginationInterceptor;
    }

    @Bean
    @ConditionalOnMissingBean(value = OptimisticLockerInterceptor.class)
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }

}
