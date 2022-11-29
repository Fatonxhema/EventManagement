package com.EventManagement.service;

import com.EventManagement.model.Event;
import com.EventManagement.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EventService {
    @Autowired
    EventRepository eventRepository;

    public void createEvent(Event event) {
        this.eventRepository.save(event);
    }

    public Event findById(long id) {
        return eventRepository.getById(id);
    }

    public void deleteById(long id) {
        eventRepository.deleteById(id);
    }

    public List<Event> findAllEvents() {
        return eventRepository.findAll();
    }

    public Event chooseByCampus(String campus) {
        return eventRepository.findByCampus(campus);
    }

    public Event showByDate(Date date) {
        return eventRepository.findByDate(date);
    }
}
