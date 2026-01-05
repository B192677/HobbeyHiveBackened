package com.hobbeyhive.backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hobbeyhive.backend.entity.User;
import com.hobbeyhive.backend.repository.UserRepository;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    @Autowired
    private UserRepository userRepo;

    // REGISTER
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userRepo.save(user);
    }

    // LOGIN
    @PostMapping("/login")
    public String login(@RequestBody User user) {
        User existingUser = userRepo.findByEmail(user.getEmail());

        if (existingUser == null) {
            return "User not found";
        }

        if (!existingUser.getPassword().equals(user.getPassword())) {
            return "Invalid password";
        }

        return "Login successful";
    }
}
