package com.sea.service.consumer.controller;

import com.sea.service.consumer.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConsumerController {

    @Value("${useLocalCache:false}")
    private boolean useLocalCache;

    @Autowired
    ProviderService providerService;

    @GetMapping("/hi-feign")
    public String hiFeign() {
        return providerService.hi("feign");
    }


    @GetMapping("/getProp")
    public boolean getProp() {
        return useLocalCache;
    }
}
