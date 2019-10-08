package com.roncoo.eshop.web.controller;

import com.roncoo.eshop.client.SayHelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.roncoo.eshop.service.GreetingService;

@RestController
public class GreetingController {

    @Autowired
    private GreetingService greetingService;
    @Autowired
    private SayHelloClient sayHelloClient;

    @Value("${server.port}")
    private String port;

    @Value("${defaultName}")
    private String defaultName;

    @RequestMapping("/greeting")
    public String greeting(@RequestParam String name) {
        String result = null;

        if(name != null && !"".equals(name)) {
            result = sayHelloClient.sayHello(name);
        } else {
            result = "hello, this is default name: " + defaultName;
        }

        result += " , through greeting service from port: " + port;

        return result;
    }

}
