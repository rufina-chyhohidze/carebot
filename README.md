# CareBot - Team 17
By Anir Saddik, Daria Jaroszuk, Rufina Chyhohidze, Petra Adam, Hasham Abdullah

## How to set up/run our application
1. Clone the repository
2. Make sure you are connected to the KDG network/vpn
3. Run with gradle bootRun (make sure port 8080 is available)

### Disclaimer:
* In this repository you'll find the code for the web application and the data models/charts. 
* The repository with the code for the arduino (WiFi module + arduino robot car) can be found in the Team 17 (our team) [gitlab](https://gitlab.com/kdg-ti/integration-2.1/24-25/team-17)
* You can also access the arduino code repository via this [link](https://gitlab.com/kdg-ti/integration-2.1/24-25/team-17/integration-arduino)


- Once you run our application, at localhost:8080/ you'll see our home page. If you click on the menu button you'll have the option to either sign up/login. **If you want to skip the process of logging in or singing up you have two options:**
  1.   **Login with an already existing user in our database:**
        - email: user@gmail.com
        - password: user
2. **Or skip the whole process by entering `localhost:8080/1`**

      When you enter the mapping `/1`, for the sake of testing our app, you're logged in directly with an existing default user credentials. 


## Table of Contents
- [Introduction](#introduction)
    - [Technology Stack](#technology-stack)
    - [Features](#features)
- [Getting Started](#getting-started)
- [License](#license)

## Introduction

CareBot integrates a robust frontend, backend, and database system to provide a user-friendly interface for managing warehouse deliveries and controlling an Arduino-powered robot car. Key functionalities include secure user authentication, dynamic request management, and real-time robot control.

### Technology Stack
- **Frontend**: HTML, CSS, JavaScript, Bootstrap (UI Framework)
- **Backend**: Java Spring Boot
- **Database**: PostgreSQL
- **Version Control**: Git/GitLab

---

### Features
1. **Homepage**:  
   Highlights our team, project vision, and features.

2. **Login/Registration**:  
   Secure user authentication system.

3. **Warehouse Page**:  
   A dashboard for managing item requests, deliveries and tracking robot status.

4. **Request FormPage**:  
   Enables employees to request item deliveries from the warehouse to the store.

5. **Send Robot**:  
   Allows warehouse users to initiate robot deliveries to specified locations.

---

## Getting Started

### Prerequisites
- **Java 11** or higher
- **Gradle** for backend dependency management
- **PostgreSQL** database setup

### Database Setup


## License
This project is proprietary. Use, modification, or distribution is prohibited without prior written permission.
