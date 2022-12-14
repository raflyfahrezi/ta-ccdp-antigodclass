/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package application.tindakan.form;

import application.base.BaseDataTableFrame;
import application.menu.MenuFrame;
import application.tindakan.Tindakan;
import application.util.Callback;

/**
 *
 * @author GifarF
 */
public class TindakanFormInternalFrame extends BaseDataTableFrame implements TindakanFormView {
    private TindakanFormPresenter presenter = null;
    private Callback callback = null;
    
    /**
     * Creates new form PasienFormInternalFrame
     */
    public TindakanFormInternalFrame(Tindakan tindakan) {
        presenter = new TindakanFormPresenter(this);
        
        initComponents();
        
        if (tindakan != null) {
            presenter.setTindakan(tindakan);
            setTitle("Ubah Data Tindakan");
        }
    }
    
    @Override
    public void showData(Tindakan tindakan) {
        txtNama.setText(tindakan.getNama_tindakan());
        txtHarga.setText(tindakan.getHarga_tindakan().toString());
    }
    
    public void setCallback(Callback callback){
        this.callback = callback;
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
        lblHarga = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        lblCurrency = new javax.swing.JLabel();
        txtHarga = new javax.swing.JFormattedTextField();

        btnKembali.setMnemonic('t');
        btnKembali.setText("Kembali");
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });

        lblNama.setText("Nama");

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

        lblCurrency.setText("Rp");

        txtHarga.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                        .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblHarga)
                            .addComponent(lblNama))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(txtNama))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblCurrency)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtHarga)))))
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
                    .addComponent(lblHarga)
                    .addComponent(lblCurrency)
                    .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
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
        presenter.setNama(txtNama.getText());
    }//GEN-LAST:event_txtNamaKeyReleased
    
    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        if (txtNama.getText().isEmpty()){
            showError("Nama tidak boleh kosong!");
        }
        else if (txtHarga.getText().isEmpty()) {
            showError("Harga tidak boleh kosong");
        }
        else {
            setWaitCursor();
            presenter.save();
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void txtHargaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHargaKeyReleased
        // TODO add your handling code here:
        presenter.setHargaTindakan(txtHarga.getText());
    }//GEN-LAST:event_txtHargaKeyReleased
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JLabel lblCurrency;
    private javax.swing.JLabel lblHarga;
    private javax.swing.JLabel lblNama;
    private javax.swing.JFormattedTextField txtHarga;
    private javax.swing.JTextField txtNama;
    // End of variables declaration//GEN-END:variables
    
    @Override
    protected String setWindowTitle() {
        return "Tambah Data Tindakan";
    }
    
    @Override
    public void back() {
        setWaitCursor();
        
        MenuFrame menuFramee = MenuFrame.getInstance();
        menuFramee.removeOneDesktopPane(TindakanFormInternalFrame.this);
        if (callback != null){
            callback.onFinish();
        }
        setDefaultCursor();
        dispose();
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
