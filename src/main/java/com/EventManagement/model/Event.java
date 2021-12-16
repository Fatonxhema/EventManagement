package com.EventManagement.model;

import ch.qos.logback.core.rolling.helper.SizeAndTimeBasedArchiveRemover;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table
@Entity(name = "event")
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Event {

    @Id
    private long id;
    @Column(name = "event_name")
    private String name;
    @Column(name = "event_description")
    private String description;
    @Column(name = "event_type")
    private String type;
    @Column(name = "event_locatiion")
    private String location;
    @Column(name = "event_date")
    private Date date;
}
