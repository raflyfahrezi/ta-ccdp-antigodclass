/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.tindakan.form;

import application.tindakan.tindakan;
import application.base.baseView;

/**
 *
 * @author GifarF
 */
public interface  tindakanFormView extends baseView {
    void back();
    void showData(tindakan tindakan);
}
