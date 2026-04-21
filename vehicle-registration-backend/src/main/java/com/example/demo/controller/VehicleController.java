package com.example.demo.controller;

import com.example.demo.model.Make;
import com.example.demo.model.Model;
import com.example.demo.model.Vehicle;
import com.example.demo.service.VehicleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/makes")
    public List<Make> getMakes() {
        return vehicleService.getAllMakes();
    }

    @GetMapping("/models-by-name/{makeName}")
    public List<Model> getModelsByName(@PathVariable String makeName) {
        return vehicleService.getModelsByName(makeName);
    }

    @GetMapping("/models/{makeId}")
    public List<Model> getModels(@PathVariable Long makeId) {
        return vehicleService.getModelsByMake(makeId);
    }

    @GetMapping("/vehicles")
    public List<Vehicle> getVehicles() {
        return vehicleService.getAllVehicles();
    }

    @PostMapping("/vehicles")
    public ResponseEntity<Vehicle> saveVehicle(@RequestBody Vehicle vehicle) {
        return ResponseEntity.ok(vehicleService.saveVehicle(vehicle));
    }
}