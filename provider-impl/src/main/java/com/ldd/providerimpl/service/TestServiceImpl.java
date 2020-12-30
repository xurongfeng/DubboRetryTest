package com.ldd.providerimpl.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ldd.api.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import java.util.Random;

/**
 * @Author: Xrf
 * @Description:
 * @Date: create in 2020/12/29 15:26
 */

@Service(timeout = 60000)
@Slf4j
public class TestServiceImpl implements TestService {

    @Value("${server.port}")
    private String serverPort;

    @Override
    public String sayHello(String value) {
        log.error("sayHello...");
        // 固定超时
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return String.format("serverPort: %s, hello, %s", serverPort, value);

    }
}
