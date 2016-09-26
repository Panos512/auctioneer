package com.main;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan("com")
@EntityScan("com.entity")
@EnableJpaRepositories("com.dao")
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
         SpringApplication.run(Application.class, args);   
      }
 }

