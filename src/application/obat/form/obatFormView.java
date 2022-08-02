/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.obat.form;

import application.obat.obat;
import java.util.Date;
import application.base.baseView;

/**
 *
 * @author Lenovo
 */
public interface obatFormView extends baseView {
    void back();
    void showData(obat obat, Date kadaluarsa);
}
