package com.hobbeyhive.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/hello")
    public String hello() {
        return "Backend connected successfully 🚀";
    }

    @GetMapping("/")
    public String root() {
        return "HobbyHive Backend Root Works!";
    }
}
