package com.bridgelab.greetingapp.controller;

import com.bridgelab.greetingapp.model.Greeting;
import com.bridgelab.greetingapp.model.User;
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


//    @GetMapping("/greeting")
//    public Greeting greeting(@RequestParam(value = "name",defaultValue = "world")String name)
//    {
//        return new Greeting(counter.incrementAndGet(),
//                String.format(template,name));
//    }


    //ResponseEntity is meant to represent the entire HTTP response.
    // You can control anything that goes into it: status code, headers, and body.
    @GetMapping("/getMessage")
    public ResponseEntity<String>getMessage(){
        return new ResponseEntity<String>(greetingService.getMessage(), HttpStatus.OK);
    }

    @GetMapping("/getfirstandlast")
    public ResponseEntity<String>getGreetingMessage(@RequestParam(value = "firstName",defaultValue = "World") String firstName ,@RequestParam(value = "lastName",defaultValue = " World") String lastName){
        return new ResponseEntity<String>(greetingService.getGreetingMessage(firstName,lastName),HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<String> getGreeting(@RequestBody User user) {
        return new ResponseEntity<String>(greetingService.postMessage(user), HttpStatus.OK);
    }

    @PostMapping("/saveGreeting")
    public ResponseEntity<Greeting> saveGreeting(@RequestBody Greeting greeting) {
        return new ResponseEntity<Greeting>(greetingService.saveMessage(greeting), HttpStatus.OK);
    }

    @GetMapping("/findGreeting")
    public ResponseEntity<String> findGreeting(@RequestParam Integer id) {
        return new ResponseEntity<String>(greetingService.getData(id), HttpStatus.OK);
    }



}
