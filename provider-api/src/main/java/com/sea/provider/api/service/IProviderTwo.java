package com.sea.provider.api.service;

import com.sea.provider.api.request.WorldRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "service-provider", contextId = "api")
public interface IProviderTwo {

    @GetMapping("sayHello")
    String sayHello(@RequestParam(value = "name", defaultValue = "Sea", required = false) String name);

    @PostMapping("sayWorld")
    String sayWorld(@RequestBody WorldRequest request);

}
