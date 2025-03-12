package com.ridhitek.demo.model;

import jakarta.persistence.*; // ✅ Use `jakarta.persistence.*` for Spring Boot 3.x
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "employees", schema = "employee_db")  // Ensure the table name matches in the database
public class Employee {

    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String position;
    private double salary;

    // Default Constructor (Required by JPA)
    public Employee() {}

    public Employee(String name, String position, double salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

}
