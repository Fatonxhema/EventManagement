package com.EventManagement.service;

import com.EventManagement.model.User;
import org.springframework.stereotype.Service;

public interface UserService {

    User findUserByUserName(String userName);
    void deleteUSerById(long id);
    User saveUser(User user);
    User findUserByEmail(String email);
}
