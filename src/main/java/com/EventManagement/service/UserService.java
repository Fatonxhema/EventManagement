package com.EventManagement.service;

import com.EventManagement.model.Lecturer;
import com.EventManagement.model.User;
import com.EventManagement.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
     @Autowired
     private UserRepository userRepository;
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
    public void saveUser(User user) {
        this.userRepository.save(user);
    }


    @Autowired
    PasswordEncoder passwordEncoder;



    private void encodePassword( User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
    }

}
