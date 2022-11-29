package com.EventManagement.controller;

import com.EventManagement.model.Event;
import com.EventManagement.service.EventService;
import com.EventManagement.service.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EventController {
    public static final String REDIRECT = "redirect:/";
    @Autowired
    private EventService eventService;
    @Autowired
    public LecturerService lecturerService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<Event> listEvent = eventService.findAllEvents();
        model.addAttribute("listEvent", listEvent);
        return "index";
    }

    @GetMapping("/newEvent")
    public String showNewEventForm(Model model) {
        Event event = new Event();
        model.addAttribute("event", event);
        return "new_event";
    }

    @PostMapping( "/saveEvent")
    public String saveEvent(Event event, Model model) {
        model.addAttribute("ListLectur", lecturerService.findAllLecturer());
        eventService.createEvent(event);
        return REDIRECT;
    }

    @RequestMapping(value = "/updateEvent", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(@RequestParam("event") Event event) {
        eventService.createEvent(event);
        return REDIRECT;
    }

    @DeleteMapping( "/deleteEvent/{id}")
    public String deleteProduct(@PathVariable(name = "id") Long id, Model model) {
        eventService.deleteById(id);
        return REDIRECT;
    }
}
