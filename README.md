# Spring Boot Employee Management Application

This is a simple Spring Boot application for managing employee data. It provides a REST API to create, update, delete, and retrieve employee information.

## Project Structure

```
spring-boot-employee-app
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── ridhitek
│   │   │           └── demo
│   │   │               ├── controller
│   │   │               │   └── EmployeeController.java
│   │   │               ├── model
│   │   │               │   └── Employee.java
│   │   │               ├── repository
│   │   │               │   └── EmployeeRepository.java
│   │   │               └── service
│   │   │                   └── EmployeeService.java
│   │   └── resources
│   │       ├── application.properties
│   │       └── static
│   │       └── templates
│   └── test
│       └── java
│           └── com
│               └── ridhitek
│                   └── demo
│                       └── EmployeeControllerTest.java
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

## Features

- **Create Employee**: Add a new employee to the system.
- **Update Employee**: Modify existing employee details.
- **Delete Employee**: Remove an employee from the system.
- **Get All Employees**: Retrieve a list of all employees.

## Setup Instructions

1. Clone the repository:
   ```
   git clone <repository-url>
   cd spring-boot-employee-app
   ```

2. Build the project using Maven:
   ```
   ./mvnw clean install
   ```

3. Run the application:
   ```
   ./mvnw spring-boot:run
   ```

4. Access the API at `http://localhost:8080/api/employees`.

## Usage

You can use tools like Postman or curl to interact with the REST API. Here are some example requests:

- **Create Employee**:
  ```
  POST /api/employees
  {
      "name": "John Doe",
      "position": "Developer",
      "salary": 60000
  }
  ```

- **Get All Employees**:
  ```
  GET /api/employees
  ```

- **Update Employee**:
  ```
  PUT /api/employees/{id}
  {
      "name": "John Doe",
      "position": "Senior Developer",
      "salary": 80000
  }
  ```

- **Delete Employee**:
  ```
  DELETE /api/employees/{id}
  ```

## Testing

Unit tests are included in the project to ensure the functionality of the REST API. You can run the tests using:
```
./mvnw test
```

## License

This project is licensed under the MIT License.