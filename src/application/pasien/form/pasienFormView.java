/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.pasien.form;

import application.pasien.pasien;
import application.base.baseView;

/**
 *
 * @author Lenovo
 */
public interface  pasienFormView extends baseView {
    void back();
    void showData(pasien pasien);
}
