package com.example.topgameswebapi.controller;

import com.example.topgamesdata.model.User;
import com.example.topgameswebapi.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;


@RestController
@RequestMapping("/api/user")
public class UserController {
    UserService userService;
    Logger log = Logger.getLogger(UserController.class.getName());
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getAllUsers(){
        log.info("Getting all users");
        return ResponseEntity.ok(userService.getAllUsers());
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id){
        return ResponseEntity.ok(userService.getUserById(id));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") Long id){
        userService.deleteUserById(id);
        log.warning("User with id " + id + " was deleted");
        return ResponseEntity.ok("User deleted");
    }
    @PostMapping("/add")
    public ResponseEntity<User> createUser(@RequestBody User user){
        log.info("User " + user.getUsername() + " was created");
        return ResponseEntity.ok(userService.createUser(user));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUserById(@PathVariable("id") Long id, @RequestBody User user){
        log.info("User with id " + id + " was updated");
        return ResponseEntity.ok(userService.updateUserById(id, user));
    }
    @PostMapping("/dev/addSamples")
    public ResponseEntity<String> addSamples(){
        log.info("Adding samplee users");
        userService.addSamples();
        return ResponseEntity.ok("Samples added");
    }
    @PostMapping("/dev/deleteAll")
    public ResponseEntity<String> deleteAllUsers(){
        log.info("Deleting all users");
        userService.deleteAllUsers();
        return ResponseEntity.ok("All users deleted");
    }


}
