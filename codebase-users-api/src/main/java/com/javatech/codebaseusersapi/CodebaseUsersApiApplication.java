package com.javatech.codebaseusersapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CodebaseUsersApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodebaseUsersApiApplication.class, args);
	}

}
