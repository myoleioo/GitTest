package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "user")
@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "status",columnDefinition = "boolean default false")
    private boolean status;
}
