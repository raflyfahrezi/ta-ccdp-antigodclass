/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.db;

import application.util.ObjectPool;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author azis
 */
class JDBCConnectionPool extends ObjectPool<Connection> {
    String destination, username, password;
 
    JDBCConnectionPool(String driver, String destination, String username, String password) {
        super();
        try {
            Class.forName(driver).newInstance();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        this.destination = destination;
        this.username = username;
        this.password = password;
    }
 
    @Override
    public Connection create() {
        try {
            return (DriverManager.getConnection(destination, username, password));
        }
        catch (SQLException e) {
            e.printStackTrace();
            return (null);
        }
    }
 
    @Override
    public void dead(Connection o) {
        try {
            ((Connection)o).close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    @Override
    public boolean validate(Connection o) {
        try {
            return (!((Connection)o).isClosed());
        }
        catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
}
