package com.sjj.mashibing.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GateWayConfig {
    /**
     * 配置了一个id为path_msb1的路由规则
     * 当访问地址http://localhost:9999/msb/**
     * 就会转发到http://localhost:9001/nacos-provider/msb/任何地址
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        // 构建routes
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        // 具体的路由地址
        routes.route("path_msb", r -> r.path("/msb/**").uri("http://localhost:9001/nacos-provider")).build();
        // 返回所有的理由规则
        return routes.build();
    }
}
