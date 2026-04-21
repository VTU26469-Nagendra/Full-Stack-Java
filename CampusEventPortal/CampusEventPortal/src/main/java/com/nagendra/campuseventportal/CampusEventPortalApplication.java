package com.nagendra.campuseventportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.nagendra.campuseventportal.entity")
@EnableJpaRepositories("com.nagendra.campuseventportal.repository")
public class CampusEventPortalApplication {

    public static void main(String[] args) {
        SpringApplication.run(CampusEventPortalApplication.class, args);
    }
}