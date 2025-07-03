package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Model {
    @Id @GeneratedValue private Long id;
    private String name;

    @ManyToOne
    private Make make;
}
