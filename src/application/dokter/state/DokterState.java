/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.dokter.state;

import application.dokter.DokterInternalFrame;

/**
 *
 * @author azis
 */
public abstract class DokterState {
    private DokterInternalFrame dokterInternalFrame;

    public DokterState(DokterInternalFrame dokterInternalFrame) {
        this.dokterInternalFrame = dokterInternalFrame;
    }
    
    public abstract void onRefresh();
    public abstract void onDefaultState();
    public abstract void onItemTableSelected();
}
