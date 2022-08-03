/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.obat.form;

import application.obat.Obat;
import java.util.Date;
import application.base.BaseView;

/**
 *
 * @author Lenovo
 */
public interface ObatFormView extends BaseView {
    void back();
    void showData(Obat obat, Date kadaluarsa);
}
