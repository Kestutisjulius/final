package com.java.bend.service;

import com.java.bend.model.User;
import com.java.bend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {this.userRepository = userRepository;}
    public List<User>getUsers(){return userRepository.findAll();}
    public User getUserByCompanyName(String companyName) {return userRepository.getUserByCompanyName(companyName);}
    public User getUserByRegistrationNumber(String registrationNumber) {return userRepository.getUserByRegistrationNumber(registrationNumber);}
    public User getUserById(Long id) {return userRepository.findById(id).orElse(null);}
    public void updateUser (User user) {userRepository.save(user);}
    public void deleteUserById(Long id) {userRepository.deleteById(id);}

    public void addUser(User user) {
        userRepository.save(user);
    }
}
