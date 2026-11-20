# upstart-springboot-task-02
```markdown
# Task 02 — Services and Validation

## Overview
This repository contains a Spring Boot REST API built for **Task 02** of the Spring Boot Development Internship at UpStartInterns[cite: 1]. 

The application separates HTTP request handling from business logic using a service layer, validates incoming JSON payloads with Bean Validation, and formats validation errors into clean JSON responses.

---

## What Was Implemented & Design Decisions

- **Service Layer & Constructor Injection:** Moved user creation and ID generation logic out of `UserController` and into `UserService` (`@Service`), keeping the controller strictly focused on HTTP routing. Used explicit constructor injection (`public UserController(UserService userService)`) instead of field injection (`@Autowired`) to keep dependencies immutable (`final`) and clear.
- **Separate Request and Response DTOs:** Split data models into `UserRequestDto` (incoming fields with validation rules) and `UserResponseDto` (outgoing fields including system-generated `id` and `message`). This prevents validation rules on server-generated fields from blocking incoming requests and ensures only intended fields are exposed in responses.
- **Bean Validation (`@Valid`):** Applied `@NotBlank` and `@Email` constraints on `UserRequestDto` so invalid input is caught automatically before reaching the service layer.
- **Global JSON Error Handler (`@RestControllerAdvice`):** Implemented `GlobalExceptionHandler` to catch `MethodArgumentNotValidException` and return a structured field-to-message JSON map with an HTTP `400 Bad Request` status instead of Spring's default error trace.

---

## API Documentation

### Endpoint
- **Method:** `POST`
- **URL:** `/users`
- **Content-Type:** `application/json`

### Sample Valid Request
```json
{
  "name": "Aakash",
  "email": "aakashp.dev@gmail.com"
}
```

### Sample Valid Response (`200 OK`)

```json
{
  "id": 1,
  "name": "Aakash",
  "email": "aakashp.dev@gmail.com",
  "message": "Hello Aakash, your account is created!"
}
```

### Sample Validation Error Response (`400 Bad Request`)

```json
{
  "name": "Name cannot be empty",
  "email": "Please enter a valid email"
}
```

---
## Tech Stack
* **Language:** Java 17
* **Framework:** Spring Boot 4.1.2 (`spring-boot-starter-webmvc`, `spring-boot-starter-validation`)
* **Build Tool:** Maven
---

## How to Run

1. Clone this repository:
```bash
git clone [https://github.com/AakashP-Dev/springboot-task02.git](https://github.com/AakashP-Dev/springboot-task02.git)
```

2. Navigate into the project directory:
```bash
cd springboot_task02

```

3. Start the application with a single command:
* **Windows (Command Prompt / PowerShell):**
```cmd
.\mvnw.cmd spring-boot:run
```

* **Linux / macOS / Git Bash:** *
```bash
./mvnw spring-boot:run
```

4. Test `POST http://localhost:8080/users` using Postman or `curl`.

```
```
