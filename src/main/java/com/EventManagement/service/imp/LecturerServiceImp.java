package com.EventManagement.service.imp;

import com.EventManagement.model.Lecturer;
import com.EventManagement.repository.LecturerRepository;
import com.EventManagement.service.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class LecturerServiceImp implements LecturerService {

    @Autowired
    private LecturerRepository lecturerRepository;

    @Override
    public List<Lecturer> getAllLecturer() {
        return lecturerRepository.findAll();
    }

    @Override
    public void saveLecturer(Lecturer lecturer) {
//        this.lecturerRepository.save(lecturer);
    }

    @Override
    public Optional<Lecturer> getLecturerById(long id) {

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

    @Override
    public void deleteLecturerById(long id) {
        lecturerRepository.deleteById(id);
    }

    @Override
    public Lecturer findByName(String username) {
        return lecturerRepository.findByName(username);
    }
}
