/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.base;

import application.util.mySQLConnection;

/**
 *
 * @author Azis Naufal
 */
public class baseRepository {
    protected mySQLConnection db = null; 

    public baseRepository() {
        this.db = mySQLConnection.getInstance();
    }

}
