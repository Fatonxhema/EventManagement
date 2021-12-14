package com.EventManagement.service;

import com.EventManagement.model.Event;

public interface EventService {
    Event createEvent();
    Event updateEvent(long id);
    Event deleteById(long id);
}
