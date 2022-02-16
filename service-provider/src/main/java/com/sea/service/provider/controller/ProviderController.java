package com.sea.service.provider.controller;

import com.alibaba.fastjson.JSON;
import com.sea.provider.api.request.WorldRequest;
import com.sea.provider.api.service.IProviderTwo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController implements IProviderTwo {

    @Value("${server.port}")
    String port;

    @Override
    public String sayHello(String name) {
        return "hello " + name;
    }

    @Override
    public String sayWorld(WorldRequest request) {
        return request == null ? "" : JSON.toJSONString(request);
    }

    @GetMapping("/hi")
    public String hi(@RequestParam(value = "name", defaultValue = "Sea", required = false) String name) {
        return "hello " + name + ", i'm provider ,my port:" + port;

    }
}
