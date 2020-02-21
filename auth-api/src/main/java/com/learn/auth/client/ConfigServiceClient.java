package com.learn.auth.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("config-service")
public interface ConfigServiceClient {

}
