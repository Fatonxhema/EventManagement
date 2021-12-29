package com.EventManagement.service;

import com.EventManagement.model.Lecturer;
import com.EventManagement.repository.LecturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class LecturerService {

    @Autowired
    private LecturerRepository lecturerRepository;


    public List<Lecturer> findAllLecturer() {
        return lecturerRepository.findAll();
    }


    public void saveLecturer(Lecturer lecturer) {
      this.lecturerRepository.save(lecturer);
    }


    public Optional<Lecturer> findLecturerById(long id) {

        Optional<Lecturer> optional = lecturerRepository.findById(id);
        Lecturer lecturer = null;
        if(optional.isPresent()){
            lecturer = optional.get();
        }
        else {
            throw new RuntimeException("Lecturer not found for id"+ id);
        }
        return Optional.of(lecturer);
    }


    public void deleteLecturerById(long id) {
        lecturerRepository.deleteById(id);
    }


    public Lecturer findByName(String username) {
        return lecturerRepository.findByName(username);
    }
}
