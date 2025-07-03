package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Vehicle {
    @Id @GeneratedValue private Long id;
    private String owner;
    private String vin;
    private int year;

    @ManyToOne
    private Make make;

    @ManyToOne
    private Model model;
}
