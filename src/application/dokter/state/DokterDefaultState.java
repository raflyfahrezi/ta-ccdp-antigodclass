/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.dokter.state;

import application.dokter.DokterInternalFrame;
import java.awt.Cursor;

/**
 *
 * @author azis
 */
public class DokterDefaultState extends DokterState{
    private DokterInternalFrame dokterInternalFrame;
    
    public DokterDefaultState(DokterInternalFrame dokterInternalFrame) {
        super(dokterInternalFrame);
        this.dokterInternalFrame = dokterInternalFrame;
        dokterInternalFrame.setEnabledBtnHapus(false);
        dokterInternalFrame.setEnabledBtnUbah(false);
        dokterInternalFrame.setCursor(Cursor.getDefaultCursor());
    }

    @Override
    public void onRefresh() {
        dokterInternalFrame.setState(new DokterRefreshState(dokterInternalFrame));
    }

    @Override
    public void onDefaultState() {
        dokterInternalFrame.setState(new DokterDefaultState(dokterInternalFrame));
    }

    @Override
    public void onItemTableSelected() {
        dokterInternalFrame.setState(new DokterItemTableSelected(dokterInternalFrame));
    }
    
}
