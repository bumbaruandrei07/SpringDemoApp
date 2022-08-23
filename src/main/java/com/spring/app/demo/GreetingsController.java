package com.spring.app.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//endpoint-urile trebuie segregate, nu putem crea un singur endpoint si sa implementam tot
//rutare - cand request-ul 
@RestController
@RequestMapping(path = "/api/v1/greetings") //acesta este un controller, i.e. o resursa!
public class GreetingsController {

    //citim din aplicatie folosind GET, metoda specifica HTTP
    //avem nevoie de un alt tool (POSTMAN) pentru a face si alte actiuni in afara de GET
    //browser-ul va face doar get atunci cand apelam URL-ul direct.
    //Un browser poate folosi oricare alta metoda HTTP, dar in alte circumstante

    //metodele sunt endpoint-uri individuale
    //fiecare metoda in parte este un endpoint, nu controller-ul cu totul


    @GetMapping(path = "hello")
    public String hello() {
        return "Hello! This is my Spring Application!";
    }

    @GetMapping(path = "goodBye")
    public String goodBye() {
        return "See you soon";
    }


}
