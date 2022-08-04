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
public class DokterPresenter {
    private DokterView view;
    private DokterRepository repo;
    private int index = -1;
    private List<Dokter> dokters = null;

    public DokterPresenter(DokterView view) {
        this.view = view;
        this.repo = new DokterRepository();
    }
    
    public void setIndex(int index){
        this.index = index;
    }
    
    public void getData(){
        dokters = repo.getData();
        view.loadTable(dokters);
    }
    
    public Dokter getOneData(){
        if(index > -1){
            Dokter dok1 = dokters.get(index);
            Dokter dok2 = dok1.clone();
            
            boolean same = dok1 == dok2;
            System.out.println("apakah sama dok1 dan dok2 ? " + same );
            return dokters.get(index).clone();
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
            index = -1;
            getData();
        }
    }
}
