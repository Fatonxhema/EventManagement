package com.EventManagement.repository;

import com.EventManagement.model.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LecturerRepository extends JpaRepository<Lecturer, Long> {
    @Query("SELECT l FROM Lecturer l WHERE l.name =:name ")
    Lecturer findByName(String name);
    @Query("select l from  Lecturer l where l.id =:id")
    Lecturer findLecturerById(long id);

}
