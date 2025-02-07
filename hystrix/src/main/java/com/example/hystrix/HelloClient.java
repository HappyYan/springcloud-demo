package com.example.hystrix;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
        name = "eureka-client-2",
        fallback = HelloClientFallback.class // 指定降级类
)
public interface HelloClient {
    @GetMapping("/hello")
    String sayHello();
}
