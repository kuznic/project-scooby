package com.meedra;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ScoobyApplication {
    public static void main(String[] args) {
        SpringApplication.run(ScoobyApplication.class, args);
    }
}
