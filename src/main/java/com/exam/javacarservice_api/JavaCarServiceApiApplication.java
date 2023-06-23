package com.exam.javacarservice_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class JavaCarServiceApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaCarServiceApiApplication.class, args);
    }

}
