
# Movie Database API

## Overview

This Movie Database API provides a platform for performing CRUD operations on movies, actors, and directors within a non-relational database (MongoDB). The API allows users to add, retrieve, update, and delete movie data, as well as search for movies by title or release date.

## Prerequisites

Before running the application, ensure that you have the following installed:
- Java Development Kit (JDK) - 1.8 or later
- Maven - 3.2+
- MongoDB - 4.0 or later

Make sure that MongoDB is running on its default port (27017).

## Running the Application

1. Clone the repository:

```bash
git clone https://github.com/komilovqudratjon/epam-ai-task.git

cd epam-ai-task

```

2. Compile and package the application using Maven:

```bash
mvn clean package
```

3. Run the application:

```bash
java -jar target/task.jar
```

Or you can run the application directly using the Spring Boot Maven plugin:

```bash
mvn spring-boot:run
```

## API Endpoints

The following are the available API endpoints:

### Movies
- `GET /api/movies` - Retrieve all movies
- `POST /api/movies` - Add a new movie
- `GET /api/movies/{id}` - Retrieve a movie by ID
- `PUT /api/movies/{id}` - Update a movie by ID
- `DELETE /api/movies/{id}` - Delete a movie by ID
- `GET /api/movies/search/title?name={title}` - Search for movies by title
- `GET /api/movies/search/releaseDate?date={releaseDate}` - Search for movies by release date

### Actors and Directors (Users)
- `GET /api/users` - Retrieve all actors and directors
- `POST /api/users` - Add a new actor or director
- `GET /api/users/{id}` - Retrieve an actor or director by ID
- `PUT /api/users/{id}` - Update an actor or director by ID
- `DELETE /api/users/{id}` - Delete an actor or director by ID
- `GET /api/users/search/type?type={type}` - Search for actors or directors by type

## Configuration

The application is currently configured to connect to MongoDB running on localhost. To change the MongoDB connection settings, update the `application.properties` file in the `src/main/resources` directory.

```properties
spring.data.mongodb.uri=mongodb://localhost:27017/moviedb
```

## Testing

To run the unit tests, execute the following command:

```bash
mvn test
```

## Contact

For any additional information, contact Qudratjon at komilovqudratjon@gmail.com
.
