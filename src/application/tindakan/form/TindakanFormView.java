/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.tindakan.form;

import application.tindakan.Tindakan;
import application.base.BaseView;

/**
 *
 * @author GifarF
 */
public interface  TindakanFormView extends BaseView {
    void back();
    void showData(Tindakan tindakan);
}
