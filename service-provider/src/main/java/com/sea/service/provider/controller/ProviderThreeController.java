package com.sea.service.provider.controller;

import com.alibaba.fastjson.JSON;
import com.sea.provider.api.request.WorldRequest;
import com.sea.provider.api.service.IProviderThree;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/three")
public class ProviderThreeController implements IProviderThree {


    @Override
    public String sayHelloThree(String name) {
        return "Three " + name;
    }

    @Override
    public String sayWorldThree(WorldRequest request) {
        return "Three " + JSON.toJSONString(request);
    }
}
