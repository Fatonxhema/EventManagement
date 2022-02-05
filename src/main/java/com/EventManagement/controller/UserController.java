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
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleRepository repo;

    @GetMapping("/login")
    public String showLoginPage(){
        return "login";
    }

    @RequestMapping("/profile")
    public String profile(Model model, Principal principal){
        String name = principal.getName();
        model.addAttribute("user",userService.findByName(name));
        return "profile";
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
     List<User> listUsers = userService.findAllUsers();
     model.addAttribute("listUsers", listUsers);
     return "users";
}
    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String saveUser(User user) {
        userService.saveUser(user);
        return "redirect:/";

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
        user.setRoles((Set<Role>) userRole);
        userService.saveUser(user);
        return "login";
    }

    @PostMapping("/processRegisterAdmin")
    public String processRegisterAdmin(User user) {
        Role userRole = repo.findByName("ADMIN");
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setEnabled(true);
        user.setRoles((Set<Role>) userRole);
        userService.saveUser(user);
        return "users";
    }
}

