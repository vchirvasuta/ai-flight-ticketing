package com.badboys.ai.flying.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customer_id;

    private String fullName;
    private String email;
    private String password;
    private boolean is_verified;
    private String verification_token;
    private LocalDateTime created_at;



}
