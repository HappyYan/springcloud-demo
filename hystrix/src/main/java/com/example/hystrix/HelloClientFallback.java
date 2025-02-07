package com.example.hystrix;

import org.springframework.stereotype.Component;

@Component
public class HelloClientFallback implements HelloClient {
    @Override
    public String sayHello() {
        return "服务暂时不可用，请稍后重试！";
    }
}
