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
public class dokterFormPresenter {
    private dokterFormView view;
    private dokterFormRepository repo;
    private dokter dokter = new dokter();

    public dokterFormPresenter(dokterFormView view) {
        this.view = view;
        this.repo = new dokterFormRepository();
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
    
    public void setDokter(dokter dokter){
        this.dokter = dokter;
        view.showData(dokter);
    }
    
    public dokter getDokter() {
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
