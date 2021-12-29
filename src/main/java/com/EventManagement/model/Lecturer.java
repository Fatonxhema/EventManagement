package com.EventManagement.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "lecturer")
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    private long phone_no;
    @Column
    @NotEmpty(message = "Please enter address")
    private String address;
}
