/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.tindakan.form;

import application.tindakan.Tindakan;
import java.math.BigInteger;

/**
 *
 * @author GifarF
 */
public class TindakanFormPresenter {
    private TindakanFormView view;
    private TindakanFormRepository repos;
    private Tindakan tindakan = new Tindakan();

    public TindakanFormPresenter(TindakanFormView view) {
        this.view = view;
        this.repos = new TindakanFormRepository();
    }

    public void setNama(String nama) {
        tindakan.setNama_tindakan(nama);
    }
    
    public void setHargaTindakan(String harga) {
        tindakan.setHarga_tindakan(new BigInteger(harga));
    }
    
    public void setTindakan(Tindakan tindakan) {
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
