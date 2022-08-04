/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.dokter.iterator;

import application.dokter.Dokter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author azis
 */
public class DokterCollectionImpl  implements DokterCollection{
    
    public DokterCollectionImpl() {
        
    }

    @Override
    public DokterIterator getListDokter(List<Dokter> dokters) {
        return new DokterIteratorImpl(dokters);
    }
    
    private static class DokterIteratorImpl implements DokterIterator {
        private final List<Dokter> dokters;
        private int position;

        public DokterIteratorImpl(List<Dokter> dokters) {
            this.dokters = dokters;
        }

        @Override
        public boolean hasNext() {
            try {
                if (position < dokters.size()) {
                    Dokter dokter = dokters.get(position);
                    return dokter != null;
                }
                return false;
            }
            catch (Exception e) {
                return false;
            }
        }

        @Override
        public Dokter next() {
            Dokter dokter = dokters.get(position);
            position++;
            return dokter;
        }
    }
    
}
