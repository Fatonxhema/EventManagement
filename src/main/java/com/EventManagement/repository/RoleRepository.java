package com.EventManagement.repository;

import com.EventManagement.model.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import java.util.Set;
@Repository
public interface RoleRepository extends JpaRepositoryImplementation<Role, Long> {
    @Query("select r from Role r where r.name = :name")
    Set<Role> findByName(String name);
}
