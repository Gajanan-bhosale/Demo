package com.example.Demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Bus {

    @GetMapping("/Bus")
    public String getData(){
        return "Please book your flight at 10% discount";
    }
}
