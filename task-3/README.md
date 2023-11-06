

# Social Media REST API

This Social Media REST API is a simple Spring Boot application providing the backend for a social media platform. It allows users to create and view posts, follow other users, and like posts. It uses Hibernate to interact with a PostgreSQL database for persisting data.

## Features

- User registration and profile management.
- Ability to create, retrieve, and like posts.
- Ability to follow other users.

## Technologies

- Spring Boot
- Spring Security
- Spring Data JPA
- PostgreSQL
- Maven
- Lombok

## Requirements

- Java JDK 11 or later.
- Maven 3.2+
- PostgreSQL installed and running on the default port (5432).
- An IDE like IntelliJ IDEA for running the application.

## Setting Up

1. **Clone the repository**

    ```sh
    git clone https://github.com/komilovqudratjon/epam-ai-task.git
    ```

2. **Set up the PostgreSQL database**

   Create a database named `social_media` (or another name, just ensure to update the application.properties accordingly).

3. **Configure application.properties**

   Open `src/main/resources/application.properties` and set your PostgreSQL username and password:

    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/social_media
    spring.datasource.username=yourUsername
    spring.datasource.password=yourPassword
    ```

4. **Build the application**

   Navigate to the root directory of the project using a terminal or command prompt and run:

    ```sh
    mvn clean install
    ```

   This command will download all the necessary dependencies and create a `target` directory with the compiled code.

5. **Run the application**

   Once the build is complete, you can run the application using:

    ```sh
    mvn spring-boot:run
    ```

   The server should start on port 8080.

## Usage

Here are some endpoints you can hit to interact with the API:

- `POST /users/` - Register a new user.
- `POST /users/{userId}/follow/{userToFollowId}` - Follow a user.
- `POST /users/{userId}/like/{postId}` - Like a post.
- `POST /posts/` - Create a new post.
- `GET /posts/{id}` - Retrieve a post by ID.

Use a tool like [Postman](https://www.postman.com/) or [cURL](https://curl.se/) to make requests to these endpoints.

## Security

This application uses basic HTTP authentication for simplicity. In a production scenario, consider using JWT or OAuth for stateless API security.
