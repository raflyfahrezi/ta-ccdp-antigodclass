/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.obat.form;

import application.obat.Obat;
import java.math.BigInteger;

/**
 *
 * @author azis
 */
public class ObatFormRepositoryProxy extends ObatFormRepository{
    private static ObatFormRepository obatFormRepository = null;
    
    private void initField() {
        if (obatFormRepository == null) {
            obatFormRepository = new ObatFormRepository();
        }
    }
    
    private void doValidation(Obat obat) throws Exception {
        if (obat.getNama().isEmpty()) {
            throw new Exception("Nama obat tidak boleh kosong");
        }
        if (obat.getHarga().compareTo(new BigInteger("0")) == -1) {
            throw new Exception("Harg obat tidak boleh kurang dari 0");
        }
    }

    @Override
    public boolean update(Obat obat) throws Exception{
        initField();
        doValidation(obat);
        return obatFormRepository.update(obat);
    }

    @Override
    public boolean create(Obat obat) throws Exception {
        initField();
        doValidation(obat);
        return obatFormRepository.create(obat);
    }
    
    
}
