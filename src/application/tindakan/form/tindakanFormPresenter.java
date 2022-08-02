/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.tindakan.form;

import application.tindakan.tindakan;
import java.math.BigInteger;

/**
 *
 * @author GifarF
 */
public class tindakanFormPresenter {
    private tindakanFormView view;
    private tindakanFormRepository repos;
    private tindakan tindakan = new tindakan();

    public tindakanFormPresenter(tindakanFormView view) {
        this.view = view;
        this.repos = new tindakanFormRepository();
    }

    public void setNama(String nama) {
        tindakan.setNama_tindakan(nama);
    }
    
    public void setHargaTindakan(String harga) {
        tindakan.setHarga_tindakan(new BigInteger(harga));
    }
    
    public void setTindakan(tindakan tindakan) {
        this.tindakan = tindakan;
        view.showData(tindakan);
    }
    
    public void save() {
        boolean success = false;
        
        if (tindakan.getId_tindakan()< 0) {
            success = repos.create(tindakan);
        } else {
            success = repos.update(tindakan);
        }
        
        if (success) {
            view.showSuccess("Data Berhasil disimpan!");
            view.back();
        } else {
            view.showError("Data Gagal disimpan!");
        }
    }
}
