package com.EventManagement.service.imp;

import com.EventManagement.model.Event;
import com.EventManagement.repository.EventRepository;
import com.EventManagement.service.EventService;
import org.springframework.stereotype.Service;

import java.util.Date;

public class EventServiceImp implements EventService {
    EventRepository eventRepository;

    @Override
    public Event createEvent(Event event) {
        return eventRepository.save(event) ;
    }

    @Override
    public Event updateEvent(long id) {
        return null;
    }

    @Override
    public void deleteById(long id) {
        eventRepository.deleteById(id);
    }

    @Override
    public void findAllEvents() {
        eventRepository.findAll();
    }

    @Override
    public Event chooseByCampus(String campus) {
        return eventRepository.findByCampus(campus);
    }

    @Override
    public Event showByDate(Date date) {
        return eventRepository.findByDate(date);
    }
}
