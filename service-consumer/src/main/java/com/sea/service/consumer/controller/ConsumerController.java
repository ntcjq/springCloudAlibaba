package com.sea.service.consumer.controller;

import com.alibaba.fastjson.JSON;
import com.sea.provider.api.request.WorldRequest;
import com.sea.provider.api.service.IProviderTwo;
import com.sea.service.consumer.bean.DataBase;
import com.sea.service.consumer.bean.User;
import com.sea.service.consumer.service.ProvideThreeClient;
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
    private DataBase dataBase;

    @Autowired
    private ProviderService providerService;

    @Autowired
    private IProviderTwo iProviderTwo;

    @Autowired
    private ProvideThreeClient provideThreeClient;

    @GetMapping("/hi-feign")
    public String hiFeign(@RequestParam(value = "name", required = false) String name) {
        return providerService.hi(name);
    }

    @GetMapping("/sayHello")
    public String sayHello(@RequestParam(value = "name", required = false) String name) {
        return iProviderTwo.sayHello(name);
    }

    @PostMapping("/sayWorld")
    public String sayWorld(@RequestBody WorldRequest request) {
        return iProviderTwo.sayWorld(request);
    }

    @GetMapping("/sayHelloThree")
    public String sayHelloThree(@RequestParam(value = "name", required = false) String name) {
        return provideThreeClient.sayHelloThree(name);
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

    @GetMapping("/getDb")
    public String getDbInfo() {
        return dataBase.toString();
    }
}
