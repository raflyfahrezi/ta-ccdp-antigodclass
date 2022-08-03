/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.pemeriksaan.form.tindak;

import application.tindakan.Tindakan;
import application.tindakan.TindakanRepository;
import java.util.List;

/**
 *
 * @author Azis Naufal
 */
public class TindakFormPresenter {
    private TindakFormView view = null;
    private List<Tindakan> tindakans = null;
    private TindakanRepository tindakanRepository;
    private Tindak tindak;

    public TindakFormPresenter(TindakFormView view) {
        this.tindakanRepository = new TindakanRepository();
        this.view = view;
        this.tindak = new Tindak();
    }

    public void setTindak(Tindak tindak) {
        this.tindak = tindak;
        view.showData(tindak);
    }
    
    public Tindak getTindak(){
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
