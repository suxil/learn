package com.learn.service.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("config-service")
public interface ConfigServiceClient {

}
