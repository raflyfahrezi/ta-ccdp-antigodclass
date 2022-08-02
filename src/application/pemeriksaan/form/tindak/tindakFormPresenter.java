/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.pemeriksaan.form.tindak;

import application.tindakan.tindakan;
import application.tindakan.tindakanRepository;
import java.util.List;

/**
 *
 * @author Azis Naufal
 */
public class tindakFormPresenter {
    private tindakFormView view = null;
    private List<tindakan> tindakans = null;
    private tindakanRepository tindakanRepository;
    private tindak tindak;

    public tindakFormPresenter(tindakFormView view) {
        this.tindakanRepository = new tindakanRepository();
        this.view = view;
        this.tindak = new tindak();
    }

    public void setTindak(tindak tindak) {
        this.tindak = tindak;
        view.showData(tindak);
    }
    
    public tindak getTindak(){
        return tindak;
    }
    
    public void setId_tindakan(int index){
        if (index > 0){
            int id_tindakan = tindakans.get(index-1).getId_tindakan();
            tindak.setId_tindakan(id_tindakan);
            tindak.setNama_tindakan(tindakans.get(index-1).getNama_tindakan());
            tindak.setHarga(tindakans.get(index-1).getHarga_tindakan());
            view.showHarga("Rp " + tindak.getHarga().toString());
        }
    }
    
    void loadData() {
        tindakans = tindakanRepository.getData();
        String[] strTindakan = new String[tindakans.size()+1];
        strTindakan[0] = "-";
        for (int i = 1; i < strTindakan.length; i++) {
            strTindakan[i] = tindakans.get(i-1).getNama_tindakan();
        }
        view.loadTindakan(strTindakan);
    }
    
    void validate(){
        if (tindak.getId_tindakan() == -1){
            view.showError("Anda belum memilih tindakan!");
        }
        else {
            tindak.setSaveRequest(true);
            view.back();
        }
    }
    
}
