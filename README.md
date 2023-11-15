# Tasklzr

![Java](https://img.shields.io/badge/Java-11-green)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.0.1-green)
![Spring Security](https://img.shields.io/badge/Spring%20Security-5.5.1-green)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-13-blue)

This is the backend of a task tracking application designed for programmers to manage their tasks effectively.

## Table of Contents
- [Introduction](#introduction)
- [Features](#features)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Configuration](#configuration)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Contributing](#contributing)
- [License](#license)

## Introduction

This backend application is built with Java, Spring Boot, Spring Security, Flyway for database migration, and PostgreSQL for data storage. It provides a secure and robust backend for managing tasks and to-do lists.

## Features

- User registration and authentication using Spring Security.
- Task management with CRUD (Create, Read, Update, Delete) operations.
- Secure access to user-specific data.
- Database schema managed and versioned using Flyway.
- RESTful API for easy integration with frontend or other applications.

## Getting Started

### Prerequisites

Before you begin, ensure you have met the following requirements:

- Java 11 or higher installed.
- PostgreSQL 13 or a compatible version installed.
- Maven for building and managing the project.

### Installation

1. Clone the repository:

   ```shell
   git clone https://github.com/yourusername/task-tracker-backend.git

2. Navigate to the project directory:

   ```shell
   cd task-tracker-backend

3. Create a PostgreSQL database for the application and configure the connection details
in src/main/resources/application.properties.
   
4. Build and run the application using Maven:
   ```shell
   mvn spring-boot:run
The application will start on http://localhost:8080.

### Configuration
You can configure the application by editing the src/main/resources/application.properties file. 
Modify the database connection settings, security configurations, and other properties as needed.

### Usage
To interact with the API and manage tasks, you can use tools like Postman or integrate the API into your frontend application. 
Here are the available API endpoints:

### API Endpoints
- GET /api/tasks: Get all tasks for the authenticated user.
- GET /api/tasks/{taskId}: Get details of a specific task.
- POST /api/tasks: Create a new task.
- PUT /api/tasks/{taskId}: Update an existing task.
- DELETE /api/tasks/{taskId}: Delete a task.
- POST /api/register: Register a new user.
- POST /api/login: Authenticate and obtain a JWT token for API access.
Refer to the API documentation or codebase for more details on request and response payloads.

### Contributing
If you'd like to contribute to this project, please follow these steps:

- Fork the repository.
- Create a new branch for your feature or bug fix.
- Make your changes.
- Submit a pull request to the main branch of the original repository.
  
### License
This project is licensed under the MIT License - see the LICENSE file for details.

   
