package com.EventManagement.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Date;
import java.util.Set;

@Table
@Entity(name = "event")
@Data
public class Event {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "event_name")
    @NotEmpty(message = "Please enter the name of the event")
    private String name;
    @Column(name = "event_description")
    @NotEmpty(message = "Please enter description of the event")
    private String description;
    @Column(name = "event_type")
    private String type;
    @Column(name = "event_location")
    @NotEmpty(message = "Please enter the location of the event")
    private String location;
    @Column(name = "event_room")
    @NotEmpty(message = "Please enter the rom of the event")
    private String room;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy, timezone = UTC")
    private Date date;
    @Column(name = "event_time")
    @NotEmpty(message = "Please enter the time of the event")
    private String time;
    private String lectur;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "lecturer_id", referencedColumnName = "id")
    public Set<Lecturer> lecturer;
}
