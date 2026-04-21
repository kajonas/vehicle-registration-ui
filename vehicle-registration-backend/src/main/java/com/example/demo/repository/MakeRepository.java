package com.example.demo.repository;

import com.example.demo.model.Make;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MakeRepository extends JpaRepository<Make, Long> {}

