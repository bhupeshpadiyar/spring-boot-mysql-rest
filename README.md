# spring-boot-mysql-rest
Spring Boot RESTFull CRUD (CREATE, READ, UPDATE, DELETE) application with JPA &amp; MySQL 

Read full article on my blog http://bhupeshpadiyar.com

http://bhupeshpadiyar.com/2019/08/crud-rest-api-using-spring-boot-2-jpa-hibernate-and-mysql/



## Prerequisite
1. JDK 1.8
2. Database MySql- 5+ 
3. Apache Maven-3

## Application Stracture
There are four main entities involve in the Application  
1. Database - MySQL database to store and retrieve data.
2. RestController Layer - To control requests and responses.
3. Repository Layer - To store and retrieve data from database.
4. Client - The client that want to access the API resource.


Below is the diagram shows the high level architecture of the application


![alt text](https://raw.githubusercontent.com/bhupeshpadiyar/spring-boot-mysql-rest/master/src/main/resources/static/sbmr-application-architecture.png)



## Steps to create the database to run this project
1. Create a database schema with name users
     ```
      CREATE SCHEMA `users_db` ;
      ```
2. Create users table inside this schema
    ```
    CREATE TABLE `users` (
      `id` int(11) NOT NULL AUTO_INCREMENT,
      `user_email` varchar(100) NOT NULL,
      `first_name` varchar(45) NOT NULL,
      `last_name` varchar(45) NOT NULL,
      `user_dob` varchar(45) NOT NULL,
      `created_on` datetime DEFAULT NULL,
      `created_by` varchar(45) DEFAULT NULL,
      `updated_on` datetime DEFAULT NULL,
      `updated_by` varchar(45) DEFAULT NULL,
      PRIMARY KEY (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;
    ```
    

## Steps to run the project
1. Download The Project
2. Go to the project folder
3. Run following command
      ```
      mvn eclipse:eclipse
      ```
      ```
      mvn clean compile
      ```
      ```
      mvn spring-boot:run
      ```
      
# Steps To test the project
Below are the screen shots to test the application in Postman.



## Create user service:

Create User is a POST type service. Following is the services URL, syntex & POSTMAN screenshot.

Service URL : http://localhost:8888/api/users
Request Type : POST
POSTMAN Request Screenshot

![alt text](https://raw.githubusercontent.com/bhupeshpadiyar/spring-boot-mysql-rest/master/src/main/resources/static/images/sbmr_postman_create_user.png)

## Update user service:

Update User is a PUT type service. Following is the services URL, syntex & POSTMAN screenshot.

Service URL : http://localhost:8888/api/users/{id}
Request Type : PUT
POSTMAN Request Screenshot


![alt text](https://raw.githubusercontent.com/bhupeshpadiyar/spring-boot-mysql-rest/master/src/main/resources/static/sbmr_postman_update_user.png)


## Find user by id service:

Find User by id is a GET type service. Following is the services URL, syntex & POSTMAN screenshot.


Service URL : http://localhost:8888/api/users/{id}
Request Type : GET
POSTMAN Request Screenshot


![alt text](https://raw.githubusercontent.com/bhupeshpadiyar/spring-boot-mysql-rest/master/src/main/resources/static/sbmr_postman_find_user.png)


## List all users service:

List Users is a GET type service. Following is the services URL, syntex & POSTMAN screenshot.


Service URL : http://localhost:8888/api/users
Request Type : GET
POSTMAN Request Screenshot

![alt text](https://raw.githubusercontent.com/bhupeshpadiyar/spring-boot-mysql-rest/master/src/main/resources/static/sbmr_postman_list_user.png)

## Delete users service:

Delete user is a DELETE type service. Following is the services URL, syntex & POSTMAN screenshot.


Service URL : http://localhost:8888/api/users
Request Type : DELETE
POSTMAN Request Screenshot

![alt text](https://raw.githubusercontent.com/bhupeshpadiyar/spring-boot-mysql-rest/master/src/main/resources/static/sbmr_postman_delete_user.png)



## Authors

* **Bhupesh Singh Padiyar** - *Initial work* - [Bhupesh Singh Padiyar](https://github.com/bhupeshpadiyar)
