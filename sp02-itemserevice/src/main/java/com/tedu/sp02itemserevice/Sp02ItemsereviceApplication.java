package com.tedu.sp02itemserevice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class Sp02ItemsereviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Sp02ItemsereviceApplication.class, args);
    }

}
