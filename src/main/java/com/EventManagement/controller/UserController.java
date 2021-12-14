package com.EventManagement.controller;


import com.EventManagement.model.User;
import com.EventManagement.service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

public class UserController {
    @Autowired
    private UserServiceImp userServiceImp;

    @PostMapping()
    public ResponseEntity<User> createUser(User user){
        return ResponseEntity.ok(userServiceImp.saveUser(user));
    }
}
