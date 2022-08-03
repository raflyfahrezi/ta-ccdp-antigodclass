/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.pasien;

import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class PasienPresenter {
    private PasienView view;
    private PasienRepository repos;
    private int index = -1;
    private List<Pasien> pasiens = null;
    
    public PasienPresenter(PasienView view) {
        this.view = view;
        this.repos = new PasienRepository();
    }
    
    public void setIndex(int index) {
        this.index = index;
    }
    
    public void getData() {
        pasiens = repos.getData();
        view.loadTable(pasiens);
    }
    
    public Pasien getOneData() {
        if (index > -1) {
            return pasiens.get(index);
        }
        
        return null;
    }
    
    public void getData(String searchQuery) {
        pasiens = repos.getData("%" + searchQuery + "%");
        view.loadTable(pasiens);
    }
    
    public void deleteData() {
//        if (view.deleteConfirm() == JOptionPane.YES_OPTION) {
//            view.showSuccess("Data berhasil dihapus.");
//        } else {
//            view.showError("Data gagal dihapus.");
//        }
//        
//        view.setDefaultState();
//        index = -1;
//        getData();
        if (view.deleteConfirm()== JOptionPane.YES_OPTION){
            if (repos.destroy(pasiens.get(index).getId_pasien())){
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
