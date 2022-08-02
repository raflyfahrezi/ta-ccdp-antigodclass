/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.dokter.form;

import application.dokter.*;
import application.base.baseView;

/**
 *
 * @author Azis Naufal
 */
public interface dokterFormView extends baseView{
    void back();
    void showData(dokter dokter);
}
