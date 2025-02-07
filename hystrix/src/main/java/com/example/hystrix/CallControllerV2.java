package com.example.hystrix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/call/v2")
public class CallControllerV2 {
    @Autowired
    private HelloClient helloClient;

    @GetMapping("/another-service")
    public String callAnotherService2() {
        return helloClient.sayHello();
    }
}
