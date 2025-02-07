package com.example.hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    @HystrixCommand(fallbackMethod = "fallbackHello")
    public String hello() {
        // 模拟服务调用失败
        if (Math.random() > 0.5) {
            throw new RuntimeException("Service failed!");
        }
        return "Hello from Hystrix!";
    }

    public String fallbackHello() {
        return "服务降级";
    }
}
