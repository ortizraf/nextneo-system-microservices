package com.nextneo.system.orderserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@EnableFeignClients("com.nextneo.system.orderserver.*")
@EnableDiscoveryClient
@EnableHystrix
@SpringBootApplication
public class SystemOrderServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SystemOrderServerApplication.class, args);
	}
	
	/**
	 * Config Spring Cloud Sleuth
	 * @return
	 */
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
	
}
