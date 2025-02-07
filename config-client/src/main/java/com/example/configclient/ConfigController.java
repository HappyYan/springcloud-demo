package com.example.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@RefreshScope 注解会标记这个 Bean 为可刷新的。当配置更新时，Spring 会重新创建这个 Bean 并注入新的配置值。
@RestController
@RefreshScope
public class ConfigController {
    @Value("${message:Hello default}")
    private String message;

    @GetMapping("/message")
    public String getMessage() {
        return this.message;
    }
}
