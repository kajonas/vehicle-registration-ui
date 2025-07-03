package com.example.demo.service;

import com.example.demo.model.Make;
import com.example.demo.model.Model;
import com.example.demo.model.Vehicle;
import com.example.demo.repository.MakeRepository;
import com.example.demo.repository.ModelRepository;
import com.example.demo.repository.VehicleRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private MakeRepository makeRepo;

    @Autowired
    private ModelRepository modelRepo;

    @Autowired
    private VehicleRepository vehicleRepo;

    public List<Make> getAllMakes() {
        return makeRepo.findAll();
    }

    public List<Model> getModelsByMake(Long makeId) {
        return modelRepo.findByMakeId(makeId);
    }

    public Vehicle saveVehicle(Vehicle vehicle) {
        return vehicleRepo.save(vehicle);
    }
}