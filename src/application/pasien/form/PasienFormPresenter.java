/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.pasien.form;

import application.pasien.Pasien;

/**
 *
 * @author Lenovo
 */
public class PasienFormPresenter {
    private PasienFormView view;
    private PasienFormRepository repos;
    private Pasien pasien = new Pasien();

    public PasienFormPresenter(PasienFormView view) {
        this.view = view;
        this.repos = new PasienFormRepository();
    }

    public void setNama(String nama) {
        pasien.setNama(nama);
    }
    
    public void setJenisKelamin(String jenisKelamin) {
        pasien.setJenis_kelamin(jenisKelamin);
    }
    
    public void setUmur(String umur) {
        pasien.setUmur(umur);
    }
    
    public void setAlamat(String alamat) {
        pasien.setAlamat(alamat);
    }
    
    public void setPasien(Pasien pasien) {
        this.pasien = pasien;
        view.showData(pasien);
    }
    
    public Pasien getPasien() {
        return pasien;
    }
    
    public void save() {
        boolean success = false;
        
        if (pasien.getId_pasien() < 0) {
            success = repos.create(pasien);
        } else {
            success = repos.update(pasien);
        }
        
        if (success) {
            view.showSuccess("Data Berhasil disimpan!");
            view.back();
        } else {
            view.showError("Data Gagal disimpan!");
        }
    }
}
