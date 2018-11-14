package com.learn.client.config;

import com.learn.client.rest.CustomRestCasClientConfigurationProperties;
import com.learn.client.rest.DefaultRestValidationFilter;
import com.learn.client.session.DefaultGlobalRestTgtManager;
import com.learn.client.session.GlobalRestTgtManager;
import com.learn.client.session.GlobalSessionManager;
import com.learn.client.utils.CustomClientInitInfoListener;
import org.jasig.cas.client.session.CustomBaseClientFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/9/21 0021 13:12
 */
@EnableConfigurationProperties(CustomRestCasClientConfigurationProperties.class)
public class CustomRestConfiguration {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private CustomRestCasClientConfigurationProperties customRestConfigProps;

    @Autowired
    private GlobalRestTgtManager globalRestTgtManager;
    @Autowired
    private RestTemplate restTemplate;

    @Bean
    @ConditionalOnMissingBean(value = {GlobalRestTgtManager.class})
    public GlobalRestTgtManager globalRestTgtManager() {
        return new DefaultGlobalRestTgtManager();
    }

    @Bean
    @ConditionalOnBean(value = {GlobalSessionManager.class})
    public CustomClientInitInfoListener customClientInitInfoListener() {
        return new CustomClientInitInfoListener();
    }

    @Bean
    @ConditionalOnMissingBean(value = {CustomBaseClientFilter.class})
    public FilterRegistrationBean defaultRestValidationFilter(){
        DefaultRestValidationFilter defaultRestValidationFilter = new DefaultRestValidationFilter();
        defaultRestValidationFilter.setGlobalRestTgtManager(globalRestTgtManager);
        defaultRestValidationFilter.setClientRestLoginUrl(customRestConfigProps.getClientRestLoginUrl());
        defaultRestValidationFilter.setRestTemplate(restTemplate);

        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(defaultRestValidationFilter);
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setOrder(0);
        logger.debug("init `DefaultRestValidationFilter`.");
        return filterRegistrationBean;
    }

}
