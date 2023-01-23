package com.example.topgameswebapi.service;

import com.example.topgamesdata.model.User;
import com.example.topgamesdata.repositories.UserRepository;
import com.example.topgamestools.sampleData.SampleData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<User> u = userRepository.findById(id);
        if (u.isPresent()) {
            return u.get();
        }
        throw new IllegalArgumentException();
    }
    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }
    public User updateUserById(Long id, User user){
        User userToUpdate = getUserById(id);
        userToUpdate.setUsername(user.getUsername());
        userToUpdate.setPassword(user.getPassword());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setFirstName(user.getFirstName());
        userToUpdate.setLastName(user.getLastName());
        return userRepository.save(userToUpdate);
    }
    public User createUser(String username, User user){
        return userRepository.save(user);
    }
    public void addSamples(){
        userRepository.saveAll(SampleData.users);
    }
    public void deleteAllUsers(){
        userRepository.deleteAll();
    }
}
