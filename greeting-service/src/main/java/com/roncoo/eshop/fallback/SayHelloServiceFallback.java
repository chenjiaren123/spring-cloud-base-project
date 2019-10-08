package com.roncoo.eshop.fallback;

import com.roncoo.eshop.client.SayHelloClient;
import org.springframework.stereotype.Component;


@Component
public class SayHelloServiceFallback implements SayHelloClient {

	@Override
	public String sayHello(String name) {
		return "error, " + name;
	}

}
