package com.example.demo.controller

import com.example.demo.model.Vehicle
import com.example.demo.service.VehicleService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/vehicles-kt")
class VehicleControllerKT(
    private val vehicleService: VehicleService
) {

    @GetMapping("/{id}")
    fun getVehicle(@PathVariable id: Long): ResponseEntity<Vehicle> {
        val hardcodedVehicle = Vehicle(
            id = id,
            make = "Subaru",
            model = "Forester",
            year = 2022
        )
        return ResponseEntity.ok(hardcodedVehicle)
    }


//    @GetMapping("/{id}")
//    fun getVehicle(@PathVariable id: Long): ResponseEntity<Vehicle> {
//        val vehicle = vehicleService.getVehicleById(id)
//        return vehicle?.let { ResponseEntity.ok(it) }
//            ?: ResponseEntity.notFound().build()
//    }

    @PostMapping
    fun createVehicle(@RequestBody vehicle: Vehicle): ResponseEntity<Vehicle> {
        val saved = vehicleService.saveVehicle(vehicle)
        return ResponseEntity.ok(saved)
    }
}