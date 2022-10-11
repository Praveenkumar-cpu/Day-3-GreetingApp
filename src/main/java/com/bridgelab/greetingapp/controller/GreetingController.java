package com.bridgelab.greetingapp.controller;

import com.bridgelab.greetingapp.model.Greeting;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("api")
public class GreetingController {
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



}
