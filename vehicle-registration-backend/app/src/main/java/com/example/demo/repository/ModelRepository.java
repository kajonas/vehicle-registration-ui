package com.example.demo.repository;

import com.example.demo.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ModelRepository extends JpaRepository<Model, Long> {
    List<Model> findByMakeId(Long makeId);
}

