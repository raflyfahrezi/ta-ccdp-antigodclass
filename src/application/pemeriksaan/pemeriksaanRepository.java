/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.pemeriksaan;

import application.base.baseRepository;
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
 * @author VaniaM
 */
public class pemeriksaanRepository extends baseRepository {
    public List<pemeriksaan> getData(){
        List<pemeriksaan> pemeriksaans = new ArrayList<>();
        
        String sql = "select d.nama_dokter, p.nama as nama_pasien, pemeriksaan.total, pemeriksaan.tanggal, pemeriksaan.tinggi_badan,\n" +
"       pemeriksaan.berat_badan, pemeriksaan.sistolik, pemeriksaan.diastolik, ifnull(o.nama_obat, '-') as nama_obat, ifnull(t3.nama, '-') as nama_tindakan, \n" +
"pemeriksaan.no_nota, pemeriksaan.id_dokter, pemeriksaan.id_pasien from pemeriksaan join pasien p on pemeriksaan.id_pasien = p.id_pasien\n" +
"join dokter d on d.id_dokter = pemeriksaan.id_dokter\n" +
"left join tercatat t on pemeriksaan.no_nota = t.no_nota\n" +
"left join tindak t2 on pemeriksaan.no_nota = t2.no_nota\n" +
"left join obat o on t.id_obat = o.id_obat\n" +
"left join tindakan t3 on t2.id_tindakan = t3.id_tindakan\n" +
"where pemeriksaan.deleted_at is null";
        try {
            Connection con = db.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                pemeriksaan pemeriksaan = new pemeriksaan();
                pemeriksaan.setNama_dokter(resultSet.getString("nama_dokter"));
                pemeriksaan.setNama_pasien(resultSet.getString("nama_pasien"));
                pemeriksaan.setTotal(new BigInteger(resultSet.getString("total")));
                pemeriksaan.setTanggal(resultSet.getDate("tanggal"));
                pemeriksaan.setTinggi_badan(resultSet.getFloat("tinggi_badan"));
                pemeriksaan.setBerat_badan(resultSet.getFloat("berat_badan"));
                pemeriksaan.setSistolik(resultSet.getInt("sistolik"));
                pemeriksaan.setDiastolik(resultSet.getInt("diastolik"));
                pemeriksaan.setObat(resultSet.getString("nama_obat"));
                pemeriksaan.setTindak(resultSet.getString("nama_tindakan"));
                pemeriksaan.setNo_nota(resultSet.getInt("no_nota"));
                pemeriksaan.setId_dokter(resultSet.getInt("id_dokter"));
                pemeriksaan.setId_pasien(resultSet.getInt("id_pasien"));
                
                pemeriksaans.add(pemeriksaan);
            }          
            db.close();           
        } catch (Exception e) {
            e.printStackTrace();          
        }
        return pemeriksaans;       
    }
    
    public List<pemeriksaan> getData(String search){
        List<pemeriksaan> pemeriksaans = new ArrayList<>();

        String sql = "select d.nama_dokter, p.nama as nama_pasien, pemeriksaan.total, pemeriksaan.tanggal, pemeriksaan.tinggi_badan,\n" +
"       pemeriksaan.berat_badan, pemeriksaan.sistolik, pemeriksaan.diastolik, ifnull(o.nama_obat, '-') as nama_obat, ifnull(t3.nama, '-') as nama_tindakan, \n" +
"pemeriksaan.no_nota, pemeriksaan.id_dokter, pemeriksaan.id_pasien from pemeriksaan join pasien p on pemeriksaan.id_pasien = p.id_pasien\n" +
"join dokter d on d.id_dokter = pemeriksaan.id_dokter\n" +
"left join tercatat t on pemeriksaan.no_nota = t.no_nota\n" +
"left join tindak t2 on pemeriksaan.no_nota = t2.no_nota\n" +
"left join obat o on t.id_obat = o.id_obat\n" +
"left join tindakan t3 on t2.id_tindakan = t3.id_tindakan\n" +
"where pemeriksaan.deleted_at is null and "
                + "total like ? or "
                + "tanggal like ? or "
                + "tinggi_badan like ? or "
                + "berat_badan like ? or "
                + "sistolik like ? or "
                + "diastolik like ? or "
                + "nama_dokter like ? or "
                + "p.nama like ? or "
                + "t3.nama like ? or "
                + "o.nama_obat like ? ";

        try {
            Connection con = db.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, search);
            preparedStatement.setString(2, search);
            preparedStatement.setString(3, search);
            preparedStatement.setString(4, search);
            preparedStatement.setString(5, search);
            preparedStatement.setString(6, search);
            preparedStatement.setString(7, search);
            preparedStatement.setString(8, search);
            preparedStatement.setString(9, search);
            preparedStatement.setString(10, search);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                pemeriksaan pemeriksaan = new pemeriksaan();
                pemeriksaan.setNama_dokter(resultSet.getString("nama_dokter"));
                pemeriksaan.setNama_pasien(resultSet.getString("nama_pasien"));
                pemeriksaan.setTotal(new BigInteger(resultSet.getString("total")));
                pemeriksaan.setTanggal(resultSet.getDate("tanggal"));
                pemeriksaan.setTinggi_badan(resultSet.getFloat("tinggi_badan"));
                pemeriksaan.setBerat_badan(resultSet.getFloat("berat_badan"));
                pemeriksaan.setSistolik(resultSet.getInt("sistolik"));
                pemeriksaan.setDiastolik(resultSet.getInt("diastolik"));
                pemeriksaan.setObat(resultSet.getString("nama_obat"));
                pemeriksaan.setTindak(resultSet.getString("nama_tindakan"));
                pemeriksaan.setNo_nota(resultSet.getInt("no_nota"));
                pemeriksaan.setId_dokter(resultSet.getInt("id_dokter"));
                pemeriksaan.setId_pasien(resultSet.getInt("id_pasien"));
                
                pemeriksaans.add(pemeriksaan);
            }
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pemeriksaans;
    }

    public boolean destroy(int no_nota){
        List<pemeriksaan> pemeriksaans = new ArrayList<>();
        
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(timestamp);
        
        String sql = "update pemeriksaan set deleted_at = ? where no_nota = ?";
        
        boolean success = false;
        try {
            Connection con = db.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, time);
            preparedStatement.setInt(2, no_nota);
            
            preparedStatement.execute();
            
            success = true;
            
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }
}