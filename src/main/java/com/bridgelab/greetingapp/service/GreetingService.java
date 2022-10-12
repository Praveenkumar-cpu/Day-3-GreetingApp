package com.bridgelab.greetingapp.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class GreetingService {

    public String getMessage(){
        return "Hello im  Praveen from bridgelab here Sending Response ";
    }

    public String getGreetingMessage(String firstName,String lastName){
        return "Hello " + firstName + " " + lastName;
    }



}