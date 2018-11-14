package com.learn.client.rest;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/9/21 0021 14:16
 */
@ConfigurationProperties(prefix = "cas-rest")
public class CustomRestCasClientConfigurationProperties {

    private String clientRestLoginUrl;

    public String getClientRestLoginUrl() {
        return clientRestLoginUrl;
    }

    public void setClientRestLoginUrl(String clientRestLoginUrl) {
        this.clientRestLoginUrl = clientRestLoginUrl;
    }

}
