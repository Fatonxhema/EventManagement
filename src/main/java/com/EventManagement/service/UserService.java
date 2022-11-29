package com.EventManagement.service;

import com.EventManagement.model.Role;
import com.EventManagement.model.User;
import com.EventManagement.repository.RoleRepository;
import com.EventManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository repository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
    public boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || AnonymousAuthenticationToken.class.
                isAssignableFrom(authentication.getClass())) {
            return false;
        }
        return authentication.isAuthenticated();
    }
    public void saveUser(User user) {
        Set<Role> userRole = repository.findByName("USER");
        user.setEnabled(true);
        user.setRoles(new HashSet<>(userRole));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        this.userRepository.save(user);
    }

    public void saveAdmin(User user) {
        Set<Role> admin = repository.findByName("ADMIN");
        user.setEnabled(true);
        user.setRoles(new HashSet<>(admin));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        this.userRepository.save(user);
    }

    public User findByName(String name) {
        return userRepository.findByUsername(name);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

}
