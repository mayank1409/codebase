package com.javatech.codebaseordersapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CodebaseOrdersApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodebaseOrdersApiApplication.class, args);
	}

}
