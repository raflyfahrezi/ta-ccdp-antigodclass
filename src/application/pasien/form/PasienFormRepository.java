/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.pasien.form;

import application.base.BaseRepository;
import application.pasien.Pasien;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Lenovo
 */
public class PasienFormRepository extends BaseRepository {
    
    public boolean update(Pasien pasien) {
        boolean success = false;
        String sql = "UPDATE pasien SET nama = ?, jenis_kelamin = ?, alamat = ?, umur = ? where id_pasien = ? ";
        
        try {
            Connection con = db.getConnection();
            
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, pasien.getNama());
            preparedStatement.setString(2, pasien.getJenis_kelamin());
            preparedStatement.setString(3, pasien.getAlamat());
            preparedStatement.setString(4, pasien.getUmur());
            preparedStatement.setInt(5, pasien.getId_pasien());
            
            preparedStatement.execute();
            
            success = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return success;
    }
    
    public boolean create(Pasien pasien) {
        boolean success = false;
        String sql = "INSERT INTO pasien (nama, jenis_kelamin, alamat, umur) VALUES (?, ?, ?, ?)";
        
        try {
            Connection con = db.getConnection();
            
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, pasien.getNama());
            preparedStatement.setString(2, pasien.getJenis_kelamin());
            preparedStatement.setString(3, pasien.getAlamat());
            preparedStatement.setString(4, pasien.getUmur());
            
            preparedStatement.execute();
            
            success = true;
            
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return success;
    }
}
