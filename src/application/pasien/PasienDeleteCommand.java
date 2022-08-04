/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.pasien;

import application.db.DeleteCommand;

/**
 *
 * @author azis
 */
public class PasienDeleteCommand implements DeleteCommand{
    private final PasienRepository pasienRepository;
    
    public PasienDeleteCommand(PasienRepository pasienRepository) {
        this.pasienRepository = pasienRepository;
    }

    @Override
    public boolean execute(int id) {
        return pasienRepository.destroy(id);
    }
    
}
