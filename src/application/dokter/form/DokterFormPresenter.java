/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.dokter.form;

import application.dokter.*;

/**
 *
 * @author Azis Naufal
 */
public class DokterFormPresenter {
    private DokterFormView view;
    private DokterFormRepository repo;
    private Dokter dokter = new Dokter();

    public DokterFormPresenter(DokterFormView view) {
        this.view = view;
        this.repo = new DokterFormRepository();
    }

    public void setSpesialis(String s) {
        dokter.setSpesialis(s);
    }
    
    public void setAlamat(String s) {
        dokter.setAlamat(s);
    }
    
    public void setNama(String s) {
        dokter.setNama(s);
    }
    
    public void setDokter(Dokter dokter){
        this.dokter = dokter;
        view.showData(dokter);
    }
    
    public Dokter getDokter() {
        return dokter;
    }
    
    public void save(){
        boolean success = false;
        if (dokter.getId_doker() < 0){
            success = repo.create(dokter);
        }
        else {
            success = repo.update(dokter);
        }
        
        if (success){
            view.showSuccess("Data berhasil disimpan!");
            view.back();
        }
        else {
            view.showError("Data gagal disimpan!");
        }
    }
}
