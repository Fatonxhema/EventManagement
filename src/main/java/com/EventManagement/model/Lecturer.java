package com.EventManagement.model;

import lombok.*;

import javax.persistence.*;

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
    private String name;
    @Column
    private String lastname;
    @Column
    private String email;
    @Column
    private long phone_no;
    @Column
    private String address;
}
