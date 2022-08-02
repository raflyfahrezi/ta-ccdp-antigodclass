/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.pasien;

import application.base.baseRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
/**
 *
 * @author Lenovo
 */
public class pasienRepository extends baseRepository{
      
   public List<pasien> getData() {
       List<pasien> pasiens = new ArrayList<>();
       
       String sql = "SELECT * FROM pasien WHERE deleted_at is null";
       
       try {
           Connection con = db.getConnection();
           PreparedStatement preparedStatement = con.prepareStatement(sql);
           
           ResultSet resultSet = preparedStatement.executeQuery();
           
           while (resultSet.next()) {
               pasien pasien = new pasien();
               
               pasien.setId_pasien(resultSet.getInt("id_pasien"));
               pasien.setNama(resultSet.getString("nama"));
               pasien.setJenis_kelamin(resultSet.getString("jenis_kelamin"));
               pasien.setAlamat(resultSet.getString("alamat"));
               pasien.setUmur(resultSet.getString("umur"));
               pasien.setDeleted_at(resultSet.getTimestamp("deleted_at"));
               
               pasiens.add(pasien);
           }
           
           db.close();
       } catch (Exception e) {
           e.printStackTrace();
       }
       
       return pasiens;
   } 
   
   public List<pasien> getData(String searchQuery) {
       List<pasien> pasiens = new ArrayList<>();
       
       String sql = "SELECT * FROM pasien WHERE deleted_at is null and "
               + "nama like ? or "
               + "jenis_kelamin like ? or "
               + "alamat like ? or "
               + "umur like ?";
       
       try {
           Connection con = db.getConnection();
           
           PreparedStatement preparedStatement = con.prepareStatement(sql);
           preparedStatement.setString(1, searchQuery);
           preparedStatement.setString(2, searchQuery);
           preparedStatement.setString(3, searchQuery);
           preparedStatement.setString(4, searchQuery);
           
           ResultSet resultSet = preparedStatement.executeQuery();
           
           while (resultSet.next()) {
               pasien pasien = new pasien();
               
               pasien.setId_pasien(resultSet.getInt("id_pasien"));
               pasien.setNama(resultSet.getString("nama"));
               pasien.setJenis_kelamin(resultSet.getString("jenis_kelamin"));
               pasien.setAlamat(resultSet.getString("alamat"));
               pasien.setUmur(resultSet.getString("umur"));
               pasien.setDeleted_at(resultSet.getTimestamp("deleted_at"));
               
               pasiens.add(pasien);
           }
           
           db.close();
       } catch (Exception e) {
           e.printStackTrace();
       }
       
       return pasiens;
   }
   
   public boolean destroy(int id){
        List<pasien> pasiens = new ArrayList<>();
        
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(timestamp);
        
        String sql = "update pasien set deleted_at = ? where id_pasien = ?";
        
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
