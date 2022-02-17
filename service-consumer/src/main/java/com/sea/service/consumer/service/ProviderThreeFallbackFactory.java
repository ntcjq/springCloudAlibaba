package com.sea.service.consumer.service;

import com.sea.provider.api.request.WorldRequest;
import com.sea.provider.api.service.IProviderThree;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class ProviderThreeFallbackFactory implements FallbackFactory<IProviderThree> {
    @Override
    public IProviderThree create(Throwable cause) {
        return new IProviderThree() {
            @Override
            public String sayHelloThree(String name) {
                return "fallbackFactory Sea";
            }

            @Override
            public String sayWorldThree(WorldRequest request) {
                return "fallbackFactory request sea";
            }
        };
    }
}
