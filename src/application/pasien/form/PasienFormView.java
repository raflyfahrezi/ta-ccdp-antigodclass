/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.pasien.form;

import application.pasien.Pasien;
import application.base.BaseView;

/**
 *
 * @author Lenovo
 */
public interface  PasienFormView extends BaseView {
    void back();
    void showData(Pasien pasien);
}
