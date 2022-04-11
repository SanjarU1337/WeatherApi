package com.example.weatherapp.controller;

import com.example.weatherapp.dto.User;
import com.example.weatherapp.repos.UserRepo;
import com.example.weatherapp.service.UserService;
import com.example.weatherapp.util.Locations;
import com.example.weatherapp.util.Parser;
import com.google.gson.JsonObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class UserController {
    private final UserService userService;
    private final UserRepo userRepo;

    public UserController(UserService userService, UserRepo userRepo) {
        this.userService = userService;
        this.userRepo = userRepo;
    }

    @PostMapping("/reg")
    public ResponseEntity<WeatherAppRestController> registration(@RequestBody String json){
        JsonObject jo = Parser.parser.parse(json).getAsJsonObject();
        String fullName = jo.get("fullName").getAsString();
        Locations userLoc = Locations.valueOf(jo.get("userLoc").getAsString().toUpperCase(Locale.ROOT));
        User user = userService.registration(fullName,userLoc);
        return ResponseEntity.ok(new WeatherAppRestController(user));
    };
}
