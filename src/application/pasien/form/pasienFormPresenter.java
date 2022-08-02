/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.pasien.form;

import application.pasien.pasien;

/**
 *
 * @author Lenovo
 */
public class pasienFormPresenter {
    private pasienFormView view;
    private pasienFormRepository repos;
    private pasien pasien = new pasien();

    public pasienFormPresenter(pasienFormView view) {
        this.view = view;
        this.repos = new pasienFormRepository();
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
    
    public void setPasien(pasien pasien) {
        this.pasien = pasien;
        view.showData(pasien);
    }
    
    public pasien getPasien() {
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
