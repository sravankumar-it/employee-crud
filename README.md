# Employee CRUD API

Spring Boot Java 21 CRUD application for employee management.

## Stack

- Java 21
- Spring Boot 3.3
- Spring Web
- Spring Data JPA
- H2 Database
- Maven
- Swagger/OpenAPI
- JUnit 5 and Mockito

## Run

```bash
mvn spring-boot:run
```

## URLs

- API base path: `http://localhost:8080/api/v1/employees`
- Swagger UI: `http://localhost:8080/swagger-ui.html`
- H2 console: `http://localhost:8080/h2-console`

## Endpoints

| Method | Path | Description |
| --- | --- | --- |
| POST | `/api/v1/employees` | Create employee |
| GET | `/api/v1/employees` | Get all employees |
| GET | `/api/v1/employees/{id}` | Get employee by id |
| PUT | `/api/v1/employees/{id}` | Update employee |
| DELETE | `/api/v1/employees/{id}` | Delete employee |

## Sample Request

```json
{
  "employeeCode": "EMP-001",
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@example.com",
  "department": "Engineering",
  "designation": "Software Engineer",
  "salary": 75000.00,
  "joiningDate": "2024-01-15"
}
```
