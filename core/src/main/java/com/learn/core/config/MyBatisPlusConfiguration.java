package com.learn.core.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import com.learn.core.common.DefaultGlobalMetaObjectHandler;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
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
        return new PaginationInterceptor();
    }

    @Bean
    @ConditionalOnMissingBean(value = OptimisticLockerInterceptor.class)
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }

    /**
     * SQL执行效率插件
     * 设置 dev test 环境开启
     */
    @Bean
    @Profile({"dev", "test"})
    @ConditionalOnMissingBean(value = PerformanceInterceptor.class)
    public PerformanceInterceptor performanceInterceptor() {
        return new PerformanceInterceptor();
    }

}
