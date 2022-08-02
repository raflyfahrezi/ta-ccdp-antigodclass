/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.pemeriksaan.form.tindak;

import java.math.BigInteger;

/**
 *
 * @author Azis Naufal
 */
public class tindak {
    private int no_nota;
    private int id_tindakan = -1;
    private String nama_tindakan;
    private BigInteger harga;
    private boolean saveRequest = false;

    public boolean isSaveRequest() {
        return saveRequest;
    }

    public void setSaveRequest(boolean saveRequest) {
        this.saveRequest = saveRequest;
    }

    public String getNama_tindakan() {
        return nama_tindakan;
    }

    public void setNama_tindakan(String nama_tindakan) {
        this.nama_tindakan = nama_tindakan;
    }

    public int getNo_nota() {
        return no_nota;
    }

    public void setNo_nota(int no_nota) {
        this.no_nota = no_nota;
    }

    public int getId_tindakan() {
        return id_tindakan;
    }

    public void setId_tindakan(int id_tindakan) {
        this.id_tindakan = id_tindakan;
    }

    public BigInteger getHarga() {
        return harga;
    }

    public void setHarga(BigInteger harga) {
        this.harga = harga;
    }
}
