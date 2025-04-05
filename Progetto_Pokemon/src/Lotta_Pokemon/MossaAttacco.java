package Lotta_Pokemon;

import java.util.Random;

/**
 * La classe {@code MossaAttacco} rappresenta una mossa offensiva che infligge
 * danno
 * a un Pokémon avversario. Estende la classe {@code Mossa} e aggiunge il
 * parametro
 * della potenza della mossa per calcolare il danno inflitto.
 */

public class MossaAttacco extends Mossa {

    private int potenzaMossa; // Potenza della mossa, usata nel calcolo del danno

    /**
     * Costruttore della classe {@code MossaAttacco}.
     * 
     * @param nomeMossa       Nome della mossa.
     * @param elementoMossa   Tipo elementale della mossa.
     * @param tipo            Tipo della mossa ("fisico" o "speciale").
     * @param PP              Numero iniziale di utilizzi della mossa.
     * @param PPmax           Numero massimo di utilizzi della mossa.
     * @param precisioneMossa Precisione della mossa (valore percentuale tra 0 e
     *                        100).
     * @param potenzaMossa    Potenza dell'attacco, utilizzata nel calcolo del
     *                        danno.
     */

    public MossaAttacco(String nomeMossa, int elementoMossa, String tipo, int PP, int PPmax, int precisioneMossa,
            int potenzaMossa) {
        super(nomeMossa, elementoMossa, tipo, PP, PPmax, precisioneMossa);
        this.potenzaMossa = potenzaMossa;
    }

    /**
     * Determina se l'attacco va a segno in base alla precisione della mossa e
     * all'elusione del Pokémon avversario.
     * Se la mossa colpisce, viene calcolato il danno inflitto.
     * 
     * @param att Il Pokémon attaccante.
     * @param dif Il Pokémon difensore.
     */

    public void attaccaDanno(Pokemon attaccante, Pokemon difensore, Mossa mossa) {
        int precisioneMossa = mossa.getPrecisioneMossa(); // Valore tra 1 e 100
        double modificatorePrecisione = attaccante.getPrecisione(); // Da 0.33 a 3.00
        double modificatoreElusione = difensore.getElusione(); // Da 0.33 a 3.00

        // Calcolo della probabilità finale
        double hitRate = precisioneMossa * (modificatorePrecisione / modificatoreElusione);

        // Generazione numero casuale tra 0 e 99
        int casuale = new Random().nextInt(100);

        // Se il numero casuale è inferiore a hitRate, la mossa colpisce
        if (casuale < hitRate) {
            setColpito(true);
            Danno(attaccante, difensore);
        } else {
            setColpito(false);
        }
        setPP(getPP() - 1);
    }

    /**
     * Calcola il danno inflitto al Pokémon avversario se l'attacco va a segno.
     * Il calcolo del danno dipende dalla potenza della mossa, dalle statistiche
     * dell'attaccante e del difensore, e dal modificatore di efficacia del tipo.
     * 
     * @param att Il Pokémon attaccante.
     * @param dif Il Pokémon difensore.
     */

    public void Danno(Pokemon att, Pokemon dif) {
        int danno = 0;

        if (getTipo().equals("speciale")) {
            danno = (int) (((potenzaMossa * (double) att.getAttaccoSpeciale()) / dif.getDifesaSpeciale())
                    * modificatore(dif));
        } else if (getTipo().equals("fisico")) {
            danno = (int) (((potenzaMossa * (double) att.getAttacco()) / dif.getDifesa()) * modificatore(dif));
        }

        danno = Math.max(danno, 0); // Assicura che il danno non sia negativo
        dif.setHp(dif.getHp() - danno);
    }

    /**
     * Override del metodo {@code noPP} della classe base.
     * 
     * @return {@code true} se i PP della mossa sono esauriti, altrimenti
     *         {@code false}.
     */

    @Override
    public boolean noPP() {
        return super.noPP();
    }

    /**
     * Override del metodo {@code getEffetto}.
     * Le mosse di attacco non hanno effetti speciali oltre al danno.
     * 
     * @return Stringa vuota, indicando nessun effetto aggiuntivo.
     */

    @Override
    public String getEffetto() {
        return "";
    }
}
