package com.tedu.sp05eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class Sp05EurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(Sp05EurekaApplication.class, args);
    }

}
