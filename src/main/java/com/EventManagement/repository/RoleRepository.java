package com.EventManagement.repository;

import com.EventManagement.model.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface RoleRepository extends JpaRepositoryImplementation<Role,Long> {
    @Query("select r from Role r where r.name = :name")
    public Role findByName(String name);
}
