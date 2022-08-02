/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.pemeriksaan.form;

import application.pemeriksaan.pemeriksaan;
import application.pemeriksaan.form.tercatat.tercatat;
import application.pemeriksaan.form.tindak.tindak;
import java.util.LinkedList;
import application.base.baseView;

/**
 *
 * @author Azis Naufal
 */
public interface pemeriksaanFormView extends baseView{
    void back();
    void loadDokter(String[] dokters);
    void loadPasien(String[] pasiens);
    void setHargaTindakan(String harga);
    void populateObat(String harga, String subtotal);
    void showTotal(String total);
    void showData(pemeriksaan pemeriksaan, LinkedList<tindak> tindaks, LinkedList<tercatat> tercatats);
}
