/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.obat.form;

import application.base.BaseDataTableFrame;
import application.menu.MenuFrame;
import application.obat.Obat;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;
import application.util.Callback;

/**
 *
 * @author Lenovo
 */
public class ObatFormInternalFrame extends BaseDataTableFrame implements ObatFormView{

    private static ObatFormInternalFrame instance = null;
    private ObatFormPresenter presenter = null;
    private Callback callback = null;
    /**
     * Creates new form DokterFormInternalFrame
     */
    public ObatFormInternalFrame(Obat obat) {
        presenter = new ObatFormPresenter(this);
        
        initComponents();
        
        setDateChooserOnChange();
    
        if (obat != null) {
            presenter.setObat(obat);
            setTitle("Ubah Data Obat");
        }
    }
    
    public static ObatFormInternalFrame getInstance(Obat obat) {
        if (instance == null) {
            instance = new ObatFormInternalFrame(obat);
        }
        
        return instance;
    }
    
    public void setCallback(Callback callback){
        this.callback = callback;
    }
    
    @Override
    public void showData(Obat obat, Date kadaluarsa) {
        
        txtNama.setText(obat.getNama());
        txtHarga.setText(String.valueOf(obat.getHarga()));
        dchKadaluarsa.setDate(kadaluarsa);
    }
    
    private void setDateChooserOnChange(){
        dchKadaluarsa.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().equals("date")){
                    Obat obat = presenter.getObat();
                    Date date = (Date) evt.getNewValue();
                    obat.setTanggal_kadaluarsa(new java.sql.Date(date.getTime()));
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnKembali = new javax.swing.JButton();
        lblNama = new javax.swing.JLabel();
        lblKadaluarsa = new javax.swing.JLabel();
        lblHarga = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        txtHarga = new javax.swing.JTextField();
        dchKadaluarsa = new com.toedter.calendar.JDateChooser();

        btnKembali.setMnemonic('t');
        btnKembali.setText("Kembali");
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });

        lblNama.setText("Nama");

        lblKadaluarsa.setText("Kadaluarsa");

        lblHarga.setText("Harga");

        txtNama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNamaKeyReleased(evt);
            }
        });

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        txtHarga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtHargaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 228, Short.MAX_VALUE)
                        .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblHarga)
                            .addComponent(lblNama)
                            .addComponent(lblKadaluarsa))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHarga, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNama)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(dchKadaluarsa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNama)
                    .addComponent(txtNama))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHarga))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblKadaluarsa)
                    .addComponent(dchKadaluarsa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnKembali)
                    .addComponent(btnSimpan))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        // TODO add your handling code here:
        back();
    }//GEN-LAST:event_btnKembaliActionPerformed

    private void txtNamaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNamaKeyReleased
        // TODO add your handling code here:
        presenter.setNamaObat(txtNama.getText());
    }//GEN-LAST:event_txtNamaKeyReleased

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        setWaitCursor();
        presenter.save();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void txtHargaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHargaKeyReleased
        try {
            presenter.setHargaObat(txtHarga.getText());
        } catch (Exception e) {
            showError("Inputan tidak valid");
        }
    }//GEN-LAST:event_txtHargaKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnSimpan;
    private com.toedter.calendar.JDateChooser dchKadaluarsa;
    private javax.swing.JLabel lblHarga;
    private javax.swing.JLabel lblKadaluarsa;
    private javax.swing.JLabel lblNama;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtNama;
    // End of variables declaration//GEN-END:variables

    @Override
    protected String setWindowTitle() {
        return "Tambah Data Obat";
    }

    @Override
    public void back() {
        setWaitCursor();
        
        MenuFrame menuFramee = MenuFrame.getInstance();
        menuFramee.removeOneDesktopPane(ObatFormInternalFrame.this);
        if (callback != null)
            callback.onFinish();
        
        setDefaultCursor();
    }

    @Override
    public void showSuccess(String s) {
        this.showMessageSuccess(s);
        setDefaultCursor();
    }

    @Override
    public void showError(String s) {
        this.showMessageError(s);
        setDefaultCursor();
    }
}
