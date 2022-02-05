package com.EventManagement.model;

import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.Rollback;

@Rollback(value = false)
class RoleTest {

    @Test
    public void addAdminRole(){
        Role role = new Role();
        role.setId(1L);
        role.setName("ADMIN");
    }
    @Test
    public void AddUserRole(){
        Role role = new Role();
        role.setId(2L);
        role.setName("USER");
    }
    @Test
    public void AddEditorRole(){
        Role role = new Role();
        role.setId(3L);
        role.setName("EDITOR");
    }
}