package com.sea.service.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-provider" )
public interface ProviderService {

    @GetMapping("/hi")
    String hi(@RequestParam(value = "name", defaultValue = "Sea", required = false) String name);
}