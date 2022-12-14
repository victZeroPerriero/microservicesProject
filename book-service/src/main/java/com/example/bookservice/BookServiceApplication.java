package com.example.bookservice;

import com.example.bookservice.mock.ApplicationRunner;
import com.example.bookservice.repo.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableEurekaClient
@EnableMongoRepositories
public class BookServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookServiceApplication.class, args);
    }
    @Bean
    public ApplicationRunner runner(BookRepository bookRepository){
        return new ApplicationRunner(bookRepository);
    }

}
