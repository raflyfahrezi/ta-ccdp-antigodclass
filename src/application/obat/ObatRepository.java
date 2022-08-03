/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.obat;

import application.base.BaseRepository;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class ObatRepository extends BaseRepository {
    public List<Obat> getData() {
        List<Obat> obats = new ArrayList<>();
        
        String sql = "SELECT * FROM obat WHERE deleted_at is null";
        
        try {
            Connection con = db.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()) {
                Obat obat = new Obat();
                
                obat.setId_obat(resultSet.getInt("id_obat"));
                obat.setNama(resultSet.getString("nama_obat"));
                obat.setHarga(new BigInteger(resultSet.getString("harga")));
                obat.setTanggal_kadaluarsa(resultSet.getDate("tanggal_kadaluarsa"));
                obat.setDeleted_at(resultSet.getTimestamp("deleted_at"));
                
                obats.add(obat);
            }
            
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return obats;
    }
    
    public List<Obat> getData(String searchQuery) {
        List<Obat> obats = new ArrayList<>();
        
        String sql = "SELECT * FROM obat WHERE deleted_at is null and "
                + "nama_obat like ? or "
                + "harga like ? or "
                + "tanggal_kadaluarsa like ?";
        
        try {
            Connection con = db.getConnection();
            
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, searchQuery);
            preparedStatement.setString(2, searchQuery);
            preparedStatement.setString(3, searchQuery);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()) {
                Obat obat = new Obat();
                
                obat.setId_obat(resultSet.getInt("id_obat"));
                obat.setNama(resultSet.getString("nama_obat"));
                obat.setHarga(new BigInteger(resultSet.getString("harga")));
                obat.setTanggal_kadaluarsa(resultSet.getDate("tanggal_kadaluarsa"));
                
                obats.add(obat);
            }
            
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return obats;
    }
    
    public boolean destroy(int id) {
        List<Obat> obats = new ArrayList<>();
        boolean success = false;
        
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(timestamp);
        
        String sql = "UPDATE obat SET deleted_at = ? where id_obat = ?";
        
        try {
            Connection con = db.getConnection();
            
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            
            preparedStatement.setString(1, time);
            preparedStatement.setInt(2, id);
            
            preparedStatement.execute();
            
            success = true;
            
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return success;
    }
}
