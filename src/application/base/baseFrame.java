/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.base;

import java.awt.Cursor;


/**
 *
 * @author Azis Naufal
 */
public abstract class baseFrame extends javax.swing.JFrame{

    public baseFrame() {
        setTitle(setWindowTitle());
    }

    abstract protected String setWindowTitle();
    
    protected void setPositionCenter(){
        this.setLocationRelativeTo(null);
    }
    
    protected void setWaitCursor(){
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    }
    
    protected void setDefaultCursor(){
        this.setCursor(Cursor.getDefaultCursor());
    }
    
}
