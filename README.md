# GPS Tracking Backend with REST API


This is a Java-based backend system with REST APIs for Vehicle GPS Tracking. The system is designed to receive GPS coordinates from 2 Wheeler Vehicles and store them in a database. It provides various functionalities related to vehicle tracking and management.

## Table of Contents

- [Features](#features)
- [Technology used](#technologies-used)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Usage](#usage)
- [API Documentation](#api-documentation)
- [Database Design](#database-design)
- [Contributing](#contributing)
- [License](#license)

## Features

- **GPS Data Storage**: Capable of storing GPS coordinates received from vehicles in a database.
- **Vehicle Information**: Stores detailed information about each vehicle, including registration number, bike model, insurance expiry date, and purchase date.
- **Owner Information**: Manages information about bike owners, including name, license number, address, phone number, and email.
- **Mapping**: Establishes a mapping between vehicles and owners, allowing owners to access information about their vehicles.
- **Distance Calculation**: Provides the ability to calculate the distance traveled based on GPS locations stored in the database.
- **User Authentication**: Ensures that users can only access information about vehicles they own.
- **Multiple Vehicle Ownership**: Supports scenarios where one user can own multiple vehicles.

## Technologies used
- Java: The core programming language used for the project.
- Spring Boot: A powerful framework for building Java applications, used for creating RESTful APIs.
- MySQL: Used MySQL, a relational database, as my project's database to storing tha data.
- Spring Data JPA: Part of the Spring framework, it simplifies database access and manipulation.
- Spring Web: Enables building web applications using the Spring framework.
- ModelMapper: A library used for mapping Java objects to each other.
- Maven: A build automation and project management tool.
- Jakarta Persistence (JPA): A Java specification for object-relational mapping (ORM).
- Lombok: A library that simplifies Java code by generating boilerplate code for you.


## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java Development Kit (JDK) installed.
- A Java IDE (e.g., IntelliJ IDEA, Eclipse) for development.
- A database system (e.g., MySQL, PostgreSQL) installed and running.
- Git for version control.

## Installation

To set up this project locally, follow these steps:

1. Clone the repository to your local machine:

   ```bash
   git clone https://github.com/your-username/gps-tracking-backend.git
   ```

2. Import the project into your Java IDE.

3. Configure the database connection in the application properties or configuration files.

4. Build and run the project.

## Usage

To use this GPS tracking system, follow these steps:

1. Register and log in to the system.

2. Add your vehicles to the system by providing details such as registration number, bike model, insurance expiry date, and purchase date.

3. Link your vehicles to your user account.

4. Ensure the GPS devices on your vehicles are sending coordinates to the system.

5. Use the provided APIs to:

   - Retrieve GPS information for your vehicles.
   - Calculate the distance traveled during a specified time frame.
   - Access information only for the vehicles you own.

## API Documentation

The following are some of the APIs available in this system:

- `POST /api/vehicles`: Create a new vehicle.
- `GET /api/vehicles/{vehicleId}`: Get GPS information for a specific vehicle.
- `GET /api/vehicles/{vehicleId}/distance`: Calculate distance traveled for a vehicle within a time frame.
- `GET /api/owners/vehicles`: Get a list of vehicles owned by the logged-in user.


## Database Design

The database design includes tables for vehicles, owners, GPS data, and vehicle-owner mapping. For UML diagrams and detailed database schema, please refer to the [Database Design](https://drive.google.com/file/d/1rI3z3GcQUmYZylYpg2nfRf6-gUQggSpy/view?usp=sharing) file.

## Contributing

Contributions are welcome! Feel free to open issues or submit pull requests to improve this project.

## Contacts

Email: [vijaypoddar.kgec@gmail.com](vijaypoddar.kgec@gmail.com)
