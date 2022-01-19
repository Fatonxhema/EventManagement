package com.EventManagement.controller;


import com.EventManagement.model.Role;
import com.EventManagement.model.User;
import com.EventManagement.repository.RoleRepository;
import com.EventManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleRepository repo;

    @RequestMapping("/profile")
    public String profile(){
        return "profile";
    }

//    @RequestMapping("/register")
//    public String registerform() {
//        return "signup_form";
//    }

    @GetMapping("/users")
    public String listUsers(Model model) {
     List<User> listUsers = userService.findAllUsers();
     model.addAttribute("listUsers", listUsers);

     return "users";
}

    @RequestMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());

        return "register";
    }
    @PostMapping("/process_register")
    public String processRegister(User user) {
        Role userRole = repo.findByName("USER");
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setEnabled(true);
        user.setRoles(List.of(userRole));
        userService.saveUser(user);

        return "login";
    }
}

