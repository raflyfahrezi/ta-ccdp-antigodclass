/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.pemeriksaan.form.tindak;

import application.base.BaseView;

/**
 *
 * @author Azis Naufal
 */
public interface TindakFormView extends BaseView{
    void loadTindakan(String[] tindakans);
    void showHarga(String harga);
    void showData(Tindak tindak);
    void back();
}
