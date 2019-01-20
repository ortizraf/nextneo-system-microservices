package com.nextneo.system.currency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import brave.sampler.Sampler;

@EnableFeignClients("com.nextneo.system.currency")
@EnableDiscoveryClient
@EnableHystrix
@SpringBootApplication
public class SystemCurrencyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SystemCurrencyApplication.class, args);
	}
	
	/**
	 * Conf RestTemplate
	 * @return
	 */
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
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

