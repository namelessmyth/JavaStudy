package com.sjj.mashibing.gateway.filter;//package com.mashibing.com.cloudalibabagateway9999.filter;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.core.Ordered;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
//import java.util.Date;
//
//@Component
//@Slf4j
//public class MyFilter implements Ordered, GlobalFilter {
//    /**
//     * @param exchange 可以拿到对应的request和response
//     * @param chain 过滤器链
//     * @return 是否放行
//     */
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        String username = exchange.getRequest().getQueryParams().getFirst("username");
//        log.info("*********MyFilter:"+new Date());
//        if(username==null){
//            log.info("************用户名不能为null，非法用户，请求被拒绝！");
//            //如果username为空，返回状态码406，不可接受的请求
//            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
//            return exchange.getResponse().setComplete();
//        }
//        return chain.filter(exchange);
//    }
//
//    /**
//     * 加载过滤器的顺序
//     * @return 整数数字越小优先级越高
//     */
//    @Override
//    public int getOrder() {
//        return 0;
//    }
//}
