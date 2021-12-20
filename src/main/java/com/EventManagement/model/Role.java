package com.EventManagement.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity(name = "role")
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    @Id
    private long id;
    @Column
    private String role;

}
