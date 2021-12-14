package com.EventManagement.service;

import com.EventManagement.model.Lecturer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface LecturerService {
    List<Lecturer> getAllLecturer();
    void saveLecturer(Lecturer lecturer);
    Optional<Lecturer> getLecturerById(long id);
    void deleteLecturerById(long id);
}
