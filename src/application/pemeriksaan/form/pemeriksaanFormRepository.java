/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.pemeriksaan.form;

import application.base.baseRepository;
import application.pemeriksaan.pemeriksaan;
import application.pemeriksaan.form.tercatat.tercatat;
import application.pemeriksaan.form.tindak.tindak;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Azis Naufal
 */
public class pemeriksaanFormRepository extends baseRepository{
    
    public LinkedList<tindak> getTindak(int no_nota){
        String sql = "select tindak.*, t.harga, t.nama from tindak join tindakan t on "
                + "tindak.id_tindakan = t.id_tindakan where no_nota = ?";
        LinkedList<tindak> tindaks = new LinkedList<>();
        try {
            Connection con = db.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, no_nota);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                tindak tindak = new tindak();
                tindak.setNo_nota(no_nota);
                tindak.setNama_tindakan(resultSet.getString("nama"));
                tindak.setHarga(new BigInteger(resultSet.getString("harga")));
                tindak.setId_tindakan(resultSet.getInt("id_tindakan"));
                
                tindaks.add(tindak);
            }          
            db.close();           
        } catch (Exception e) {
            e.printStackTrace();          
        }
        return tindaks;
    }
    
    public LinkedList<tercatat> getTercatat(int no_nota){
        String sql = "select tercatat.*, o.harga, o.nama_obat from tercatat join obat o on "
                + "tercatat.id_obat = o.id_obat where no_nota = ?";
        LinkedList<tercatat> tercatats = new LinkedList<>();
        try {
            Connection con = db.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, no_nota);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                tercatat tercatat = new tercatat();
                tercatat.setHarga(new BigInteger(resultSet.getString("harga")));
                tercatat.setId_obat(resultSet.getInt("id_obat"));
                tercatat.setNama_obat(resultSet.getString("nama_obat"));
                tercatat.setNo_nota(no_nota);
                tercatat.setQty(resultSet.getInt("qty"));
                tercatat.setSubtotal(new BigInteger(resultSet.getString("subtotal")));
                
                tercatats.add(tercatat);
            }          
            db.close();           
        } catch (Exception e) {
            e.printStackTrace();          
        }
        return tercatats;
    }
    
    public boolean update(pemeriksaan pemeriksaan){
        String sql = "UPDATE pemeriksaan t SET "
                + "t.id_pasien = ?, t.id_dokter = ?, "
                + "t.total = ?, t.tanggal = ?, "
                + "t.tinggi_badan = ?, t.berat_badan = ?, "
                + "t.sistolik = ?, t.diastolik = ? "
                + "WHERE t.no_nota = ?";
        
        boolean success = false;
        
        try {
            Connection con = db.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, pemeriksaan.getId_pasien());
            preparedStatement.setInt(2, pemeriksaan.getId_dokter());
            preparedStatement.setBigDecimal(3, new BigDecimal(pemeriksaan.getTotal()));
            preparedStatement.setDate(4, pemeriksaan.getTanggal());
            preparedStatement.setFloat(5, pemeriksaan.getTinggi_badan());
            preparedStatement.setFloat(6, pemeriksaan.getBerat_badan());
            preparedStatement.setInt(7, pemeriksaan.getSistolik());
            preparedStatement.setInt(8, pemeriksaan.getDiastolik());
            preparedStatement.setInt(9, pemeriksaan.getNo_nota());
            
            preparedStatement.execute();
            
            db.close();
            success = true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return success;
    }
    
    public int create(pemeriksaan pemeriksaan){
        String sql = "INSERT INTO pemeriksaan (id_pasien, id_dokter, total, tanggal, tinggi_badan, berat_badan, sistolik, diastolik) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        int no_nota = -1;
        try {
            Connection con = db.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, pemeriksaan.getId_pasien());
            preparedStatement.setInt(2, pemeriksaan.getId_dokter());
            preparedStatement.setBigDecimal(3, new BigDecimal(pemeriksaan.getTotal()));
            preparedStatement.setDate(4, pemeriksaan.getTanggal());
            preparedStatement.setFloat(5, pemeriksaan.getTinggi_badan());
            preparedStatement.setFloat(6, pemeriksaan.getBerat_badan());
            preparedStatement.setInt(7, pemeriksaan.getSistolik());
            preparedStatement.setInt(8, pemeriksaan.getDiastolik());
            
            preparedStatement.executeUpdate();
            
            ResultSet tableKeys = preparedStatement.getGeneratedKeys();
            tableKeys.next();
            no_nota = tableKeys.getInt(1);
                        
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return no_nota;
    }
    
    public void deleteTercatat(int no_nota){
        String sql = "Delete from tercatat where no_nota = ?";
        
        try {
            Connection con = db.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, no_nota);
            
            preparedStatement.executeUpdate();
                        
            db.close();
        } catch (Exception e) {
        }
    }
    
    public void deletePemeriksaan(int no_nota){
        String sql = "Delete from pemeriksaan where no_nota = ?";
        
        try {
            Connection con = db.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, no_nota);
            
            preparedStatement.executeUpdate();
                        
            db.close();
        } catch (Exception e) {
        }
    }
    
    public void deleteTindak(int no_nota){
        String sql = "Delete from tindak where no_nota = ?";
        
        try {
            Connection con = db.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, no_nota);
            
            preparedStatement.executeUpdate();
                        
            db.close();
        } catch (Exception e) {
        }
    }
    
    public boolean createTindak(int nota, LinkedList<tindak> tindaks){
        if (!tindaks.isEmpty()){
            String sql = "INSERT INTO tindak (no_nota, id_tindakan) VALUES ";
            Iterator<tindak> iterator = tindaks.iterator();
            while (iterator.hasNext()) {
                tindak tindak = iterator.next();
                sql = sql + "("+ nota +", "+tindak.getId_tindakan()+")";
                if (iterator.hasNext()){
                    sql += ",";
                }
            }
           
            boolean success = false;
            try {
                Connection con = db.getConnection();
                PreparedStatement preparedStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                preparedStatement.executeUpdate();

                success = true;

                db.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return success;
        }
        else {
            return true;
        }
    }
    
    public boolean createTercatat(int nota, LinkedList<tercatat> tercatats){
        if (!tercatats.isEmpty()){
            String sql = "INSERT INTO tercatat (no_nota, id_obat, subtotal, qty) VALUES ";
            Iterator<tercatat> iterator = tercatats.iterator();
            while (iterator.hasNext()) {
                tercatat tercatat = iterator.next();
                sql = sql + "("+ nota +", "+tercatat.getId_obat()+", " + tercatat.getSubtotal().toString() + ", " + tercatat.getQty()+")";
                if (iterator.hasNext()){
                    sql += ",";
                }
            }

            boolean success = false;
            try {
                Connection con = db.getConnection();
                PreparedStatement preparedStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                preparedStatement.executeUpdate();

                success = true;

                db.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return success;
        }
        else {
            return true;
        }
    }
}
