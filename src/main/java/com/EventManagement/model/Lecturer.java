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
    @Column
    @NotEmpty(message = "Please enter name of the lecturer")
    private String name;
    @Column
    @NotEmpty(message = "Please enter lastname of lecturer")
    private String lastname;
    @Column
    @NotEmpty(message = "Please enter email of lecturer")
    private String email;
    @Column
    @NotEmpty(message = "Please enter phone number")
    private String phone_no;
    @Column
//    @NotEmpty(message = "Please enter address")
    private String address;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
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
