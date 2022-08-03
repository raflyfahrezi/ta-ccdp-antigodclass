/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.dokter.form;

import application.dokter.*;
import application.base.BaseView;

/**
 *
 * @author Azis Naufal
 */
public interface DokterFormView extends BaseView{
    void back();
    void showData(Dokter dokter);
}
