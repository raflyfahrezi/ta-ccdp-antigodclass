/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.pasien;

import java.util.List;
import application.base.BaseView;

/**
 *
 * @author Lenovo
 */
public interface PasienView extends BaseView {
    int deleteConfirm();
    void loadTable(List<Pasien> pasiens);
    void setDefaultState();
}
