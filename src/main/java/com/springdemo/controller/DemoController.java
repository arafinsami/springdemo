package com.springdemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "user")
public class DemoController {

    @GetMapping
    public ResponseEntity<String> demo() {
        return ResponseEntity.ok("Hello World");
    }
}
