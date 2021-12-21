package com.EventManagement.controller;

import com.EventManagement.model.Event;
import com.EventManagement.service.EventService;
import com.EventManagement.service.imp.EventServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EventController {

    private EventService eventService;

    @GetMapping("/showEventForm")
    public String showNewEventForm(Model model){

        Event event = new Event();
        model.addAttribute("event", event);
        return "new_event";
    }
    @PostMapping("/saveEvent")
    public String saveEvent(@ModelAttribute("event") Event event){
        eventService.createEvent(event);
        return "redirect:/";
    }
}
