package com.hpw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author gn
 * @date 2021/6/29 16:28
 */

@SpringBootApplication
public class AppOrderConsul {

    public static void main(String[] args) {
        SpringApplication.run(AppOrderConsul.class);
    }

    @Bean
    @LoadBalanced
    public RestTemplate getRestTem(){
        return new RestTemplate();
    }
}
