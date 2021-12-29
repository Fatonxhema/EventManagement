package com.EventManagement.controller;

import com.EventManagement.model.Lecturer;
import com.EventManagement.service.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class LecturerController {

    @Autowired
    private LecturerService lecturerService;

    @GetMapping("/lecturer")
    public String getAllLecturer(Model model){
        List<Lecturer> list = lecturerService.findAllLecturer();
       model.addAttribute("listLecturer",list);
       return "admin/lecturer";
    }
    @GetMapping("/register_lecturer")
    public String showRegistrationForm(Model model) {
        model.addAttribute("Lecturer", new Lecturer());

        return "signup_form";
    }
    @PostMapping("/process_register_lecturer")
    public String processRegister(Lecturer Lecturer) {
        lecturerService.saveLecturer(Lecturer);
        return "register_success";
    }
//    @GetMapping("/Lecturers")
//    public String listLecturers(Model model) {
//        List<Lecturer> listLecturers = lecturerService.findAllLecturer();
//        model.addAttribute("listLecturers", listLecturers);
//
//        return "lecturer";
//    }

}
