package com.bridgelab.greetingapp.service;

import com.bridgelab.greetingapp.model.Greeting;
import com.bridgelab.greetingapp.model.User;
import com.bridgelab.greetingapp.repository.GreetingAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class GreetingService {

    private static String template = "Hello %s";
    @Autowired
    GreetingAppRepository repository;

    public String getMessage(){
        return "Hello im  Praveen from bridgelab here Sending Response ";
    }

    public String getGreetingMessage(String firstName,String lastName){
        return "Hello " + firstName + " " + lastName;
    }


    public String postMessage(User user) {
        return "Hello " + user.getFirstName() + " " + user.getLastName();

    }

    public Greeting saveMessage(Greeting greeting) {
        Greeting greeting1 = new Greeting(String.format(template,greeting.getContent()));
        repository.save(greeting1);
        return greeting1;
    }
}