package com.sea.gateway.filter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

/**
 * 自定义filter，打印请求时间
 */
@Component
public class RequestTimeGatewayFilterFactory extends AbstractGatewayFilterFactory<RequestTimeGatewayFilterFactory.Config> {

    private static final Log log = LogFactory.getLog(GatewayFilter.class);
    private static final String REQUEST_TIME_BEGIN = "requestTimeBegin";
    private static final String KEY = "withParams";//是否打印参数信息

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList(KEY);
    }

    public RequestTimeGatewayFilterFactory() {
        //类的构造器中一定要调用下父类的构造器把Config类型传过去，否则会报ClassCastException
        super(Config.class);
    }


    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            exchange.getAttributes().put(REQUEST_TIME_BEGIN, System.currentTimeMillis());
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                        Long startTime = exchange.getAttribute(REQUEST_TIME_BEGIN);
                        if (startTime != null) {
                            StringBuilder sb = new StringBuilder(exchange.getRequest().getURI().getRawPath())
                                    .append(": ")
                                    .append(System.currentTimeMillis() - startTime)
                                    .append("ms");
                            if (config.isWithParams()) {
                                sb.append(" params:").append(exchange.getRequest().getQueryParams());
                            }
                            log.info(sb.toString());
                        }
                    })
            );
        };
    }

//    /**
//     * 上述方法的原始版
//     */
//    public GatewayFilter apply(Config config, String a) {
//        return new GatewayFilter() {
//            @Override
//            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//                exchange.getAttributes().put(REQUEST_TIME_BEGIN, System.currentTimeMillis());
//                return chain.filter(exchange).then(Mono.fromRunnable(() -> {
//                            Long startTime = exchange.getAttribute(REQUEST_TIME_BEGIN);
//                            if (startTime != null) {
//                                StringBuilder sb = new StringBuilder(exchange.getRequest().getURI().getRawPath())
//                                        .append(": ")
//                                        .append(System.currentTimeMillis() - startTime)
//                                        .append("ms");
//                                if (config.isWithParams()) {
//                                    sb.append(" params:").append(exchange.getRequest().getQueryParams());
//                                }
//                                log.info(sb.toString());
//                            }
//                        })
//                );
//            }
//        };
//    }

    public static class Config {

        private boolean withParams;

        public boolean isWithParams() {
            return withParams;
        }

        public void setWithParams(boolean withParams) {
            this.withParams = withParams;
        }

    }
}
