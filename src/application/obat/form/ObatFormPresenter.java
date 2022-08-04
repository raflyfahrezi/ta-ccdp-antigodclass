/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.obat.form;

import application.obat.Obat;
import java.math.BigInteger;
import java.sql.Date;

/**
 *
 * @author Lenovo
 */
public class ObatFormPresenter {
    private ObatFormView view;
    private ObatFormRepository repos;
    private Obat obat = new Obat();
    
    public ObatFormPresenter(ObatFormView view) {
        this.view = view;
        this.repos = new ObatFormRepositoryProxy();
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
    
    public void setObat(Obat obat) {
        this.obat = obat;
        Date kadaluarsa = new Date(obat.getTanggal_kadaluarsa().getTime());
        view.showData(obat, kadaluarsa);
    }
    
    public Obat getObat() {
        return obat;
    }
    
    public void save() {
        boolean success = false;
        
        try {
            if (obat.getId_obat() < 0) {
                success = repos.create(obat);
            } else {
                success = repos.update(obat);
            }
        }
        catch (Exception e) {
            view.showError(e.getMessage());
        }
        
        if (success) {
            view.showSuccess("Data Berhasil disimpan");
            view.back();
        } else {
            view.showError("Data Gagal disimpan");
        }
    }
}
