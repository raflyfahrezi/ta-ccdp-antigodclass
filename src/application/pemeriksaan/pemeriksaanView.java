/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.pemeriksaan;

import java.util.List;
import application.base.baseView;

/**
 *
 * @author VaniaM
 */
public interface pemeriksaanView extends baseView {
    void loadData();
    void loadTable(List<pemeriksaan> pemeriksaans);
    int delConfirm();
    void setDefaultState();
}
