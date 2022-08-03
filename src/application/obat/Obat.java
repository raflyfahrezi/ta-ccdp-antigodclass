/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.obat;

import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author Lenovo
 */
public class Obat {
    private int id_obat = -1;
    private String nama;
    private BigInteger harga;
    private Date tanggal_kadaluarsa;
    private Timestamp deleted_at;
    
    public int getId_obat() {
        return id_obat;
    }

    public void setId_obat(int id_obat) {
        this.id_obat = id_obat;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public BigInteger getHarga() {
        return harga;
    }

    public void setHarga(BigInteger harga) {
        this.harga = harga;
    }

    public Date getTanggal_kadaluarsa() {
        return tanggal_kadaluarsa;
    }

    public void setTanggal_kadaluarsa(Date tanggal_kadaluarsa) {
        this.tanggal_kadaluarsa = tanggal_kadaluarsa;
    }

    public Timestamp getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(Timestamp deleted_at) {
        this.deleted_at = deleted_at;
    }
    
    
}
