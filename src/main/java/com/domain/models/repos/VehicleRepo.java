package com.domain.models.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.domain.models.entities.Vehicle;

public interface VehicleRepo extends CrudRepository<Vehicle, Long> {
    // @Query("SELECT v FROM Vehicle v WHERE v.namapemilik = :namapemilik")
    // public Vehicle findByNamaPemiilik(@Param("namapemilik") String namapemilik);
    @Query("SELECT v FROM Vehicle v WHERE v.namapemilik = :namapemilik")
    List<Vehicle> findByNamaPemiilik(@Param("namapemilik") String namapemilik);

    @Query("SELECT v FROM Vehicle v WHERE v.namapemilik LIKE :namapemilik")
    List<Vehicle> findVehicleByNamaPemilikLike(@Param("namapemilik") String namapemilik);

    @Query("SELECT v FROM Vehicle v WHERE v.nomorregkendaraan = :nomorregkendaraan")
    List<Vehicle> findByNomorRegKendaraan(@Param("nomorregkendaraan") String nomorregkendaraan);

    @Query("SELECT v FROM Vehicle v WHERE v.nomorregkendaraan LIKE:nomorregkendaraan")
    List<Vehicle> findByNomorRegKendaraanLike(@Param("nomorregkendaraan") String nomorregkendaraan);

    @Query("SELECT v FROM Vehicle v WHERE v.namapemilik LIKE:namapemilik OR v.nomorregkendaraan LIKE:nomorregkendaraan")
    List<Vehicle> searchVehicleByNamaPemilikAndNomorReg(@Param("namapemilik") String namapemilik,
            @Param("nomorregkendaraan") String nomorregkendaraan);

}
