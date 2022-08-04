/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.laporan;

import application.db.MySQLConnection;
import java.io.File;
import java.sql.Connection;
import java.util.Calendar;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author azis
 */
public class Laporan {

    private JasperPrint jasperPrint;

    private Laporan(JasperPrint jasperPrint) {
        this.jasperPrint = jasperPrint;
    }
    
    public void show() {
        JasperViewer.viewReport(jasperPrint,false);
        JasperViewer.setDefaultLookAndFeelDecorated(true);
    }

    public static class LaporanBuilder {
        private Calendar calendarStart;
        private Calendar calendarEnd;
        private JasperPrint jasperPrint;


        public LaporanBuilder setCalendarStart(Calendar calendarStart) {
            this.calendarStart = calendarStart;
            return this;
        }

        public LaporanBuilder setCalendarEnd(Calendar calendarEnd) {
            this.calendarEnd = calendarEnd;
            return this;
        }

        public Laporan build() {
            try
            {
                String sql = "select pemeriksaan.no_nota, d.nama_dokter, p.nama as nama_pasien, pemeriksaan.total, pemeriksaan.tanggal, pemeriksaan.tinggi_badan,\n" +
    "       pemeriksaan.berat_badan, pemeriksaan.sistolik, pemeriksaan.diastolik\n" +
    "from pemeriksaan join pasien p on pemeriksaan.id_pasien = p.id_pasien\n" +
    "join dokter d on d.id_dokter = pemeriksaan.id_dokter\n" +
    "where pemeriksaan.deleted_at is null and "
                        + "tanggal between '"+calendarStart.get(Calendar.YEAR)+"-"+calendarStart.get(Calendar.MONTH)+"-"+calendarStart.get(Calendar.DAY_OF_MONTH)+"' and '"+calendarEnd.get(Calendar.YEAR)+"-"+calendarEnd.get(Calendar.MONTH)+"-"+calendarEnd.get(Calendar.DAY_OF_MONTH)+"'";
                Connection con = MySQLConnection.getInstance().getConnection();
                //ambil file
                File file = new File("lib/cetak_pasien.jrxml");

                JasperDesign jasperDesign = JRXmlLoader.load(file);

                JRDesignQuery jRDesignQuery = new JRDesignQuery();
                jRDesignQuery.setText(sql);

                jasperDesign.setQuery(jRDesignQuery);

                JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);

                jasperPrint = JasperFillManager.fillReport(jasperReport, null, con);

            }

            catch (Exception e)
            {
                e.printStackTrace();
            }

            return new Laporan(jasperPrint);
        }
    }
    
}
