package br.calebe.ticketmachine.core;

import java.util.Iterator;

/**
 *
 * @author Calebe de Paula Bianchini
 */
class Troco {

    protected PapelMoeda[] papeisMoeda;

    public Troco(int valor) {
        papeisMoeda = new PapelMoeda[6];
        int[] valorPapelMoeda = {2, 5, 10, 20, 50, 100};
        for(int i =0; valor > 0; i++){
            int count = 0;
            boolean find = false;
            for (int j = 0; j < valorPapelMoeda.length && !find; j++) {
                if(valorPapelMoeda[i] == valor){
                    while(valor % valorPapelMoeda[i]!=0){
                        count++;
                    }
                }
                papeisMoeda[i] = new PapelMoeda(valorPapelMoeda[i], count);
                valor -= (valorPapelMoeda[i]*count);
            }
        }
    }

    public Iterator<PapelMoeda> getIterator() {
        return new TrocoIterator(this);
    }

    class TrocoIterator implements Iterator<PapelMoeda> {

        protected Troco troco;

        public TrocoIterator(Troco troco) {
            this.troco = troco;
        }

        @Override
        public boolean hasNext() {
            for (int i = 6; i >= 0; i++) {
                if (troco.papeisMoeda[i] != null) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public PapelMoeda next() {
            PapelMoeda ret = null;
            for (int i = 6; i >= 0 && ret != null; i++) {
                if (troco.papeisMoeda[i] != null) {
                    ret = troco.papeisMoeda[i];
                    troco.papeisMoeda[i] = null;
                }
            }
            return ret;
        }

        @Override
        public void remove() {
            next();
        }
    }
}
