
# Online Bookstore API

This project is a simple online bookstore API built with Spring Boot and Hibernate. The API allows users to perform CRUD operations on books, authors, and genres. It also allows searching for books by title, author, or genre.

## Features

- CRUD operations for books, authors, and genres
- Search for books by title, author, or genre
- Data persistence in a PostgreSQL database using Hibernate

## Prerequisites

Before you begin, ensure you have met the following requirements:
- You have installed Java 11 or above
- You have installed Maven
- You have installed and configured PostgreSQL

## Setting Up the Database

1. Create a new PostgreSQL database named `bookstore`.
2. Update the `src/main/resources/application.properties` file with your PostgreSQL username and password.

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/bookstore
spring.datasource.username=yourUsername
spring.datasource.password=yourPassword
spring.jpa.hibernate.ddl-auto=update
```

## Running the Application

To run the application, follow these steps:

1. Open a terminal.
2. Navigate to the root directory of the project.
3. Run the following command:

```sh
mvn spring-boot:run
```

The application should start up on `http://localhost:8080`.

## Using the API

You can interact with the API using any HTTP client such as `curl` or by using tools like Postman.

### Examples of HTTP Requests

- To add a new book:

```http
POST /api/books
Content-Type: application/json

{
  "title": "The Great Gatsby",
  "author": {
    "name": "F. Scott Fitzgerald"
  },
  "genre": {
    "name": "Classic"
  },
  "price": 10.99,
  "quantityAvailable": 5
}
```

- To get a list of all books:

```http
GET /api/books
```

- To update a book:

```http
PUT /api/books/{id}
Content-Type: application/json

{
  "title": "The Great Gatsby Updated",
  "price": 11.99,
  "quantityAvailable": 10
}
```

- To delete a book:

```http
DELETE /api/books/{id}
```

## Contributing

Contributions are welcome! If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement". Don't forget to give the project a star! Thanks again!

## License

This project is licensed under the MIT License - see the LICENSE.md file for details.
