package com.ttn.springboot;

import com.ttn.springboot.entity.Database;
import com.ttn.springboot.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.ttn.springboot.repository")
public class SpringBootApp {

    @Value("${server.port}")
    Integer port;

    @Value("${spring.datasource.name}")
    String name;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApp.class, args);
    }

    @Bean
    User getUser() {
        String username = "yatin";
        String password = "blabla";
        return new User(username, password);
    }

    @Bean
    Database getDatabase() {
        return new Database(name, port);
    }
}
