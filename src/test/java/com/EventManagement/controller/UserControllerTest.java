package com.EventManagement.controller;

import com.EventManagement.model.User;
import com.EventManagement.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {

    @Autowired
    private UserService service;
    @Test
    void listUsers() {
    }

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setEmail("xhemafaton5@gmail.com");
        user.setUsername("fatonii");
        user.setLastname("Xhema");
        user.setPassword("toni123");
        user.setName("Faton");

        service.saveUser(user);
    }

    @Test
    void showRegistrationForm() {
    }

    @Test
    void processRegister() {
    }

    @Test
    void processRegisterAdmin() {
    }
}