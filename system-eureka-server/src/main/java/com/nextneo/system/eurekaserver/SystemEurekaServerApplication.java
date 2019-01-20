package com.nextneo.system.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SystemEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SystemEurekaServerApplication.class, args);
	}
}