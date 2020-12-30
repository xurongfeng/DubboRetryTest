package com.ldd.providerimpl;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication
@Slf4j
public class ProviderImplApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderImplApplication.class, args);
    }

}
