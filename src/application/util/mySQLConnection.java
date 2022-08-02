/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package application.util;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Azis Naufal
 */
public class mySQLConnection {
    private static mySQLConnection instance = null;
    private Connection con = null;
    
    public static mySQLConnection getInstance(){
        if (instance == null)
            instance = new mySQLConnection();
        
        return instance;
    }
    
    public Connection getConnection(){
        String username = "calonwib_klinik";
        String password = "DC==&zxRvw}t";
        String db = "calonwib_klinik";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://calonwibu.masuk.web.id:3306/" + db + "?autoReconnect=true&useSSL=false&zeroDateTimeBehavior=convertToNull",username, password);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Gagal koneksi ke database!", "Gagal", JOptionPane.ERROR_MESSAGE, null);
        }
        return con;
    }
    
    public void close(){
        try {
            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
