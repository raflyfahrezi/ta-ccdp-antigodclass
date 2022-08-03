/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.pemeriksaan.form.tercatat;

import application.base.BaseView;

/**
 *
 * @author Azis Naufal
 */
public interface TercatatFormView extends BaseView{
    void loadObat(String[] obats);
    void showSubtotal(String subtotal);
    void showHarga(String harga);
    void showData(Tercatat tercatat);
    void back();
}
