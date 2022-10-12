package com.bridgelab.greetingapp.controller;

import com.bridgelab.greetingapp.model.Greeting;
import com.bridgelab.greetingapp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("api")
public class GreetingController {


    // if i want to use service class here will do autowire
     @Autowired
    GreetingService greetingService;
    private static final String template = "Hello,%s";
    private static AtomicLong counter = new AtomicLong();


    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name",defaultValue = "world")String name)
    {
        return new Greeting(counter.incrementAndGet(),
                String.format(template,name));
    }

    @PostMapping("/postgreeting")
    public Greeting sayHello(@RequestBody Greeting greeting){
        return new Greeting(counter.incrementAndGet(),
                String.format(template,greeting.getContent()));
    }

    @PutMapping("/putMapping/{counter}")
    public Greeting sayHello(@PathVariable long counter, @RequestParam(value = "content") String content) {
        return new Greeting(counter, String.format(template, content));
    }

    //ResponseEntity is meant to represent the entire HTTP response.
    // You can control anything that goes into it: status code, headers, and body.
    @GetMapping("/getMessage")
    public ResponseEntity<String>getMessage(){
        return new ResponseEntity<String>(greetingService.getMessage(), HttpStatus.OK);
    }



}
