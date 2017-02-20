package com.example;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by chaturanu on 2/19/17.
 */
@RestController
public class JSONResponseDataController {

    static class Person {
        private String firstName;
        private String lastName;

        public Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
    }


    @GetMapping("/simple-object")
    public Person getPerson() {
        return new Person("Dwayne", "Johnson");
    }

    @GetMapping("/array")
    public Person[] getPeople() {
        Person[] people = new Person[]{
                new Person("Dwayne", "Johnson"),
                new Person("John", "Cena"),
        };
        return people;
    }
}


