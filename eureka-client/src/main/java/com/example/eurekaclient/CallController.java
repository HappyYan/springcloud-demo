package com.example.eurekaclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/call")
public class CallController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private HelloClient helloClient;

    @GetMapping("/another-service")
    public String callAnotherService1(Boolean useFeign) {
        if (useFeign != null && useFeign) {
            return helloClient.sayHello();
        }
        // 使用服务名称调用另一个服务
        String url = "http://eureka-client-2/hello"; // eureka-client-2 是第二个服务的名称
        return restTemplate.getForObject(url, String.class);
    }
}
