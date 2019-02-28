package com.panthera.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.panthera"})
public class Application /*extends SpringBootServletInitializer */ {

    /* @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }*/
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
