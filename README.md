# Dad's Inventory

Dad's Inventory is a web application built with Spring that helps users manage their tools and prices efficiently. Utilizing Spring Security, it ensures secure authentication and authorization to control access to different functionalities.

## Overview
Dad's Inventory is a Spring-based web application tailored for tool management. It provides a user-friendly interface for users to organize their tools and track their prices securely.

## Features

- Connect to a database and fill it with records.
- Authentication:
  - Authentication by cookie.
  - Authentication by Google Sign-in.
- Authorization:
  - Simple authorization for specific endpoints.
  - Role-based authorization to control access for dad and mom.


## Setup

1. Clone the project repository.
2. Configure the connection string in `application.properties` to point to your local database.
3. Ensure that Maven is installed.
4. Build the project using Maven: `mvn clean install`.
5. Run the project: `mvn spring-boot:run`.

## Usage

1. Use the provided authentication methods to log in as dad or mom.
2. Explore the functionality to manage tools and prices.

## Authentication

Authentication is implemented using both cookie-based authentication and Google Sign-in.

## Authorization

- Simple authorization is implemented for specific endpoints.
- Role-based authorization is implemented to differentiate access between dad and mom.

