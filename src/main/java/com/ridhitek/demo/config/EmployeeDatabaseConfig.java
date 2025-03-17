package com.ridhitek.demo.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Objects;
import java.util.Properties;

@Configuration
@EntityScan(basePackages = "com.ridhitek.demo.model")  // Employee entities
@EnableJpaRepositories(
        basePackages = "com.ridhitek.demo.repository",
        entityManagerFactoryRef = "mainEntityManagerFactory",
        transactionManagerRef = "mainTransactionManager"
)
public class EmployeeDatabaseConfig {

    @Bean
    @ConfigurationProperties("spring.datasource")
    public DataSourceProperties mainDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "mainDataSource")
    public DataSource mainDataSource() {
        return mainDataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean(name = "mainEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean mainEntityManagerFactory(
            @Qualifier("mainDataSource") DataSource dataSource,
            ApplicationContext context) {  // Inject ApplicationContext to get AuditInterceptor
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        em.setPackagesToScan("com.ridhitek.demo.model");  // Scan Employee entities

        // Hibernate properties
        Properties properties = new Properties();
        properties.put("hibernate.hbm2ddl.auto", "update"); // Update schema automatically
//
//        //  Attach AuditInterceptor dynamically
//        try {
//            properties.put("hibernate.session_factory.interceptor", auditInterceptor);
//            System.out.println("AuditInterceptor attached successfully!");
//        } catch (Exception e) {
//            System.out.println("AuditInterceptor bean not found, skipping attachment.");
//        }
        em.setJpaProperties(properties);

        return em;
    }

    @Bean(name = "mainTransactionManager")
    public JpaTransactionManager mainTransactionManager(
            @Qualifier("mainEntityManagerFactory") LocalContainerEntityManagerFactoryBean mainEntityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(Objects.requireNonNull(mainEntityManagerFactory.getObject()));
        return transactionManager;
    }
}
