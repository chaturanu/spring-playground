package com.example;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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


    @PatchMapping("/patch")
    public String getPatch() {
        return "PATCH";
    }

    @DeleteMapping("/delete")
    public String getDelete() {
        return "DELETE";
    }
}


