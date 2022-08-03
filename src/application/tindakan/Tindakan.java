/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.tindakan;

import java.math.BigInteger;
import java.sql.Timestamp;

/**
 *
 * @author GifarF
 */
public class Tindakan {
    private int id_tindakan = -1;
    private String nama_tindakan;
    private BigInteger harga_tindakan;
    private Timestamp delete_at;

    public int getId_tindakan() {
        return id_tindakan;
    }

    public void setId_tindakan(int id_tindakan) {
        this.id_tindakan = id_tindakan;
    }

    public String getNama_tindakan() {
        return nama_tindakan;
    }

    public void setNama_tindakan(String nama_tindakan) {
        this.nama_tindakan = nama_tindakan;
    }

    public BigInteger getHarga_tindakan() {
        return harga_tindakan;
    }

    public void setHarga_tindakan(BigInteger harga_tindakanp) {
        this.harga_tindakan = harga_tindakanp;
    }

    public Timestamp getDelete_at() {
        return delete_at;
    }

    public void setDelete_at(Timestamp delete_at) {
        this.delete_at = delete_at;
    }
    
}
