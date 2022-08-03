/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.tindakan;

import java.util.List;
import application.base.BaseView;
/**
 *
 * @author GifarF
 */
public interface TindakanView extends BaseView{
    void loadTable(List<Tindakan> tindakan);
    int delConfirm();
    void setDefaultState();
}
