package com.ridhitek.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.ridhitek.demo.model")
public class SpringBootEmployeeAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootEmployeeAppApplication.class, args);
    }
}