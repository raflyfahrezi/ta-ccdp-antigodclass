/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package application.db;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Azis Naufal
 */
public class MySQLConnection {
    private static MySQLConnection instance = null;
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_NAME = "calonwib_klinik";
    private static final String DESTINATION = "jdbc:mysql://calonwibu.masuk.web.id:3306/" + DB_NAME + "?autoReconnect=true&useSSL=false&zeroDateTimeBehavior=convertToNull";
    private static final String DB_USERNAME = "calonwib_klinik";
    private static final String DB_PASSWORD = "DC==&zxRvw}t";
    
    private JDBCConnectionPool connectionPool = null;
    private Connection connection = null;

  
    public static synchronized MySQLConnection getInstance(){
        if (instance == null)
            instance = new MySQLConnection();
        
        return instance;
    }
    
    public Connection getConnection(){
        connectionPool = new JDBCConnectionPool(DRIVER, DESTINATION, DB_USERNAME, DB_PASSWORD);
        
        try{
            connection = connectionPool.takeOut();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Gagal koneksi ke database!", "Gagal", JOptionPane.ERROR_MESSAGE, null);
        }
        
        return connection;
    }
    
    public void close(){
        try {
            connectionPool.dead(connection);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
