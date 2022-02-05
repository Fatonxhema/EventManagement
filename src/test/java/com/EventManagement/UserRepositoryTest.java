package com.EventManagement;


import com.EventManagement.model.User;
import com.EventManagement.repository.UserRepository;
import com.EventManagement.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {

    @Autowired
    private UserRepository repo;

    @Autowired
    private UserService userService;



    @Test
    public void deleteUser(){
        Long id = 2L;
        repo.deleteById(id);
    }

    @Test
    public void getAllUser(){
        userService.findAllUsers();
    }
}