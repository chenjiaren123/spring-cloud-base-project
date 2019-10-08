package com.roncoo.eshop.client;

import com.roncoo.eshop.fallback.SayHelloServiceFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "SAY-HELLO-SERVICE", fallback = SayHelloServiceFallback.class)
public interface SayHelloClient {
    @RequestMapping(value = "/sayHello", method = RequestMethod.GET)
    public String sayHello(@RequestParam(value = "name") String name);
}
