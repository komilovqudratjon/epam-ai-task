
# Spring Boot Weather Application

This application is a Spring Boot-based RESTful service that allows users to retrieve current weather data by city name or ZIP code. It integrates with a third-party API to fetch the weather details and persists this information to a local H2 database using Hibernate. Additionally, it uses Spring's Scheduled Tasks to refresh the weather data at regular intervals.

## Features

- Retrieve weather information by city name or ZIP code.
- Persist weather data in an H2 in-memory database.
- Periodically refresh weather data using Spring Scheduler.

## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java JDK 11 or newer
- Maven for dependency management and project build
- Access to a third-party weather data provider API (e.g., OpenWeatherMap, Weatherstack)

## Setting Up

1. Clone the repository to your local machine:
   ```sh
   git clone https://github.com/your-username/your-project-name.git
   ```

2. Navigate to the project directory:
   ```sh
   cd your-project-name
   ```

3. Configure the `application.properties` or `application.yml` file with the appropriate settings for your database and third-party API credentials.

## Running the Application

To run the application, execute the following command in the root directory of the project:

```sh
mvn spring-boot:run
```

Alternatively, you can package the application and run it as a standalone JAR:

```sh
mvn clean package
java -jar target/weatherapp-0.0.1-SNAPSHOT.jar
```

## Using the Application

Once the application is running, you can use the following endpoints to interact with the API:

- `GET /api/weather/city/{city}`: Fetch weather data for a specific city.
- `GET /api/weather/zipcode/{zipcode}`: Fetch weather data for a specific ZIP code.

Replace `{city}` with the name of the city and `{zipcode}` with the ZIP code you want to query.

## Testing

Run the following command to execute the test cases:

```sh
mvn test
```

## Scheduling Weather Data Refresh

The application is configured to refresh the weather data every 100 seconds by default. You can change this interval by modifying the `fixedRate` parameter in the `@Scheduled` annotation of the `WeatherScheduler` service.

## Contributing

If you'd like to contribute to the project, please fork the repository and create a pull request.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

Distributed under the MIT License. See `LICENSE` for more information.

## Contact

Your Name - email@example.com

Project Link: [https://github.com/your-username/your-project-name](https://github.com/your-username/your-project-name)

## Acknowledgements

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Hibernate](https://hibernate.org/)
- [H2 Database](https://www.h2database.com/)
- [OpenWeatherMap API](https://openweathermap.org/api)
