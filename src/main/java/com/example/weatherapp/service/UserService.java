package com.example.weatherapp.service;

import com.example.weatherapp.dto.User;
import com.example.weatherapp.repos.UserRepo;
import com.example.weatherapp.util.Locations;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepo userRepo;
    public UserService(UserRepo userRepo){
        this.userRepo = userRepo;
    }
    public User registration(String fullName, Locations userLoc){
        User user = new User(fullName,userLoc);
        userRepo.save(user);
        return user;
    }
}
