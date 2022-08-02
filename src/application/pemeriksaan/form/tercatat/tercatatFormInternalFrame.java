/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.pemeriksaan.form.tercatat;

import application.base.baseDataTableFrame;
import javax.swing.DefaultComboBoxModel;
import application.util.callbackReturn;

/**
 *
 * @author Azis Naufal
 */
public class tercatatFormInternalFrame extends baseDataTableFrame implements tercatatFormView{
    private static tercatatFormInternalFrame instance = null;
    private tercatatFormPresenter presenter = null;
    private callbackReturn callback = null;
    /**
     * Creates new form TercatatFormInternalFrame
     */
    private tercatatFormInternalFrame(tercatat tercatat) {
        this.presenter = new tercatatFormPresenter(this);
        initComponents();
        loadData();
        if (tercatat != null)
            presenter.setTercatat(tercatat);
    }
    
    public static tercatatFormInternalFrame getInstance(tercatat tercatat){
        if (instance == null){
            instance = new tercatatFormInternalFrame(tercatat);
        }
        return instance;
    }
    
    public void setCallback(callbackReturn callback){
        this.callback = callback;
    }
    
    private void loadData(){
        setWaitCursor();
        presenter.loadData();
        setDefaultCursor();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNamaObat = new javax.swing.JLabel();
        lblJumlah = new javax.swing.JLabel();
        lblHarga = new javax.swing.JLabel();
        lblSubtotal = new javax.swing.JLabel();
        cbxObat = new javax.swing.JComboBox<>();
        txtHarga = new javax.swing.JTextField();
        txtSubtotal = new javax.swing.JTextField();
        btnKembali = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        spJumlah = new javax.swing.JSpinner();

        lblNamaObat.setText("Nama Obat");

        lblJumlah.setText("Jumlah");

        lblHarga.setText("Harga");

        lblSubtotal.setText("Subtotal");

        cbxObat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxObatActionPerformed(evt);
            }
        });

        txtHarga.setEditable(false);

        txtSubtotal.setEditable(false);

        btnKembali.setText("Kembali");
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        spJumlah.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        spJumlah.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spJumlahStateChanged(evt);
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
                        .addComponent(btnKembali)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 147, Short.MAX_VALUE)
                        .addComponent(btnSimpan))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNamaObat)
                            .addComponent(lblJumlah)
                            .addComponent(lblHarga)
                            .addComponent(lblSubtotal))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(spJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtSubtotal)
                            .addComponent(txtHarga)
                            .addComponent(cbxObat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNamaObat)
                    .addComponent(cbxObat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblJumlah)
                    .addComponent(spJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHarga)
                    .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSubtotal)
                    .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnKembali)
                    .addComponent(btnSimpan))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxObatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxObatActionPerformed
        // TODO add your handling code here:
        presenter.setId_obat(cbxObat.getSelectedIndex());
        
    }//GEN-LAST:event_cbxObatActionPerformed

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        // TODO add your handling code here:
        back();
    }//GEN-LAST:event_btnKembaliActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        presenter.validate();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void spJumlahStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spJumlahStateChanged
        // TODO add your handling code here:
        presenter.setQty(Integer.parseInt(spJumlah.getValue().toString()));
    }//GEN-LAST:event_spJumlahStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JComboBox<String> cbxObat;
    private javax.swing.JLabel lblHarga;
    private javax.swing.JLabel lblJumlah;
    private javax.swing.JLabel lblNamaObat;
    private javax.swing.JLabel lblSubtotal;
    private javax.swing.JSpinner spJumlah;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtSubtotal;
    // End of variables declaration//GEN-END:variables

    @Override
    public void loadObat(String[] tindakans) {
        cbxObat.setModel(new DefaultComboBoxModel<>(tindakans));
    }

    @Override
    protected String setWindowTitle() {
        return "Obat";
    }

    @Override
    public void showSubtotal(String subtotal) {
        txtSubtotal.setText(subtotal);
    }

    @Override
    public void showHarga(String harga) {
        txtHarga.setText(harga);
    }

    @Override
    public void showData(tercatat tercatat) {
        cbxObat.setSelectedItem(tercatat.getNama_obat());
        spJumlah.setValue(tercatat.getQty());
        txtHarga.setText("Rp " + tercatat.getHarga());
        txtSubtotal.setText("Rp " + tercatat.getSubtotal());
    }

    @Override
    public void back() {
        callback.onFinish(presenter.getTercatat());
        instance = null;
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
