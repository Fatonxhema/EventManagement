package com.EventManagement.service;

import com.EventManagement.model.Event;
import org.springframework.stereotype.Service;

@Service
public interface EventService {
    Event createEvent();
    Event updateEvent(long id);
    Event deleteById(long id);
}
