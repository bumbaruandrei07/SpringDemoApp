package com.spring.app.demo;

import org.springframework.stereotype.Component;

//putem avea si @Service sau @Repository doar daca avem o clasa ce comunica direct cu baza de date
@Component

public class MyClass {

    public String sayHello(){
        return "MyClass Component is here!";
    }
}
