package com.sea.service.consumer.controller;

import com.alibaba.fastjson.JSON;
import com.sea.service.consumer.bean.User;
import com.sea.service.consumer.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

@RestController
@RefreshScope
public class ConsumerController {

    @Value("${useLocalCache:false}")
    private boolean useLocalCache;
//    @Value("${prop2:default}")
//    private String prop2;

    @Autowired
    ProviderService providerService;

    @GetMapping("/hi-feign")
    public String hiFeign(@RequestParam(value = "name", required = false) String name) {
        return providerService.hi(name);
    }


    @GetMapping("/getProp")
    public boolean getProp() {
        return useLocalCache;
    }

//    @GetMapping("/getProp2")
//    public String getProp2() {
//        return prop2;
//    }

    @PostMapping("/getJson")
    public String getProp(@RequestBody User user) {
        return user == null ? "" : JSON.toJSONString(user);
    }
}
