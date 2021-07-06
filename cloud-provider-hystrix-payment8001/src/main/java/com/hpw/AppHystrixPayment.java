package com.hpw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author gn
 * @date 2021/7/2 11:50
 */
@EnableEurekaClient
@EnableCircuitBreaker
@SpringBootApplication
public class AppHystrixPayment {
    public static void main(String[] args) {

        SpringApplication.run(AppHystrixPayment.class);
    }
}
