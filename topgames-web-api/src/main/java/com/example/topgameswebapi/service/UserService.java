package com.example.topgameswebapi.service;

import com.example.topgamesdata.model.User;
import com.example.topgamesdata.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public User createUser(User user){
        return userRepository.save(user);

    }
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public User getUserById(Long id){
        return userRepository.findById(id).get();
    }
    public User deleteUserById(Long id){
        User user = userRepository.findById(id).get();
        userRepository.deleteById(id);
        return user;
    }
    public User updateUserById(Long id, User user){
        //todo
        return userRepository.save(user);
    }
}
