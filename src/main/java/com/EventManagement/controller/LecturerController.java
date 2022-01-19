package com.EventManagement.controller;

import com.EventManagement.model.Lecturer;
import com.EventManagement.service.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class LecturerController {

    @Autowired
    private LecturerService lecturerService;

    @GetMapping("/lecturer")
    public String getAllLecturer(Model model){
        List<Lecturer> list = lecturerService.findAllLecturer();
       model.addAttribute("listLecturer",list);
       return "lecturer";
    }
    @GetMapping("/newlecturer")
    public String newLectureForm(Model model) {
    Lecturer lecture = new Lecturer();
    model.addAttribute("lecture ", lecture);
    return "new_lecturer";
    }
    @RequestMapping(value = "/saveLecturer", method = RequestMethod.POST)
    public String saveLecturer(Lecturer Lecturer) {
        lecturerService.saveLecturer(Lecturer);
        return "redirect:/";
    }
    @RequestMapping(value = "/updateLecturer", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateLecturer(Lecturer lecturer){
        lecturerService.saveLecturer(lecturer);
        return "redirect:/";
    }

    @GetMapping("/getIdLecturer")
    @ResponseBody
    public Optional<Lecturer> getId(long id){
        Optional<Lecturer> lecture = lecturerService.findLecturerById(id);
        return lecture;
    }
    @RequestMapping("/deleteLecturer/{id}")
    public String deleteLecturer(@PathVariable(name ="id") long id){
        lecturerService.deleteLecturerById(id);
        return "redirect:/";
    }


}
