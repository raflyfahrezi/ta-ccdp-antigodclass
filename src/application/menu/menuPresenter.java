/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.menu;

import application.pasien.pasienInternalFrame;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 *
 * @author Farhan Rafly Fahrezi
 */
public class menuPresenter {
    private menuView view;
    
    public menuPresenter(menuView view) {
        this.view = view;
    }
    
    public void keluar() {
        if (view.menuExit() == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
   
}
