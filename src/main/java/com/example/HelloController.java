package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chaturanu on 2/13/17.
 */

@RestController
public class HelloController {

    @GetMapping("/")
    public String sayHello() {
        return "Hello from Spring!";
    }

}


