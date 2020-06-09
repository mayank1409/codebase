package com.javatech.codebaseeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CodebaseEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodebaseEurekaServerApplication.class, args);
	}

}
