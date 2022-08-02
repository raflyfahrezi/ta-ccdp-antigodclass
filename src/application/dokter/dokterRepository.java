/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.dokter;

import application.base.baseRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Azis Naufal
 */
public class dokterRepository extends baseRepository{
    
    public List<dokter> getData(){
        List<dokter> dokters = new ArrayList<>();
        
        String sql = "SELECT * FROM dokter WHERE deleted_at is null";
        try {
            Connection con = db.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                dokter dokter = new dokter();
                dokter.setAlamat(resultSet.getString("alamat_dokter"));
                dokter.setDeleted_at(resultSet.getTimestamp("deleted_at"));
                dokter.setId_doker(resultSet.getInt("id_dokter"));
                dokter.setNama(resultSet.getString("nama_dokter"));
                dokter.setSpesialis(resultSet.getString("spesialis"));
                
                dokters.add(dokter);
            }
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dokters;
    }
    
    public List<dokter> getData(String search){
        List<dokter> dokters = new ArrayList<>();
        
        String sql = "SELECT * FROM dokter WHERE deleted_at is null and "
                + "alamat_dokter like ? or "
                + "nama_dokter like ? or "
                + "spesialis like ?";
        
        try {
            Connection con = db.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, search);
            preparedStatement.setString(2, search);
            preparedStatement.setString(3, search);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                dokter dokter = new dokter();
                dokter.setAlamat(resultSet.getString("alamat_dokter"));
                dokter.setDeleted_at(resultSet.getTimestamp("deleted_at"));
                dokter.setId_doker(resultSet.getInt("id_dokter"));
                dokter.setNama(resultSet.getString("nama_dokter"));
                dokter.setSpesialis(resultSet.getString("spesialis"));
                
                dokters.add(dokter);
            }
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dokters;
    }
    
    public boolean destroy(int id){
        List<dokter> dokters = new ArrayList<>();
        
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(timestamp);
        
        String sql = "update dokter set deleted_at = ? where id_dokter = ?";
        
        boolean success = false;
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