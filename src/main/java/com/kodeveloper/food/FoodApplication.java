package com.kodeveloper.food;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

@RestController
@SpringBootApplication
public class FoodApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(FoodApplication.class, args);
    }

}