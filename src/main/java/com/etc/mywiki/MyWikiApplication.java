package com.etc.mywiki;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot是Spring框架的一个web分支架构，Spring架构是一个依托于依赖注入和面向切面编程的一个企业级轻量型框架
 * JDBC实现CRUD
 * Spring在项目运行中本身会起到一个容器的作用，项目中所有的对象都需要Spring容器管理
 * SpringApplication容器对象，
 * SpringApplication.run(MyWikiApplication.class, args)将项目的入口类的对象进行管理
 */
@SpringBootApplication
public class MyWikiApplication {

	public static void main(String[] args) {

	SpringApplication.run(MyWikiApplication.class, args);
//	String[] names= test.getBeanDefinitionNames();
//	for(String name: names){
//		System.out.println(name);
//	}
	}

}
