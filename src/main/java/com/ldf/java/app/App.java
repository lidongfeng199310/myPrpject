package com.ldf.java.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@EnableAutoConfiguration
@Configuration
@ImportResource(value={"classpath:*spring-applicationContext.xml"})
public class App extends SpringBootServletInitializer{
    
	public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}