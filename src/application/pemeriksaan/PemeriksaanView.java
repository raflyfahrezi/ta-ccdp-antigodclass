/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.pemeriksaan;

import java.util.List;
import application.base.BaseView;

/**
 *
 * @author VaniaM
 */
public interface PemeriksaanView extends BaseView {
    void loadData();
    void loadTable(List<Pemeriksaan> pemeriksaans);
    int delConfirm();
    void setDefaultState();
}
