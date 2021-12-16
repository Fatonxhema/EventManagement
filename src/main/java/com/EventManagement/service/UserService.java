package com.EventManagement.service;

import com.EventManagement.model.User;

public interface UserService {

    User findUserByUserName(String userName);
    User deleteUSerById(long id);
    User saveUser(User user);
    User findUserByEmail(String email);
}