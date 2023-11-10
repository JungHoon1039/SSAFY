package com.ssafy.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
//프록시 설정 <aop:aspectj-autoproxy></aop:aspectj-autoproxy>를 대체한다.
@EnableAspectJAutoProxy
public class WsVueRestaurantApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WsVueRestaurantApiApplication.class, args);
	}

}
