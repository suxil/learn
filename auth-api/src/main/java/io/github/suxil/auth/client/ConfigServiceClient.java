package io.github.suxil.auth.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("config-service")
public interface ConfigServiceClient {

}
