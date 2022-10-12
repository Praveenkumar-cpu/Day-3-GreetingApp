package com.bridgelab.greetingapp.service;

import org.springframework.stereotype.Service;


@Service
public class GreetingService {

    public String getMessage(){
        return "Hello im  Praveen from bridgelab here Sending Response ";
    }
}