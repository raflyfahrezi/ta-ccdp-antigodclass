/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.tindakan;

import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author GifarF
 */
public class TindakanPresenter {
    private TindakanView view;
    private TindakanRepository repo;
    private int index = -1;
    private List<Tindakan> tindakan = null;

    public TindakanPresenter(TindakanView view) {
        this.view = view;
        this.repo = new TindakanRepository();
    }
    
    public void setIndex(int index){
        this.index = index;
    }
    
    public void getData(){
        tindakan = repo.getData();
        view.loadTable(tindakan);
    }
    
    public Tindakan getOneData(){
        if(index > -1){
            return tindakan.get(index);
        }
        return null;
    }
    
    public void getData(String search){
        tindakan = repo.getData("%"+search+"%");
        view.loadTable(tindakan);
    }
    
    public void delData(){
        if (view.delConfirm() == JOptionPane.YES_OPTION){
            if (repo.destroy(tindakan.get(index).getId_tindakan())){
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
