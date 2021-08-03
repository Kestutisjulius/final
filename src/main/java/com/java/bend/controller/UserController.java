package com.java.bend.controller;

import com.java.bend.model.Authority;
import com.java.bend.model.User;
import com.java.bend.repository.UserRepository;
import com.java.bend.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class UserController {

    private final UserService userService;

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all/{name}")
    public User getUserByName(@PathVariable String companyName) {
        return userService.getUserByCompanyName(companyName);
    }

    @GetMapping("/all")
    public List<User>getUsers() {return userService.getUsers();}

    @GetMapping("/all/{id}")
    public User getUserByRegistrationNumber(@PathVariable String registrationNumber) {
        return userService.getUserByRegistrationNumber(registrationNumber);
    }
    @PostMapping("/")
    public ResponseEntity<Void> addUser(@RequestBody User user) {
        userRepository.save(user);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
