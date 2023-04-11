package com.keep.pcc.model.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Size(max = 20)
    @Column(name="name", length = 20)
    private String name;

    @NotNull
    @Size(max = 255)
    @Column(name= "username")
    private String username;

    @Size(max = 255)
    @Column(name="email")
    private String email;

    @Size(max = 255)
    @Column(name="password")
    private String password;

    @Size(max = 255)
    @Column(name="bio")
    private String bio;

}
