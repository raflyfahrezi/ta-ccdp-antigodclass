/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.obat;

import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class obatPresenter {
    private obatView view;
    private obatRepository repos;
    private int index = -1;
    private List<obat> obats = null;
    
    public obatPresenter(obatView view) {
        this.view = view;
        this.repos = new obatRepository();
    }
    
    public void setIndex(int index) {
        this.index = index;
    }
    
    public void getData() {
        obats = repos.getData();
        view.loadTable(obats);
    }
    
    public obat getOneData(){
        if(index > -1){
            return obats.get(index);
        }
        return null;
    }
    
    public void getDataFromSearch(String searchQuery) {
        obats = repos.getData("%" + searchQuery + "%");
        view.loadTable(obats);
    }
    
    public void deleteData() {
        if (view.deleteConfirm() == JOptionPane.YES_OPTION) {
            if (repos.destroy(obats.get(index).getId_obat())) {
                view.showSuccess("Data berhasil dihapus");
            } else {
                view.showError("Data gagal disimpan");
            }
            
            view.setDefaultState();
            index = -1;
            getData();
        }
    }
}
