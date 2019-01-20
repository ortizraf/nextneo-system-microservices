package com.nextneo.system.sendemail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@EnableDiscoveryClient
@EnableFeignClients("com.nextneo.system.sendemail")
@EnableHystrix
@SpringBootApplication
public class SystemSendEmailApplication {

	public static void main(String[] args) {
		SpringApplication.run(SystemSendEmailApplication.class, args);
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