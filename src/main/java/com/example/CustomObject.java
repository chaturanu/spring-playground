package com.example;

/**
 * Created by chaturanu on 2/18/17.
 */
public class CustomObject {

    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "CustomObject{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
