package com.example.demo.service

import com.example.demo.model.Vehicle
import org.springframework.stereotype.Service

@Service
class VehicleService {
    private val vehicleDb = mutableMapOf<Long, Vehicle>()
    private var idCounter = 1L

    fun getVehicleById(id: Long): Vehicle? = vehicleDb[id]

    fun saveVehicle(vehicle: Vehicle): Vehicle {
        val assignedId = idCounter++
        val newVehicle = vehicle.copy(id = assignedId)
        vehicleDb[assignedId] = newVehicle
        return newVehicle
    }
}