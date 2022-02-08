package com.sea.service.consumer.controller;

import com.sea.service.consumer.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    ProviderService providerService;

    @GetMapping("/hi-feign")
    public String hiFeign() {
        return providerService.hi("feign");
    }
}