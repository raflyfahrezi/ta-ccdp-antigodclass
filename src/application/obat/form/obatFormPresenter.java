/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.obat.form;

import application.obat.obat;
import java.math.BigInteger;
import java.sql.Date;

/**
 *
 * @author Lenovo
 */
public class obatFormPresenter {
    private obatFormView view;
    private obatFormRepository repos;
    private obat obat = new obat();
    
    public obatFormPresenter(obatFormView view) {
        this.view = view;
        this.repos = new obatFormRepository();
    }
    
    public void setNamaObat(String namaObat) {
        obat.setNama(namaObat);
    }
    
    public void setHargaObat(String hargaObat) {
        obat.setHarga(new BigInteger(hargaObat));
    }
    
    public void setTanggalKadaluarsa(Date tanggalKadaluarsa) {
        obat.setTanggal_kadaluarsa(tanggalKadaluarsa);
    }
    
    public void setObat(obat obat) {
        this.obat = obat;
        Date kadaluarsa = new Date(obat.getTanggal_kadaluarsa().getTime());
        view.showData(obat, kadaluarsa);
    }
    
    public obat getObat() {
        return obat;
    }
    
    public void save() {
        boolean success = false;
        
        if (obat.getId_obat() < 0) {
            success = repos.create(obat);
        } else {
            success = repos.update(obat);
        }
        
        if (success) {
            view.showSuccess("Data Berhasil disimpan");
            view.back();
        } else {
            view.showError("Data Gagal disimpan");
        }
    }
}
