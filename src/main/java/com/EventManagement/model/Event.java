package com.EventManagement.model;

import ch.qos.logback.core.rolling.helper.SizeAndTimeBasedArchiveRemover;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Table
@Entity(name = "event")
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Event {

    @Id
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
    @Column(name = "event_date")
    @NotEmpty(message = "Please enter the date of the event")
    private Date date;
}
