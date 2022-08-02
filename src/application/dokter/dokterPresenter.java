/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.dokter;

import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Azis Naufal
 */
public class dokterPresenter {
    private dokterView view;
    private dokterRepository repo;
    private int index = -1;
    private List<dokter> dokters = null;

    public dokterPresenter(dokterView view) {
        this.view = view;
        this.repo = new dokterRepository();
    }
    
    public void setIndex(int index){
        this.index = index;
    }
    
    public void getData(){
        dokters = repo.getData();
        view.loadTable(dokters);
    }
    
    public dokter getOneData(){
        if(index > -1){
            return dokters.get(index);
        }
        return null;
    }
    
    public void getData(String search){
        dokters = repo.getData("%"+search+"%");
        view.loadTable(dokters);
    }
    
    public void delData(){
        if (view.delConfirm() == JOptionPane.YES_OPTION){
            if (repo.destroy(dokters.get(index).getId_doker())){
                view.showSuccess("Data berhasil dihapus!");
            }
            else {
                view.showError("Data gagal dihapus!");
            }
            view.setDefaultState();
            index = -1;
            getData();
        }
    }
}
