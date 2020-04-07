package com.likesea.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackages="com.likesea.system")
@EnableEurekaClient
@MapperScan(basePackages = "com.likesea.system.mapper")
public class CloudSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudSystemApplication.class, args);
    }
}

