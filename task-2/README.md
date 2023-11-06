
# Inventory Management System

This is an Inventory Management System developed using Spring Boot. It allows users to view a list of available products, add new products, and update existing ones. The application uses Hibernate to persist product information in a PostgreSQL database.

## Features

- List all products
- View a single product by ID
- Add a new product
- Update an existing product
- Delete a product

## Requirements

- JDK 1.8 or later
- Maven 3.2+
- PostgreSQL

## Running the Application Locally

1. **Clone the repository:**

   ```sh
   git clone https://github.com/your-username/your-project-name.git
   ```

2. **Navigate to the project directory:**

   ```sh
   cd your-project-name
   ```

3. **Configure PostgreSQL**

    - Create a database in PostgreSQL.
    - Update `src/main/resources/application.properties` with your database details:

      ```properties
      spring.datasource.url=jdbc:postgresql://localhost:5432/yourdb
      spring.datasource.username=yourusername
      spring.datasource.password=yourpassword
      ```

4. **Run the application:**

   You can run the application using:

   ```sh
   ./mvnw spring-boot:run
   ```

   Or if you have Maven installed use:

   ```sh
   mvn spring-boot:run
   ```

5. **Access the application:**

   Visit `http://localhost:8080/api/products` in your web browser or use a tool like Postman to interact with the API.

## Security

Basic authentication is in place for certain actions:

- **Viewing products** does not require authentication.
- **Adding, updating, and deleting products** require authentication.

Default credentials for testing purposes are:

- **Username:** admin
- **Password:** admin

## Testing

To run the unit tests for the application, you can use:

```sh
mvn test
```

## API Endpoints

The following REST endpoints are available:

| HTTP Method | Endpoint                | Description               |
|-------------|-------------------------|---------------------------|
| GET         | `/api/products`         | List all products         |
| GET         | `/api/products/{id}`    | Get a single product by ID|
| POST        | `/api/products`         | Add a new product         |
| PUT         | `/api/products/{id}`    | Update an existing product|
| DELETE      | `/api/products/{id}`    | Delete a product          |

## Contributing

If you'd like to contribute, please fork the repository and use a feature branch. Pull requests are warmly welcome.

## Licensing

The code in this project is licensed under MIT license. See the [LICENSE.md](LICENSE.md) file for details.

## Contact

For any queries or feedback, please contact [your-email@example.com](mailto:your-email@example.com).