The application is based on [Spring Boot Starter for MySQL](https://spring.io/guides/gs/accessing-data-mysql/).

Go to [start.spring.io](https://start.spring.io/).

Select options for the starter app and click Generate to download the zip file.

This example uses:

- Project: Gradle Project
- Language: Java
- Spring Boot: 2.5.5
- Dependencies: Spring Web, Spring Data JPA, MySQL Driver
- Project Metadata/Group: honeycomb-otel-distro
- Project Metadata/Artifact: bees
- Project Metadata/Name: bees
- Project Metadata/Description: Spring Boot with MySQL
- Project Metadata/Package name: honeycomb-otel-distro.bees
- Packaging: Jar
- Java: 11

![Spring Initializr Setup](/honeycomb-otel-distro-starter.png)

Then follow the rest of the instructions in the guide.

`mysql.server start`

`mysql -u root -p`

```bash
mysql> create database db_example; -- Creates the new database
mysql> create user 'springuser'@'%' identified by 'ThePassword'; -- Creates the user
mysql> grant all on db_example.* to 'springuser'@'%'; -- Gives all privileges to the new user on the newly created database
```

Update application.properties - best to use some env vars

```java
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/db_example
spring.datasource.username=springuser
spring.datasource.password=ThePassword
spring.datasource.driver-class-name =com.mysql.jdbc.Driver
#spring.jpa.show-sql: true
```
