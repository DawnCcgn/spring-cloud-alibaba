package com.hpw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author gn
 * @date 2021/7/2 14:30
 */
@EnableFeignClients
@SpringBootApplication
@EnableCircuitBreaker
public class AppHystrixConsumer80 {
    public static void main(String[] args) {
        SpringApplication.run(AppHystrixConsumer80.class);
    }
}
