package com.nextneo.system.authserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SystemAuthServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SystemAuthServerApplication.class, args);
	}
}