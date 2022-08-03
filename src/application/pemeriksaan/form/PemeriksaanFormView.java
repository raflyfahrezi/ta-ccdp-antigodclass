/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.pemeriksaan.form;

import application.pemeriksaan.Pemeriksaan;
import application.pemeriksaan.form.tercatat.Tercatat;
import application.pemeriksaan.form.tindak.Tindak;
import java.util.LinkedList;
import application.base.BaseView;

/**
 *
 * @author Azis Naufal
 */
public interface PemeriksaanFormView extends BaseView{
    void back();
    void loadDokter(String[] dokters);
    void loadPasien(String[] pasiens);
    void setHargaTindakan(String harga);
    void populateObat(String harga, String subtotal);
    void showTotal(String total);
    void showData(Pemeriksaan pemeriksaan, LinkedList<Tindak> tindaks, LinkedList<Tercatat> tercatats);
}
