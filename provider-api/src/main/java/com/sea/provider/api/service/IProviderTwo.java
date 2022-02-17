package com.sea.provider.api.service;

import com.sea.provider.api.request.WorldRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 这边可以不写@Fegin注解，把@Fegin写在消费端，消费端写一个interface来extends这个api，然后把@Fegin写在消费端的接口上
 */
@FeignClient(name = "service-provider", contextId = "api", fallback = ProviderTwoFallBack.class)
public interface IProviderTwo {

    @GetMapping("sayHello")
    String sayHello(@RequestParam(value = "name", defaultValue = "Sea", required = false) String name);

    @PostMapping("sayWorld")
    String sayWorld(@RequestBody WorldRequest request);

}
