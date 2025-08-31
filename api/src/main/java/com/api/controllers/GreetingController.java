package com.api.controllers;

import com.api.model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/" + getGreeting())
    public Greeting greeting(
            @RequestParam(value = "name", defaultValue = "Word")
            String name){

        return new Greeting(
                counter.incrementAndGet(), String.format(template, name)
        );

    }

    private static String getGreeting() {
        return "greeting";
    }
}
