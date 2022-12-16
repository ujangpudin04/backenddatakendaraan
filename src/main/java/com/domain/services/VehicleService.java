package com.domain.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// import org.springframework.util.StringUtils;
import org.springframework.util.StringUtils;

// import com.domain.dto.SearchData;
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

    // cari berdasar nama yang sama persis
    public List<Vehicle> findByNamaPemilik(String string) {
        return vehicleRepo.findByNamaPemiilik(string);
    }

    // cari berdasar nama yang hampir sama
    public List<Vehicle> findVehicleByNamaPemilikLike(String string) {
        return vehicleRepo.findVehicleByNamaPemilikLike("%" + string + "%");
    }

    // cari berdasar nama yang sama persis
    public List<Vehicle> findByNomorRegKendaraan(String nomorregkendaraan) {
        return vehicleRepo.findByNomorRegKendaraan(nomorregkendaraan);
    }

    // cari berdasar nama yang hampir sama
    public List<Vehicle> findVehicleByNomorRegKendaraanLike(String namapemilik) {
        return vehicleRepo.findByNomorRegKendaraanLike("%" + namapemilik + "%");
    }

    public List<Vehicle> searchVehicles(String namapemilik, String nomorregkendaraan) {
        List<Vehicle> vehiclesList = null;

        if (nomorregkendaraan.equals("") && StringUtils.hasText(namapemilik)) {
            vehiclesList = vehicleRepo.findVehicleByNamaPemilikLike("%" + namapemilik + "%");
        } else if (StringUtils.hasText(nomorregkendaraan) && namapemilik.equals("")) {
            vehiclesList = vehicleRepo.findByNomorRegKendaraanLike("%" + nomorregkendaraan + "%");
        } else {
            vehiclesList = vehicleRepo.searchVehicleByNamaPemilikAndNomorReg(
                    "%" + namapemilik + "%", "%" + nomorregkendaraan + "%");
        }

        return vehiclesList;
    }

}
