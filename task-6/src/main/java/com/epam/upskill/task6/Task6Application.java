package com.epam.upskill.task6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class,
        JpaRepositoriesAutoConfiguration.class
})
public class Task6Application {

    public static void main(String[] args) {
        SpringApplication.run(Task6Application.class, args);
    }

}
