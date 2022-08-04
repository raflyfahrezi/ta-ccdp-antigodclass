/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.dokter;

import java.util.List;
import application.base.BaseView;

/**
 *
 * @author Azis Naufal
 */
public interface DokterView extends BaseView {
    void loadTable(List<Dokter> dokters);
    int delConfirm();
}
