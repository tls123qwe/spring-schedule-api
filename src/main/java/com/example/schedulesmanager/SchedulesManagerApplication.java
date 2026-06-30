package com.example.schedulesmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SchedulesManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchedulesManagerApplication.class, args);
    }

}
