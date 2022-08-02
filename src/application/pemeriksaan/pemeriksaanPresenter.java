/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.pemeriksaan;

import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author VaniaM
 */
public class pemeriksaanPresenter {
    private pemeriksaanView view;
    private pemeriksaanRepository repo;
    private int index = -1;
    private List<pemeriksaan> pemeriksaans = null;
    
    public pemeriksaanPresenter(pemeriksaanView view) {
        this.view = view;
        this.repo = new pemeriksaanRepository();
    }
    
    public void setIndex(int index){
        this.index = index;
    }
    
    public void getData() {
        pemeriksaans = repo.getData();
        view.loadTable(pemeriksaans);
    }
    
    public pemeriksaan getOneData() {
        if (index > -1) {
            return pemeriksaans.get(index);
        }
        
        return null;
    }
    
    public void getData(String search){
        pemeriksaans = repo.getData("%"+search+"%");
        view.loadTable(pemeriksaans);
    }
    
    public void delData(){
        if (view.delConfirm() == JOptionPane.YES_OPTION){
            if (repo.destroy(pemeriksaans.get(index).getNo_nota())){
                view.showSuccess("Data berhasil dihapus!");
            }
            else {
                view.showError("Data gagal dihapus!");
            }
            view.setDefaultState();
            index = -1;
            view.loadData();
        }
    }

}
