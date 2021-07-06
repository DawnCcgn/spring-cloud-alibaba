package com.hpw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author gn
 * @date 2021/6/25 11:45
 */

@SpringBootApplication
@EnableEurekaServer
public class AppEurekaServer2 {

    public static void main(String[] args) {
        SpringApplication.run(AppEurekaServer2.class);
    }
}
