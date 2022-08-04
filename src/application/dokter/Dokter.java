/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.dokter;

import java.sql.Timestamp;

/**
 *
 * @author Azis Naufal
 */
public class Dokter {
    private int id_doker = -1;
    private String nama;
    private String alamat;
    private String spesialis;
    private Timestamp deleted_at;

    public Dokter() {
     
    }
    
    public Dokter(String nama, String alamat, String spesialis, Timestamp deleted_at) {
        this.nama = nama;
        this.alamat = alamat;
        this.spesialis = spesialis;
        this.deleted_at = deleted_at;
    }
    
    public int getId_doker() {
        return id_doker;
    }

    public void setId_doker(int id_doker) {
        this.id_doker = id_doker;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getSpesialis() {
        return spesialis;
    }

    public void setSpesialis(String spesialis) {
        this.spesialis = spesialis;
    }

    public Timestamp getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(Timestamp deleted_at) {
        this.deleted_at = deleted_at;
    }
    
    public Dokter clone() {
        return new Dokter(nama, alamat, spesialis, deleted_at);
    }
    
}
