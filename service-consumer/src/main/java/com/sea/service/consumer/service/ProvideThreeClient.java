package com.sea.service.consumer.service;


import com.sea.provider.api.service.IProviderThree;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "service-provider", contextId = "api-Three", path = "three", fallbackFactory = ProviderThreeFallbackFactory.class)
public interface ProvideThreeClient extends IProviderThree {

}
