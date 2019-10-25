# Library Project

This project is a simple system that allows patrons to check books out from the library and allows staff to manage inventory entries. This system consists of the following:

1. A service that sits in front of the library and provides CRUD access to the data.
2. An edge service that provides an API that allows customers to search library inventory, check out books, contains business rules for checking out books, and that communicates with the CRUD service via a Feign client.
3. A Eureka Service Registry. The CRUD service must register with the Eureka service and the edge service must use the Eureka service to locate the CRUD service.

## Requirements

### CRUD Service

The CRUD microservice must provide create, read, update, and delete functionality for Book entries in the backing database. You must design and implement the REST API that provides these services.

### Edge Service

- The edge microservice must provide an endpoint that allows customers to see the books currently in inventory. You must design and implement this endpoint.
- The edge microservice must provide an endpoint that allows customers to check a books out from the library by submitted a list of ISBNs for the books they wish to checkout. The service either returns a success message or an error message. You must design and implement this endpoint.
- The edge microservice must enforce the following business rules in the service layer:
  - The number of books that can be checked out is limited by the day of the week.
    - 3 books on Mondays, Wednesdays, or Fridays
    - 2 books on Tuesdays or Thursdays
    - 4 books on Saturdays
    - 1 book on Sundays

### Architecture

- The system must incorporate and use the Eureka service registry.
- The edge service must use Feign to talk to the CRUD microservice.
- We highly encourage you to use JPA for database interaction in the CRUD microservice.

### TDD

- Follow TDD when building this project.
- This includes using MockMvc to test all of the endpoint of both microservices.
- This includes JUnit and Mockito for service layer and DAO tests.

## Database

```sql
create schema if not exists library;
use library;

create table if not exists book (
	  id int not null auto_increment primary key,
    isbn varchar(20) not null,
    title varchar(20) not null,
    author varchar(20) not null
);
