/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.obat;

import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface obatView {
    int deleteConfirm();
    void setDefaultState();
    void loadTable(List<obat> obats);
    void showSuccess(String msg);
    void showError(String msg);
}
