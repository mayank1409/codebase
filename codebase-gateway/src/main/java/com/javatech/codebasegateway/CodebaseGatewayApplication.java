package com.javatech.codebasegateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CodebaseGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodebaseGatewayApplication.class, args);
	}

}
