package com.sea.provider.api.service;

import com.sea.provider.api.request.WorldRequest;
import org.springframework.stereotype.Service;

@Service
public class ProviderTwoFallBack implements IProviderTwo {
    @Override
    public String sayHello(String name) {
        return "fall back : default name sea";
    }

    @Override
    public String sayWorld(WorldRequest request) {
        return "fall back : default request sea";
    }
}
