package com.domain.models.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "tbl_vehicle")
public class Vehicle implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Nomor Register Kendaraan Tidak Boleh Kosong")
    private String nomorregkendaraan;

    @NotEmpty(message = "Nama Pemilik Tidak Boleh Kosong")
    private String namapemilik;

    @NotEmpty(message = "Alamat Tidak Boleh Kosong")
    @Column(name = "alamat", length = 500)
    private String alamat;

    @NotEmpty(message = "Merk Kendaraan Tidak Boleh Kosong")
    private String merkkendaraan;

    @NotEmpty(message = "Tahun Pembuatan Tidak Boleh Kosong")
    private String tahunpembuatan;

    @NotEmpty(message = "Kapasitas Silinder Tidak Boleh Kosong")
    private String kapasitassilinder;

    @NotEmpty(message = "Warna Tidak Boleh Kosong")
    private String warna;

    @NotEmpty(message = "Bahan Bakar Tidak Boleh Kosong")
    private String bahanbakar;

    public Vehicle(Long id, String nomorregkendaraan, String namapemilik, String alamat, String merkkendaraan,
            String tahunpembuatan, String kapasitassilinder, String warna, String bahanbakar) {
        this.id = id;
        this.nomorregkendaraan = nomorregkendaraan;
        this.namapemilik = namapemilik;
        this.alamat = alamat;
        this.merkkendaraan = merkkendaraan;
        this.tahunpembuatan = tahunpembuatan;
        this.kapasitassilinder = kapasitassilinder;
        this.warna = warna;
        this.bahanbakar = bahanbakar;
    }

    public Vehicle() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomorregkendaraan() {
        return nomorregkendaraan;
    }

    public void setNomorregkendaraan(String nomorregkendaraan) {
        this.nomorregkendaraan = nomorregkendaraan;
    }

    public String getNamapemilik() {
        return namapemilik;
    }

    public void setNamapemilik(String namapemilik) {
        this.namapemilik = namapemilik;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getMerkkendaraan() {
        return merkkendaraan;
    }

    public void setMerkkendaraan(String merkkendaraan) {
        this.merkkendaraan = merkkendaraan;
    }

    public String getTahunpembuatan() {
        return tahunpembuatan;
    }

    public void setTahunpembuatan(String tahunpembuatan) {
        this.tahunpembuatan = tahunpembuatan;
    }

    public String getKapasitassilinder() {
        return kapasitassilinder;
    }

    public void setKapasitassilinder(String kapasitassilinder) {
        this.kapasitassilinder = kapasitassilinder;
    }

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public String getBahanbakar() {
        return bahanbakar;
    }

    public void setBahanbakar(String bahanbakar) {
        this.bahanbakar = bahanbakar;
    }

}
