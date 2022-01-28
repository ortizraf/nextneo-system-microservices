package com.nextneo.microservices.apigateway;

import java.util.function.Function;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

	/**
	 * Redirect
	 * 
	 * @param builder
	 * @return
	 */
	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		return builder.routes()
				// Redirect to httpbin.org/get when call http://localhost:8765/get
				.route(p -> p.path("/get")
						.filters(f -> f.addRequestHeader("MyHeader", "MyURI").addRequestParameter("Param", "MyValue"))
						.uri("http://httpbin.org"))
				// Redirect to http://localhost:8000/currency-exchange/from/USD/to/BRL
				.route(p -> p.path("/currency-exchange/**")
						.uri("lb://nextneo-currency-exchange-service"))
				// Redirect to http://localhost:8100/currency-conversion-feign/from/USD/to/BRL/quantity/10
				.route(p -> p.path("/currency-conversion-feign/**")
						.uri("lb://nextneo-currency-conversion-service"))
				// Redirect to http://localhost:8100/currency-conversion-feign/from/USD/to/BRL/quantity/10
				.route(p -> p.path("/currency-conversion-new/**")
						.filters(f -> f.rewritePath("/currency-conversion-new/(?<segment>.*)", "/currency-conversion-feign/${segment}"))
						.uri("lb://nextneo-currency-conversion-service"))
				// Redirect to http://localhost:8100/currency-conversion/from/USD/to/BRL/quantity/10
				.route(p -> p.path("/currency-conversion/**")
						.uri("lb://nextneo-currency-conversion-service"))
				.build();
	}

}
