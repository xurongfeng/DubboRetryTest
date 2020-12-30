package com.ldd.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ldd.api.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Xrf
 * @Description:
 * @Date: create in 2020/12/29 15:44
 */

@RestController
@Slf4j
public class TestController {

    @Reference(timeout = 9000)
    TestService testService;

    @RequestMapping(value="/hello/{name}",method= RequestMethod.GET)
    public String sayHello(@PathVariable("name") String name){
        long start = System.currentTimeMillis();
        String result = testService.sayHello(name);
        log.error(String.format("cost time: %d", System.currentTimeMillis() - start));
        return result;
    }

}
