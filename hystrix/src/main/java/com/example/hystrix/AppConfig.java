package com.example.hystrix;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    /**
     * @LoadBalanced 是 Spring Cloud 提供的一个注解，用于启用客户端负载均衡功能。它的作用是将普通的 RestTemplate 或 WebClient 增强为一个支持负载均衡的客户端工具。具体来说，它会与 Spring Cloud LoadBalancer（或 Ribbon，如果是旧版本）集成，使得客户端能够根据服务名称从 Eureka Server 获取服务实例列表，并自动选择一个实例进行调用。
     * @return
     */
    @Bean
    @LoadBalanced // 启用负载均衡
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
