/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.pemeriksaan.form.tercatat;

import application.obat.Obat;
import application.obat.ObatRepository;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author Azis Naufal
 */
public class TercatatFormPresenter {
    private TercatatFormView view = null;
    private List<Obat> obats = null;
    private ObatRepository obatRepository;
    private Tercatat tercatat;

    public TercatatFormPresenter(TercatatFormView view) {
        this.obatRepository = new ObatRepository();
        this.view = view;
        this.tercatat = new Tercatat();
    }

    public Tercatat getTercatat() {
        return tercatat;
    }

    public void setTercatat(Tercatat tercatat) {
        this.tercatat = tercatat;
        view.showData(tercatat);
    }
    
    public void setId_obat(int index){
        int id_obat = obats.get(index-1).getId_obat();
        tercatat.setId_obat(id_obat);
        tercatat.setHarga(obats.get(index-1).getHarga());
        tercatat.setNama_obat(obats.get(index-1).getNama());
        BigInteger subtotal = tercatat.getHarga().multiply(new BigInteger(tercatat.getQty()+""));
        tercatat.setSubtotal(subtotal);
        view.showSubtotal("Rp " + subtotal.toString());
        view.showHarga("Rp " + obats.get(index - 1).getHarga().toString());
    }
    
    public void setQty(int qty){
        tercatat.setQty(qty);
        BigInteger subtotal = tercatat.getHarga().multiply(new BigInteger(tercatat.getQty()+""));
        tercatat.setSubtotal(subtotal);
        view.showSubtotal("Rp " + subtotal.toString());
    }
    
    public void loadData(){
        obats = obatRepository.getData();
        String[] strObat = new String[obats.size()+1];
        strObat[0] = "-";
        for (int i = 1; i < strObat.length; i++) {
            strObat[i] = obats.get(i-1).getNama();
        }
        view.loadObat(strObat);
    }

    void validate() {
        if (tercatat.getId_obat() == -1){
            view.showError("Anda belum memilih obat.");
        }
        else if (tercatat.getQty() == 0){
            view.showError("Anda belum mengisi jumlah obat.");
        }
        else {
            tercatat.setSaveRequest(true);
            view.back();
        }
    }
    
}
