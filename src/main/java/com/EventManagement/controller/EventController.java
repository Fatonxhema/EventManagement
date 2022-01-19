package com.EventManagement.controller;

import com.EventManagement.model.Event;
import com.EventManagement.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("/login")
    public String showLoginPage(){
        return "login";
    }

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Event> listEvent = eventService.findAllEvents();
        model.addAttribute("listEvent", listEvent);

        return "events";
    }

    @GetMapping("/newEvent")
    public String showNewEventForm(Model model){
        Event event = new Event();
        model.addAttribute("event", event);
        return "new_event";
    }
    @RequestMapping(value = "/saveEvent", method = RequestMethod.POST)
    public String saveEvent( Event event){
        eventService.createEvent(event);
        return "redirect:/";
    }

    @RequestMapping(value = "/updateEvent", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Event event){
        eventService.createEvent(event);
        return "redirect:/";
    }

    //for popup modal id
    @GetMapping("/getIdEvent")
    @ResponseBody
    public Event getId(long id){
        Event event = eventService.getId(id);
        return event;
    }

    @RequestMapping("/deleteEvent/{id}")
    public String deleteProduct(@PathVariable(name = "id") Long id) {
        eventService.deleteById(id);

        return "redirect:/";
    }
}
