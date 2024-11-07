package com.example.simplewebapp;

import com.example.simplewebapp.Controller.HomeController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SimpleWebAppApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SimpleWebAppApplication.class, args);
        HomeController obj = context.getBean(HomeController.class);
        obj.home();
    }

}
