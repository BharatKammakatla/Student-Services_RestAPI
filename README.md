# STUDENT-SERVICES API PROJECT
This is a sample Java / Maven / Mysql/ Spring Boot (version 2.5.4) application that builds a microservice called student-services with services like creating, fetch, update, delete students from database.

## How to Setup/Run
* Copy the source code to your workspace
* Start the mysql instance in your local machine and update the corresponding details in application.properties file present in src/main/resources
* Inorder to run the application, run `StudentServicesApplication.java` file present in com.blackone.studentservices package
* Run unit tests by using command: `mvn test`

## About the service
The service is just a simple student details REST service. It uses locally configured to store the data. Once the database connection properties are configured, we can call some REST endpoints defined in `StudentController` on port 9191. (see below)

```
http://localhost:9191/addStudent
http://localhost:8091/fetchStudents
http://localhost:8091/updateStudent
http://localhost:8091/deleteStudent
```

### Add student
```
POST /addStudent
Content-Type: application/json

{
    "id": 123942,
    "firstName": "Berry",
    "lastName": "Marshal",
    "className": "1 B",
    "nationality": "Taiwan"
}

RESPONSE: HTTP 201 (Created)
```

### Retrieve student
```
GET /fetchStudents?class=1 B
GET /fetchStudents?Id=123942

RESPONSE: HTTP 200 (Ok)
content: Students list
```

### Update student
```
PUT /updateStudent
Content-Type: application/json

{
    "id": 123942,
    "firstName": "Philip",
    "lastName": "Marshal",
    "className": "1 B",
    "nationality": "Hongkong"
}

RESPONSE: HTTP 200 (Ok)
content: Updated student list
```

### Delete student
```
PUT /deleteStudent
Content-Type: application/json

{
    "id": 123942
}

RESPONSE: HTTP 200 (Ok)
content: Success message
```

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.5.4/maven-plugin/reference/html/)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.5.4/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.5.4/reference/htmlsingle/#boot-features-jpa-and-spring-data)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

