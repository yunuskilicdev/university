In order to handle requirements, I used below tech stack:

Java 11

Spring Boot

Docker

Docker Compose

Postgresql

H2

I wrote endpoints for each resource.

It can be access via Swagger

http://localhost:8080/swagger-ui.html

or Postman collection

https://www.getpostman.com/collections/aa73e299e68a9fedf7c9

I used Docker compose to handle infrastructure needs without actual installations

For production postgresql is used

For testing in memory H2 is used

I inserted all example cases if the database is empty

Improvements:

Controller testing

Caching

Auth