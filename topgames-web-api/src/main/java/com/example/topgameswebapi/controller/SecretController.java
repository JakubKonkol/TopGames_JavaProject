package com.example.topgameswebapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secret")
public class SecretController {
    @GetMapping
    public ResponseEntity<String> wowYouAreLoggedInSoCool(){
        return ResponseEntity.ok("<h1> This is secret endpoint for logged in users :))) </h1> <br> <marquee> <h2> Wow, so cool! </h2> </marquee>");
    }
}
