/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.pemeriksaan.form.tindak;

import application.base.baseView;

/**
 *
 * @author Azis Naufal
 */
public interface tindakFormView extends baseView{
    void loadTindakan(String[] tindakans);
    void showHarga(String harga);
    void showData(tindak tindak);
    void back();
}
