# CarService_API_Q4

GET - http://localhost:8585/cars       No Auth

POST - http://localhost:8585/cars/add     admin admin

UPDATE - http://localhost:8585/cars/update/11  admin admin

DELETE - http://localhost:8585/cars/delete/9   admin admin



server.port=8585
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect

spring.datasource.url=jdbc:mysql://localhost:3306/testing6

spring.datasource.username=root

spring.jpa.hibernate.ddl-auto=update

spring.jpa.generate-ddl=true

spring.jpa.show-sql=true
