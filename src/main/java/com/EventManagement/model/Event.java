package com.EventManagement.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Date;
import java.util.Set;


@Entity(name = "event")
@Data
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty(message = "Please enter the name of the event")
    private String name;
    @NotEmpty(message = "Please enter description of the event")
    private String description;
    private String type;
    @NotEmpty(message = "Please enter the location of the event")
    private String location;
    @NotEmpty(message = "Please enter the rom of the event")
    private String room;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy, timezone = UTC")
    private Date date;
    @NotEmpty(message = "Please enter the time of the event")
    private String time;
    private String lectur;
    @OneToMany(mappedBy = "event")
    public Set<Lecturer> lecturer;
}
