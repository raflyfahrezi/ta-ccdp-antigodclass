/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.pemeriksaan;

import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author VaniaM
 */
public class Pemeriksaan {
    private int id_pasien = -1;
    private int id_dokter = -1;
    private int no_nota = -1;
    private String nama_dokter;
    private String nama_pasien;
    private BigInteger total;
    private Date tanggal;
    private float tinggi_badan;
    private float berat_badan;
    private int sistolik;
    private int diastolik;
    private String tindak;
    private String obat;
    private Timestamp deleted_at;
    
    public int getId_pasien() {
        return id_pasien;
    }
    
    public void setId_pasien(int id_pasien) {
        this.id_pasien = id_pasien;
    }
    
    public int getId_dokter() {
        return id_dokter;
    }
    
    public void setId_dokter(int id_dokter) {
        this.id_dokter = id_dokter;
    }
    
    public int getNo_nota() {
        return no_nota;
    }

    public void setNo_nota(int no_nota) {
        this.no_nota = no_nota;
    }
    
    public String getNama_dokter() {
        return nama_dokter;
    }
    
    public void setNama_dokter(String nama_dokter) {
        this.nama_dokter = nama_dokter;
    }
    
    public String getNama_pasien() {
        return nama_pasien;
    }
    
    public void setNama_pasien(String nama_pasien) {
        this.nama_pasien = nama_pasien;
    }

    public BigInteger getTotal() {
        return total;
    }
    
    public void setTotal(BigInteger total) {
        this.total = total;
    }
    
    public Date getTanggal() {
        return tanggal;
    }
    
    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }
    
    public float getTinggi_badan() {
        return tinggi_badan;
    }
    
    public void setTinggi_badan(float tinggi_badan) {
        this.tinggi_badan = tinggi_badan;
    }
    
    public float getBerat_badan() {
        return berat_badan;
    }
    
    public void setBerat_badan(float berat_badan) {
        this.berat_badan = berat_badan;
    }
    
    public int getSistolik() {
        return sistolik;
    }
    
    public void setSistolik(int sistolik) {
        this.sistolik = sistolik;
    }
    
    public int getDiastolik() {
        return diastolik;
    }
    
    public void setDiastolik(int diastolik) {
        this.diastolik = diastolik;
    }
    
    public String getTindak() {
        return tindak;
    }
    
    public void setTindak(String tindak) {
        this.tindak = tindak;
    }
    
    public String getObat() {
        return obat;
    }
    
    public void setObat(String obat) {
        this.obat = obat;
    }
    
    public Timestamp getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(Timestamp deleted_at) {
        this.deleted_at = deleted_at;
    }
    
}
