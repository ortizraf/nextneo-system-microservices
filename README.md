# Nextneo Microservices Project
Nextneo Microservices Project using Kubernetes

Java Microservices project with SpringBoot 2.x

### Spring Cloud

#### Spring Actuator
In essence, Actuator brings production-ready features to our application.
Monitoring our app, gathering metrics, understanding traffic, or the state of our database become trivial with this dependency.
Use readiness and liveness with K8s

#### Feign

Feign uses tools like Jersey and CXF to write java clients for ReST or SOAP services. Furthermore, Feign allows you to write your own code on top of http libraries such as Apache HC. Feign connects your code to http APIs with minimal overhead and code via customizable decoders and error handling, which can be written to any text-based http API.

#### Sleuth

Spring Cloud Sleuth implements a distributed tracing solution for Spring Cloud, borrowing heavily from Dapper, Zipkin and HTrace.

## Requirements

- JDK 11



#### Examples 

Nextneo Currency Conversion Service
http://localhost:8100/currency-conversion/from/USD/to/BRL/quantity/10

Nextneo Currency Exchange Service
http://localhost:8000/currency-exchange/from/USD/to/BRL