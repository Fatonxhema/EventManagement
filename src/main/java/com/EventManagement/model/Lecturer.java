package com.EventManagement.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Null;

@Entity
@Table(name = "lecturer")
@Data
public class Lecturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty(message = "Please enter name of the lecturer")
    private String name;
    @NotEmpty(message = "Please enter lastname of lecturer")
    private String lastname;
    @NotEmpty(message = "Please enter email of lecturer")
    private String email;
    @NotEmpty(message = "Please enter phone number")
    private String phone_no;
//    @NotEmpty(message = "Please enter address")
    private String address;
    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @Override
    public String toString() {
        return "Lecturer{" +
                "" + name + '\'' +
                " " + lastname + '\'' +
                '}';
    }
}
