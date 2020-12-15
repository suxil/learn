package io.github.suxil.service.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("config-service")
public interface ConfigServiceClient {

}
