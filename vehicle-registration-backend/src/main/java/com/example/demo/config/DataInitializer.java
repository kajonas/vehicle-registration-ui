package com.example.demo.config;

import com.example.demo.model.Make;
import com.example.demo.model.Model;
import com.example.demo.model.Vehicle;
import com.example.demo.repository.MakeRepository;
import com.example.demo.repository.ModelRepository;
import com.example.demo.repository.VehicleRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner loadData(
            MakeRepository makeRepository,
            ModelRepository modelRepository,
            VehicleRepository vehicleRepository
    ) {
        return args -> {
            // Makes
            Make toyota = new Make();
            toyota.setName("Toyota");
            makeRepository.save(toyota);

            Make ford = new Make();
            ford.setName("Ford");
            makeRepository.save(ford);

            // Models
            Model camry = new Model();
            camry.setName("Camry");
            camry.setMake(toyota);
            modelRepository.save(camry);

            Model corolla = new Model();
            corolla.setName("Corolla");
            corolla.setMake(toyota);
            modelRepository.save(corolla);

            Model mustang = new Model();
            mustang.setName("Mustang");
            mustang.setMake(ford);
            modelRepository.save(mustang);

            // Seed Vehicle
            Vehicle sample = new Vehicle();
            sample.setOwner("Alice Johnson");
            sample.setVin("1HGCM82633A000001");
            sample.setYear(2023);
            sample.setMake(toyota);
            sample.setModel(camry);
            vehicleRepository.save(sample);
        };
    }
}
