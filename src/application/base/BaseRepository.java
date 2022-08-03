/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.base;

import application.util.MySQLConnection;

/**
 *
 * @author Azis Naufal
 */
public class BaseRepository {
    protected MySQLConnection db = null; 

    public BaseRepository() {
        this.db = MySQLConnection.getInstance();
    }

}
