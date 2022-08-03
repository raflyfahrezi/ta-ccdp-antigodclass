/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.dokter.form;

import application.dokter.*;
import application.base.BaseRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Azis Naufal
 */
public class DokterFormRepository extends BaseRepository{

    public boolean update(Dokter dokter){
        
        String sql = "update dokter set nama_dokter = ?, alamat_dokter = ?, spesialis = ? where id_dokter = ?";
        
        boolean success = false;
        try {
            Connection con = db.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, dokter.getNama());
            preparedStatement.setString(2, dokter.getAlamat());
            preparedStatement.setString(3, dokter.getSpesialis());
            preparedStatement.setInt(4, dokter.getId_doker());
            
            preparedStatement.execute();
            
            success = true;
            
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }
    
    public boolean create(Dokter dokter){
        
        String sql = "INSERT INTO dokter (nama_dokter, alamat_dokter, spesialis) VALUES (?, ?, ?)";
        
        boolean success = false;
        try {
            Connection con = db.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, dokter.getNama());
            preparedStatement.setString(2, dokter.getAlamat());
            preparedStatement.setString(3, dokter.getSpesialis());
            
            preparedStatement.execute();
            
            success = true;
            
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }
}
