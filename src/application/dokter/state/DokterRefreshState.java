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
public class DokterRefreshState extends DokterState{
    private DokterInternalFrame dokterInternalFrame;
    
    public DokterRefreshState(DokterInternalFrame dokterInternalFrame) {
        super(dokterInternalFrame);
        this.dokterInternalFrame = dokterInternalFrame;
        dokterInternalFrame.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
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
