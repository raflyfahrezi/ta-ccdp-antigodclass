/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.dokter;

import java.util.List;
import application.base.baseView;

/**
 *
 * @author Azis Naufal
 */
public interface dokterView extends baseView {
    void loadTable(List<dokter> dokters);
    int delConfirm();
    void setDefaultState();
}
