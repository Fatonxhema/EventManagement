package com.EventManagement.service;

import com.EventManagement.model.Event;
import org.springframework.stereotype.Service;

import java.util.Date;

public interface EventService {
    Event createEvent(Event event);
    Event updateEvent(long id);
    void deleteById(long id);
    void findAllEvents();
    Event chooseByCampus(String campus);
    Event showByDate(Date date);
}
