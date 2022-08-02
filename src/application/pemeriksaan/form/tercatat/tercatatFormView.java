/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.pemeriksaan.form.tercatat;

import application.base.baseView;

/**
 *
 * @author Azis Naufal
 */
public interface tercatatFormView extends baseView{
    void loadObat(String[] obats);
    void showSubtotal(String subtotal);
    void showHarga(String harga);
    void showData(tercatat tercatat);
    void back();
}
