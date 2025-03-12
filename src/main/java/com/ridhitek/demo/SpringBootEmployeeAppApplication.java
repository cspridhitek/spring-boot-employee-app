package com.ridhitek.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ridhitek.demo", "com.ridhitek.audit"})  // Ensure Employee and Audit Beans are loaded
public class SpringBootEmployeeAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootEmployeeAppApplication.class, args);
    }

}
