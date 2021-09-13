package com.example.multipledatabasestest.controllers;

import com.example.multipledatabasestest.entities.mysql.User;
import com.example.multipledatabasestest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody User user) {
        userService.createUser(user);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{email}")
    public ResponseEntity<User> getUser(@PathVariable String email) {
        User user = userService.getUser(email);

        return ResponseEntity.ok(user);
    }
}
