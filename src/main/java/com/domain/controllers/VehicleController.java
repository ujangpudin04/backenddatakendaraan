package com.domain.controllers;

import java.util.List;

// import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.domain.dto.ResponseData;
import com.domain.dto.SearchData;
// import com.domain.dto.SearchData;
import com.domain.models.entities.Vehicle;
import com.domain.services.VehicleService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping
    public ResponseEntity<ResponseData<Vehicle>> save(@Valid @RequestBody Vehicle vehicle, Errors errors) {

        ResponseData<Vehicle> responseData = new ResponseData<>();

        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessage().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setData(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);

        }

        responseData.setStatus(true);
        responseData.setData(vehicleService.save(vehicle));
        return ResponseEntity.ok(responseData);
    }

    @GetMapping
    public Iterable<Vehicle> findAll() {
        return vehicleService.findAll();
    }

    @GetMapping("/{id}")
    public Vehicle findOne(@PathVariable("id") Long id) {
        return vehicleService.findOne(id);
    }

    @PutMapping()
    public ResponseEntity<ResponseData<Vehicle>> update(@Valid @RequestBody Vehicle vehicle, Errors errors) {

        ResponseData<Vehicle> responseData = new ResponseData<>();

        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessage().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setData(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);

        }

        responseData.setStatus(true);
        responseData.setData(vehicleService.save(vehicle));
        return ResponseEntity.ok(responseData);
    }

    @DeleteMapping("/{id}")
    public void removeOne(@PathVariable("id") Long id) {
        vehicleService.removeOne(id);
    }

    @PostMapping("/search/namapemilik")
    public List<Vehicle> getVehicleByNamaPemilik(@RequestBody SearchData searchData) {
        return vehicleService.findByNamaPemilik(searchData.getSearchKey());
    }

    @PostMapping("/search/nomorregkendaraan")
    public List<Vehicle> getVehicleByNomorRegKendaraan(@RequestBody SearchData searchData) {
        return vehicleService.findByNomorRegKendaraan(searchData.getSearchByNoReg());
    }

    @PostMapping("/search/nomorregkendaraanlike")
    public List<Vehicle> getVehicleByNomorRegKendaraanLike(@RequestBody SearchData searchData) {
        return vehicleService.findVehicleByNomorRegKendaraanLike(searchData.getSearchByNoReg());
    }

    // @PostMapping("/search")
    // public List<Vehicle> search(@RequestBody Vehicle vehicle) {
    // return vehicleService.searchVehicles(vehicle.getNamapemilik(),
    // vehicle.getNomorregkendaraan());
    // }

    @PostMapping("/search/namapemiliklike")
    public List<Vehicle> getVehicleByNamaPemilikLike(@RequestBody SearchData searchData) {
        return vehicleService.findVehicleByNamaPemilikLike(searchData.getSearchKey());
    }

    @PostMapping("/search")
    @CrossOrigin(origins = "*")
    List<Vehicle> search(@RequestBody SearchData searchData) {
        return vehicleService.searchVehicles(searchData.getSearchKey(),
                searchData.getSearchByNoReg());
    }
}
