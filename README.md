# Nextneo Microservices Project
Nextneo Microservices Project

Java Microservices project with SpringBoot 2.x

### Spring Cloud

#### Config Server

Centralized external configuration management backed by a git repository. <a href="https://github.com/ortizraf/nextneo-microservices-configs">Git Repository</a>

#### Eureka Server

Eureka is a REST (Representational State Transfer) based service that is primarily used in the AWS cloud for locating services for the purpose of load balancing and failover of middle-tier servers.

#### Spring Cloud Gateway

Spring Cloud Gateway aims to provide a simple, yet effective way to route to APIs and provide cross cutting concerns to them such as: security, monitoring/metrics, and resiliency.

#### Spring Cloud LoadBalancer

Spring Cloud Loadbalancer is a generic abstraction that can do the work that we used to do with Netflix’s Ribbon project. Spring Cloud still supports Netflix Ribbon, but Netflix Ribbons days are numbered, like so much else of the Netflix microservices stack, so we’ve provided an abstraction to support an alternative.

#### Feign

Feign uses tools like Jersey and CXF to write java clients for ReST or SOAP services. Furthermore, Feign allows you to write your own code on top of http libraries such as Apache HC. Feign connects your code to http APIs with minimal overhead and code via customizable decoders and error handling, which can be written to any text-based http API.

#### Resilience4j

Resilience4j is a lightweight, easy-to-use fault tolerance library inspired by
Netflix Hystrix, but designed for Java 8 and functional programming. Lightweight, because the library only uses Vavr, which does not have any other external library dependencies. Netflix Hystrix, in contrast, has a compile dependency to Archaius which has many more external library dependencies such as Guava and Apache Commons Configuration.

Resilience4j provides higher-order functions (decorators) to enhance any functional interface, lambda expression or method reference with a Circuit Breaker, Rate Limiter, Retry or Bulkhead. You can stack more than one decorator on any functional interface, lambda expression or method reference. The advantage is that you have the choice to select the decorators you need and nothing else.

#### Sleuth

Spring Cloud Sleuth implements a distributed tracing solution for Spring Cloud, borrowing heavily from Dapper, Zipkin and HTrace.

## Requirements

- JDK 11
- MySQL 8


## How to run

1- Up Config Server Application
2- Up Eureka Server Application
3- Up Zuul Gateway Application
4- Up the other services application

#### Examples 

Config Server
http://localhost:8888/nextneo-limits-service/default

Nextneo Limits Service
http://localhost:9595/limits

## Info
### Services

`{gateway}/nextneo-system-currency`

```http
GET /currency-exchange/from/USD/to/BRL HTTP/1.1
Content-Type: application/json
```

```http
HTTP/1.1 200 OK
Content-Type: application/json

{  
   "rates":{  
      "BRL":3.745044729
   },
   "base":"USD",
   "date":"2019-01-18"
}
```

`{gateway}/nextneo-system-auth-server`

```http
POST /oauth/token?grant_type=password&username=admin&password=123456 HTTP/1.1
Content-Type: application/json
Authorization: Basic bmV4dG5lbzokMmEkMTAkcDlQazBmUU5BUVNlc0k0dnV2S0EwT1phbkREMg==
```

```http
HTTP/1.1 200 OK
Content-Type: application/json

{
    "access_token": "a4dbd43c-238a-482e-9833-ee94bda92d31",
    "token_type": "bearer",
    "refresh_token": "181a64e4-335d-46f5-a9cb-20774ea16ee7",
    "expires_in": 1799,
    "scope": "read write"
}
```

`{gateway}/nextneo-system-order-server`

```http
GET /api/orders HTTP/1.1
Content-Type: application/json
Authorization: Bearer a4dbd43c-238a-482e-9833-ee94bda92d31
```

```http
HTTP/1.1 200 OK
Content-Type: application/json

[
    {
        "id": 1,
        "product": "Liberty",
        "price": 12.5
    }
]
```

`{gateway}/nextneo-system-send-email`

```http
POST /send-email HTTP/1.1
Content-Type: application/json

{
	"properties": {
		"mail.smtp.host":"smtp.gmail.com",
		"mail.smtp.auth":"true",
		"mail.smtp.port":"465"
	},
	"login":"email@gmail.com",
	"password":"password",
	"from":"from@gmail.com",
	"to":"to@gmail.com",
	"subject":"subject",
	"content":"test content"
}
```

```http
HTTP/1.1 200 OK
Content-Type: application/json
```