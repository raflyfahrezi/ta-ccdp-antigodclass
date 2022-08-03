/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.tindakan.form;

import application.base.BaseRepository;
import application.tindakan.Tindakan;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author GifarF
 */
public class TindakanFormRepository extends BaseRepository {
    
    public boolean update(Tindakan tindakan) {
        boolean success = false;
        String sql = "UPDATE tindakan SET nama = ?, harga= ? where id_tindakan = ? ";
        
        try {
            Connection con = db.getConnection();
            
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, tindakan.getNama_tindakan());
            preparedStatement.setString(2, tindakan.getHarga_tindakan().toString());
            preparedStatement.setInt(3, tindakan.getId_tindakan());
            
            preparedStatement.execute();
            
            success = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return success;
    }
    
    public boolean create(Tindakan tindakan) {
        boolean success = false;
        String sql = "INSERT INTO tindakan (nama, harga) VALUES (?, ?)";
        
        try {
            Connection con = db.getConnection();
            
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, tindakan.getNama_tindakan());
            preparedStatement.setString(2, tindakan.getHarga_tindakan().toString());
            
            preparedStatement.execute();
            
            success = true;
            
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return success;
    }
}
