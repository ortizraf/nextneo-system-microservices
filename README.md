# Nextneo Microservices Project
Nextneo Microservices Project

Java Microservices project with SpringBoot 2.x

### Spring Cloud

#### Config Server

Centralized external configuration management backed by a git repository. <a href="https://github.com/ortizraf/nextneo-microservices-configs">Git Repository</a>

#### Eureka Server

Eureka is a REST (Representational State Transfer) based service that is primarily used in the AWS cloud for locating services for the purpose of load balancing and failover of middle-tier servers.

#### Zuul API Gateway

Zuul acts as an API gateway or Edge service. It receives all the requests coming from the UI and then delegates the requests to internal microservices.

#### Ribbon

Ribbon is a Inter Process Communication (remote procedure calls) library with built in software load balancers.

#### Feign

Feign uses tools like Jersey and CXF to write java clients for ReST or SOAP services. Furthermore, Feign allows you to write your own code on top of http libraries such as Apache HC. Feign connects your code to http APIs with minimal overhead and code via customizable decoders and error handling, which can be written to any text-based http API.

#### Hystrix

Hystrix is a latency and fault tolerance library designed to isolate points of access to remote systems, services and 3rd party libraries, stop cascading failure and enable resilience in complex distributed systems where failure is inevitable.

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