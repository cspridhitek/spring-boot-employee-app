package com.ridhitek.demo.config;

import jakarta.annotation.PostConstruct;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class PropertyDebugger {
    private final Environment environment;

    public PropertyDebugger(Environment environment) {
        this.environment = environment;
    }

    @PostConstruct
    public void printProperties() {
        System.out.println("🔹 Project A Property (Kafka Topic): " + environment.getProperty("spring.kafka.topic"));
        System.out.println("🔹 Project B Property (Database URL): " + environment.getProperty("server.port"));
    }
}

