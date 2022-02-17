package com.sea.provider.api.service;

import com.sea.provider.api.request.WorldRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface IProviderThree {

    @GetMapping("sayHelloThree")
    String sayHelloThree(@RequestParam(value = "name", defaultValue = "Sea Three", required = false) String name);

    @PostMapping("sayWorldThree")
    String sayWorldThree(@RequestBody WorldRequest request);

}
