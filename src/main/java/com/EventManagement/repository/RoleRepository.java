package com.EventManagement.repository;

import com.EventManagement.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query("select r from role r where r.role=:roli")
    Role findByRole(String roli);
}
