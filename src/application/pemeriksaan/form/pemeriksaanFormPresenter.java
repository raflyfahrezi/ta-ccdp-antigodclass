/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.pemeriksaan.form;

import application.pemeriksaan.form.tindak.tindak;
import application.pemeriksaan.form.tercatat.tercatat;
import application.dokter.*;
import application.pasien.pasien;
import application.pasien.pasienRepository;
import application.pemeriksaan.pemeriksaan;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author Azis Naufal
 */
public class pemeriksaanFormPresenter {
    private pemeriksaanFormView view;
    private pemeriksaanFormRepository pemeriksaanFormRepository;
    private pemeriksaan pemeriksaan;
    private List<dokter> dokters = null;
    private dokterRepository dokterRepository;
    private List<pasien> pasiens = null;
    private pasienRepository pasienRepository;
    private LinkedList<tercatat> tercatat = null;
    private LinkedList<tindak> tindak = null;

    public pemeriksaanFormPresenter(pemeriksaanFormView view) {
        this.view = view;
        this.pemeriksaanFormRepository = new pemeriksaanFormRepository();
        this.pemeriksaan = new pemeriksaan();
        this.dokterRepository = new dokterRepository();
        this.pasienRepository = new pasienRepository();
        this.tercatat = new LinkedList<>();
        this.tindak = new LinkedList<>();
    }
   
    public pemeriksaan getPemeriksaan() {
        return pemeriksaan;
    }

    public void setPemeriksaan(pemeriksaan pemeriksaan) {
        this.pemeriksaan = pemeriksaan;
        this.tercatat = pemeriksaanFormRepository.getTercatat(pemeriksaan.getNo_nota());
        this.tindak = pemeriksaanFormRepository.getTindak(pemeriksaan.getNo_nota());
        view.showData(pemeriksaan, tindak, tercatat);
    }

    public void loadPasien(){
        pasiens = pasienRepository.getData();
        String[] strPasiens = new String[pasiens.size()+1];
        strPasiens[0] = "-";
        for (int i = 1; i < strPasiens.length; i++) {
            strPasiens[i] = pasiens.get(i-1).getNama();
        }
        view.loadPasien(strPasiens);
    }
    
    public void loadDokter(){
        dokters = dokterRepository.getData();
        String[] strDokter = new String[dokters.size()+1];
        strDokter[0] = "-";
        for (int i = 1; i < strDokter.length; i++) {
            strDokter[i] = dokters.get(i-1).getNama();
        }
        view.loadDokter(strDokter);
    }

    void calculateObat(tercatat tercatatObj) {
        tercatat.add(tercatatObj);
        calculateTotal();
    }
    
    void calculateObat(tercatat tercatatObj, int posisi) {
        tercatat.set(posisi, tercatatObj);
        calculateTotal();
    }
    
    tercatat getTercatat(int index){
        try {
            return tercatat.get(index);
        }
        catch (Exception e){
            return null;
        }
    }
    
    void calculateTindakan(tindak tindakObj) {
        tindak.add(tindakObj);
        calculateTotal();
    }
    
    void calculateTindakan(tindak tindakObj, int posisi) {
        tindak.set(posisi, tindakObj);
        calculateTotal();
    }
    
    tindak getTindak(int index){
        try {
            return tindak.get(index);
        }
        catch (Exception e){
            return null;
        }
    }
    
    void removeObat(int index){
        try{
            tercatat.remove(index+1);
        }
        catch (Exception e){
            
        }
        calculateTotal();
    }
    
    void removeTindakan(int index){
        try {
            tindak.remove(index+1);
        }
        catch(Exception e){
            
        }
        calculateTotal();
    }
    
    void calculateTotal(){
        BigInteger total = new BigInteger("0");
        ListIterator iter = tercatat.listIterator();
        while (iter.hasNext()) {
            tercatat item = (tercatat) iter.next();
            total = total.add(item.getSubtotal());
        }
        
        iter = tindak.listIterator();
        while (iter.hasNext()) {
            tindak item = (tindak) iter.next();
            total = total.add(item.getHarga());
        }
        pemeriksaan.setTotal(total);
        
        view.showTotal("Rp "+total.toString());
    }

    void setDokter(int i) {
        pemeriksaan.setId_dokter(dokters.get(i).getId_doker());
    }

    void setPasien(int i) {
        pemeriksaan.setId_pasien(pasiens.get(i).getId_pasien());
    }

    void setTinggiBadan(String text) {
        pemeriksaan.setTinggi_badan(Float.parseFloat(text));
    }

    void setBeratBadan(String text) {
        pemeriksaan.setBerat_badan(Float.parseFloat(text));
    }

    void setSistolik(String text) {
        pemeriksaan.setSistolik(Integer.parseInt(text));
    }

    void setDiastolik(String text) {
        pemeriksaan.setDiastolik(Integer.parseInt(text));
    }

    void setTanggalPemeriksaan(Calendar cal) {
        if (cal != null){
            pemeriksaan.setTanggal(new java.sql.Date(cal.getTimeInMillis()));
        }
    }
    
    void validateAndSubmit() {
        if (pemeriksaan.getTanggal() == null){
            view.showError("Tanggal pemeriksaan belum terisi.");
        }
        else if (pemeriksaan.getId_dokter() == -1){
            view.showError("Dokter belum terpilih.");
        }
        else if (pemeriksaan.getId_pasien() == -1){
            view.showError("Pasien belum terpilih.");
        }
        else if (tindak.isEmpty()){
            view.showError("Belum ada tindakan terpilih.");
        }
        else {
            if (pemeriksaan.getNo_nota() == -1){
                save();
            }
            else {
                update();
            }
        }
    }
    
    private void save(){
        int no_nota = pemeriksaanFormRepository.create(pemeriksaan);
        if (no_nota == -1){
            view.showError("Data gagal disimpan.");
        }
        else {
            boolean success = pemeriksaanFormRepository.createTindak(no_nota, tindak);
            if (success){
                success = pemeriksaanFormRepository.createTercatat(no_nota, tercatat);
                if (success){
                    view.showSuccess("Data berhasil disimpan");
                    view.back();
                }
                else {
                    pemeriksaanFormRepository.deleteTindak(no_nota);
                    pemeriksaanFormRepository.deletePemeriksaan(no_nota);
                    view.showError("Data gagal disimpan.");
                }
            }
            else {
                pemeriksaanFormRepository.deletePemeriksaan(no_nota);
                view.showError("Data gagal disimpan.");
            }
        }
    }
    
    private void update(){
        boolean success = pemeriksaanFormRepository.update(pemeriksaan);
        if (success){
            pemeriksaanFormRepository.deleteTindak(pemeriksaan.getNo_nota());
            pemeriksaanFormRepository.deleteTercatat(pemeriksaan.getNo_nota());
            
            success = pemeriksaanFormRepository.createTindak(pemeriksaan.getNo_nota(), tindak);
            if (success){
                success = pemeriksaanFormRepository.createTercatat(pemeriksaan.getNo_nota(), tercatat);
                if (success){
                    view.showSuccess("Data berhasil disimpan");
                    view.back();
                }
                else {
                    view.showError("Data gagal disimpan.");
                }
            }
            else {
                view.showError("Data gagal disimpan.");
            }
        }
        else {
            view.showError("Data gagal disimpan.");
        }
    }
}
