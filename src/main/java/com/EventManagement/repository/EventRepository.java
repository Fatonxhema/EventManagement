package com.EventManagement.repository;

import com.EventManagement.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    @Query("SELECT e FROM event e WHERE e.location =:campus")
    Event findByCampus(String campus);

    @Query("SELECT e FROM event e WHERE e.date =:date")
    Event findByDate(Date date);
    @Query("select e from  event  e where e.lecturer = :id")
    Event findByEventId(long id);
}
