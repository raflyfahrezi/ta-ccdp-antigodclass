/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.tindakan;

import java.util.List;
import application.base.baseView;
/**
 *
 * @author GifarF
 */
public interface tindakanView extends baseView{
    void loadTable(List<tindakan> tindakan);
    int delConfirm();
    void setDefaultState();
}
