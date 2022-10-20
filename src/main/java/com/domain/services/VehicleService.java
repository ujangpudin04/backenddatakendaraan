package com.domain.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domain.models.entities.Vehicle;
import com.domain.models.repos.VehicleRepo;

@Service
@Transactional
public class VehicleService {

    @Autowired
    private VehicleRepo vehicleRepo;

    public Vehicle save(Vehicle vehicle) {
        return vehicleRepo.save(vehicle);
    }

    public Vehicle findOne(Long id) {
        return vehicleRepo.findById(id).get();
    }

    public Iterable<Vehicle> findAll() {
        return vehicleRepo.findAll();
    }

    public void removeOne(Long id) {
        vehicleRepo.deleteById(id);
    }

    public List<Vehicle> findByNamapemilik(String namapemilik) {
        return vehicleRepo.findByNamapemilikContains(namapemilik);
    }

}
