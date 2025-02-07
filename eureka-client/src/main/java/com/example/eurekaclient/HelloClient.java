package com.example.eurekaclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "eureka-client-2") // 指定服务名称
public interface HelloClient {

    @GetMapping("/hello") // 调用 eureka-client-2 的 /hello 接口
    String sayHello();
}
