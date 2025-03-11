package com.ridhitek.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application-audit.properties")
public class EmployeeAppConfig {
    public EmployeeAppConfig() {
        System.out.println("✅ Employee App: Loaded properties from audit-framework.jar!");
    }
}

