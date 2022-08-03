/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.tindakan;

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
 * @author GifarF
 */
public class TindakanRepository extends BaseRepository{
    
    public List<Tindakan> getData(){
        List<Tindakan> tindakans = new ArrayList<>();
        
        String sql = "SELECT * FROM tindakan WHERE deleted_at is null";
        try {
            Connection con = db.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Tindakan tindakan = new Tindakan();
                tindakan.setId_tindakan(resultSet.getInt("id_tindakan"));
                tindakan.setNama_tindakan(resultSet.getString("nama"));
                tindakan.setHarga_tindakan(new BigInteger(resultSet.getString("harga")));
                tindakan.setDelete_at(resultSet.getTimestamp("deleted_at"));
                tindakans.add(tindakan);
            }
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tindakans;
    }
    
    public List<Tindakan> getData(String search){
        List<Tindakan> tindakans = new ArrayList<>();
        
        String sql = "SELECT * FROM tindakan WHERE deleted_at is null and "
                + "nama like ? or "
                + "harga like ?";
        
        try {
            Connection con = db.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, search);
            preparedStatement.setString(2, search);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Tindakan tindakan = new Tindakan();
                tindakan.setId_tindakan(resultSet.getInt("id_tindakan"));
                tindakan.setNama_tindakan(resultSet.getString("nama"));
                tindakan.setHarga_tindakan(new BigInteger(resultSet.getString("harga")));
                tindakan.setDelete_at(resultSet.getTimestamp("deleted_at"));
                tindakans.add(tindakan);
            }
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tindakans;
    }
    
    public boolean destroy(int id){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(timestamp);
        
        String sql = "update tindakan set deleted_at = ? where id_tindakan = ?";
        
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
    