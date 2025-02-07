package com.example.hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/call/v1")
public class CallControllerV1 {
    @Autowired
    private RestTemplate restTemplate;

    // 定义 Hystrix 命令，并指定降级方法
    @HystrixCommand(fallbackMethod = "callAnotherServiceFallback")
    @GetMapping("/another-service")
    public String callAnotherService1() {
        String url = "http://eureka-client-2/hello";
        return restTemplate.getForObject(url, String.class);
    }

    // 降级方法（参数和返回值必须与原方法一致）
    public String callAnotherServiceFallback() {
        return "服务暂时不可用，请稍后重试！";
    }
}
