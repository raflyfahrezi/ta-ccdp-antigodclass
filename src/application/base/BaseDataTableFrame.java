/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.base;

import java.awt.Cursor;
import javax.swing.JOptionPane;

/**
 *
 * @author Azis Naufal
 */
public abstract class BaseDataTableFrame extends javax.swing.JInternalFrame{
    public BaseDataTableFrame() {
        setTitle(setWindowTitle());
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
    }
   
    abstract protected String setWindowTitle();
    
    protected void showMessageSuccess(String s){
        JOptionPane.showMessageDialog(rootPane, s, "Sukses", JOptionPane.INFORMATION_MESSAGE);
    }
    
    protected void showMessageError(String s){
        JOptionPane.showMessageDialog(rootPane, s, "Gagal", JOptionPane.ERROR_MESSAGE);
    }
    
    protected void setWaitCursor(){
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    }
    
    protected void setDefaultCursor(){
        this.setCursor(Cursor.getDefaultCursor());
    }
}
