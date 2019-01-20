package com.nextneo.system.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SystemConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SystemConfigServerApplication.class, args);
	}
}
