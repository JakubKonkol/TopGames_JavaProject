package com.example.topgameswebapi.controller;

import com.example.topgamesdata.model.User;
import com.example.topgameswebapi.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id){
        return ResponseEntity.ok(userService.getUserById(id));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") Long id){
        userService.deleteUserById(id);
        return ResponseEntity.ok("User deleted");
    }
    @PostMapping("/add")
    public ResponseEntity<User> createUser(@RequestBody User user){
        return ResponseEntity.ok(userService.createUser(user));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUserById(@PathVariable("id") Long id, @RequestBody User user){
        return ResponseEntity.ok(userService.updateUserById(id, user));
    }
    @PostMapping("/dev/addSamples")
    public ResponseEntity<String> addSamples(){
        userService.addSamples();
        return ResponseEntity.ok("Samples added");
    }
    @PostMapping("/dev/deleteAll")
    public ResponseEntity<String> deleteAllUsers(){
        userService.deleteAllUsers();
        return ResponseEntity.ok("All users deleted");
    }


}
