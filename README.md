# Software Project 1 - Backend

This project is part of the Software Project 1 course and aims to provide a backend for a shopkeeper
to manage products, manufacturers, and customers in the store. 

Available at:  
**https://s24-tiimi2-backend-s24tiimi2backend.2.rahtiapp.fi/**

## Installation and running locally

1. Clone the repository
   ```bash
    git clone https://github.com/s24ohjelmistoProjekti1Tiimi2/s24Tiimi2BackEnd.git

2. Navigate to the project directory
   ```bash
   cd s24Tiimi2BackEnd

3. Build the project
   ```bash
   ./mvnw clean install

4. Run the application
   ```bash
   ./mvnw spring-boot:run

5. Access the application

    http://localhost:8080

## Features

- **Products:**  
  - Add, update, read, and delete products.  

- **Manufacturers:**  
  - Add, update, read, and delete manufacturers.  

- **Customers:**  
  - Add, update, read, and delete customers.  

## REST API Endpoints

- **GET /api/products:** Retrieves all products.
- **GET /api/products/type/{typename}:** Retrieves all products by type.
- **GET /api/manufacturers:** Retrieves all manufacturers.
- **GET /api/customers:** Retrieves all customers.
- **POST /api/customers:** Adds a new customer.
- **PUT /api/customers/{customerId}:** Updates customer information.

## Technologies

- **Backend:**  
  - Spring Boot  
  - Spring Data JPA  
  - H2/PostgreSQL database  
  - Bootstrap  
