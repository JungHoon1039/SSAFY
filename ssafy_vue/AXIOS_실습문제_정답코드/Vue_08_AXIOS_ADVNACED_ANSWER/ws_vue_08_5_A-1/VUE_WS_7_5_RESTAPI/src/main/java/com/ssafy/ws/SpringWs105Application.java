package com.ssafy.ws;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.ws.interceptor.AuthorizationInterceptor;
import com.ssafy.ws.interceptor.LoginCheckInterceptor;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//프록시 설정 <aop:aspectj-autoproxy></aop:aspectj-autoproxy>를 대체한다.
@EnableAspectJAutoProxy
//mybatis의 매퍼 스캔: <mybatis:scan base-package="com.ssafy.ws.model.repo"/>를 대체한다.
@MapperScan(basePackages = "com.ssafy.ws.model.mapper")
//Swagger 설정
@EnableSwagger2
public class SpringWs105Application implements WebMvcConfigurer {

	@Autowired
	AuthorizationInterceptor ai;

	@Autowired
	LoginCheckInterceptor li;

	/**
	 * 인터셉터를 등록한다. <interceptors> 태그의 내용을 대체한다.
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		List<String> aiPageList = new ArrayList<>();
		aiPageList.add("/admin/**");

		List<String> liExcludePageList = new ArrayList<>();
		liExcludePageList.add("/");
		liExcludePageList.add("/user/login");
		liExcludePageList.add("/user/signup");

		registry.addInterceptor(ai).addPathPatterns(aiPageList);
//		registry.addInterceptor(li).addPathPatterns("/**").excludePathPatterns(liExcludePageList);

	}

	public static void main(String[] args) {
		SpringApplication.run(SpringWs105Application.class, args);
	}

}
