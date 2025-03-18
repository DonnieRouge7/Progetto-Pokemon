package Lotta_Pokemon;
import java.util.Random; 

/**
 * La classe {@code Mossa} rappresenta una mossa utilizzabile dai Pokémon.
 * Ogni mossa può essere di tipo fisico, speciale o di stato e ha parametri come 
 * potenza, precisione, numero massimo di utilizzi (PP) e un modificatore 
 * di efficacia contro determinati tipi di Pokémon.
 */

public class Mossa {

    /** Nome della mossa. */
    private String nomeMossa;

    /** Tipo elementale della mossa (Fuoco, Acqua, Erba, ecc.). */
    private int elementoMossa;

    /** Categoria della mossa: "fisico", "speciale" o "stato". */
    private String tipo;

    /** Numero di utilizzi rimanenti della mossa (non si resetta dopo una lotta). */
    private int PP;

    /**  Numero massimo di utilizzi della mossa (si resetta dopo una lotta). */
    private int PPmax;

    /** Probabilità che la mossa vada a segno (valore percentuale tra 0 e 100). */
    private int precisioneMossa;
 
    /** Modificatore del danno in base al tipo del bersaglio. */
    private double modificatore = 1;
 
    /** Indica se la mossa ha colpito l'avversario. */
    private boolean colpito = false;

    /**
     * Costruttore della classe {@code Mossa}.
     * 
     * @param nomeMossa Nome della mossa.
     * @param elementoMossa Tipo elementale della mossa.
     * @param tipo Tipo della mossa ("fisico", "speciale" o "stato").
     * @param PP Numero iniziale di utilizzi della mossa.
     * @param PPmax Numero massimo di utilizzi della mossa.
     * @param precisioneMossa Precisione della mossa (valore percentuale tra 0 e 100).
     */
    public Mossa(String nomeMossa, int elementoMossa, String tipo, int PP, int PPmax, int precisioneMossa) {
        this.nomeMossa = nomeMossa; 
        this.elementoMossa = elementoMossa; 
        this.tipo = tipo; 
        this.PP = PP;
        this.PPmax = PPmax;
        this.precisioneMossa = precisioneMossa;
    }

    /**
     * Matrice di efficacia che determina il moltiplicatore di danno 
     * in base al tipo della mossa e al tipo del Pokémon avversario.
     */
    double[][] efficacia = {
        //                    NOR, FUO, ACQ, ELE, ERB, GHI, LOT, VEL, TER, VOL, PSI, COL, ROC, SPE, DRA, BUI, ACC
        /* Normale  */      {  1,  1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,  0.5,  0,   1,   1,  0.5 },
        /* Fuoco    */      {  1, 0.5, 0.5,  1,   2,   2,   1,   1,   1,   1,   1,   2,  0.5,  1,  0.5,  1,   2  },
        /* Acqua    */      {  1,  2,  0.5,  1,  0.5,  1,   1,   1,   2,   1,   1,   1,   2,   1,  0.5,  1,   1  },
        /* Elettro  */      {  1,  1,   2,  0.5, 0.5,  1,   1,   1,   0,   2,   1,   1,   1,   1,  0.5,  1,   1  },
        /* Erba     */      {  1, 0.5,  2,   1,  0.5,  1,   1,  0.5,  2,  0.5,  1,  0.5,  2,   1,  0.5,  1,  0.5 },
        /* Ghiaccio */      {  1, 0.5, 0.5,  1,   2,  0.5,  2,   1,   2,   2,   1,   1,   1,   1,   2,   1,  0.5 },
        /* Lotta    */      {  2,  1,   1,   1,   1,   1,   1,  0.5,  1,  0.5, 0.5, 0.5,  2,   0,   1,  0.5,  2  },
        /* Veleno   */      {  1,  1,   1,   1,   2,   1,   1,  0.5, 0.5,  1,   1,  0.5, 0.5, 0.5,  1,   1,   0  },
        /* Terra    */      {  1,  2,   1,   2,  0.5,  1,   1,   2,   1,   0,   1,   1,   2,   1,   1,   1,   2  },
        /* Volante  */      {  1,  1,   1,  0.5,  2,   1,   2,   1,   1,   1,   1,   2,  0.5,  1,   1,   1,  0.5 },
        /* Psico    */      {  1,  1,   1,   1,   1,   1,   2,   2,   1,   1,  0.5,  1,   1,   1,   1,   0,  0.5 },
        /* Coleottero */    {  1, 0.5,  1,   1,   2,   1,  0.5, 0.5,  1,  0.5,  2,   1,   1,  0.5,  1,  0.5, 0.5 },
        /* Roccia   */      {  1,  2,   1,   1,   1,   2,  0.5,  1,  0.5,  2,   1,   2,   1,   1,   1,   1,  0.5 },
        /* Spettro  */      {  0,  1,   1,   1,   1,   1,   1,   1,   1,   1,   2,   1,   1,   2,   1,  0.5,  1  },
        /* Drago    */      {  1,  1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   1,   2,   1,  0.5 },
        /* Buio     */      {  1,  1,   1,   1,   1,   1,   2,   1,   1,   1,   2,   1,   1,   2,   1,  0.5, 0.5 },
        /* Acciaio  */      {  1, 0.5,  1,  0.5,  1,   2,   1,   1,   1,   1,   1,   1,   2,   1,   1,   1,  0.5 }
    };

    // ------------------ GETTER E SETTER ------------------

    /**
     * Restituisce il nome della mossa.
     * @return Nome della mossa.
     */
    public String getNomeMossa() { return nomeMossa; }

    /**
     * Imposta il nome della mossa.
     * @param nomeMossa Nome della mossa.
     */
    public void setNomeMossa(String nomeMossa) { this.nomeMossa = nomeMossa; }

    /**
     * Restituisce il tipo elementale della mossa.
     * @return Tipo elementale della mossa.
     */
    public int getElementoMossa() { return elementoMossa; }

    /**
     * Imposta il tipo elementale della mossa.
     * @param elementoMossa Tipo elementale della mossa.
     */
    public void setElementoMossa(int elementoMossa) { this.elementoMossa = elementoMossa; }

    /**
     * Restituisce la categoria della mossa.
     * @return Categoria della mossa.
     */
    public String getTipo() { return tipo; }

    /**
     * Imposta la categoria della mossa.
     * @param tipo Categoria della mossa.
     */
    public void setTipo(String tipo) { this.tipo = tipo; }

    /**
     * Restituisce il numero di utilizzi rimanenti della mossa.
     * @return Numero di utilizzi rimanenti della mossa.
     */
    public int getPP() { return PP; }

    /**
     * Imposta il numero di utilizzi rimanenti della mossa.
     * @param PP Numero di utilizzi rimanenti della mossa.
     */
    public void setPP(int PP) { this.PP = PP; }

    /**
     * Restituisce il numero massimo di utilizzi della mossa.
     * @return Numero massimo di utilizzi della mossa.
     */
    public int getPPmax() { return PPmax; }

    /**
     * Imposta il numero massimo di utilizzi della mossa.
     * @param PPmax Numero massimo di utilizzi della mossa.
     */
    public void setPPmax(int PPmax) { this.PPmax = PPmax; }

    /**
     * Restituisce la precisione della mossa.
     * @return Precisione della mossa.
     */
    public int getPrecisioneMossa() { return precisioneMossa; }

    /**
     * Imposta la precisione della mossa.
     * @param precisioneMossa Precisione della mossa.
     */
    public void setPrecisioneMossa(int precisioneMossa) { this.precisioneMossa = precisioneMossa; }

    /**
     * Restituisce il modificatore del danno.
     * @return Modificatore del danno.
     */
    public double getModificatore() { return modificatore; }

    /**
     * Imposta il modificatore del danno.
     * @param modificatore Modificatore del danno.
     */
    public void setModificatore(double modificatore) { this.modificatore = modificatore; }

    /**
     * Restituisce se la mossa ha colpito l'avversario. 
     * @return {@code true} se la mossa ha colpito l'avversario, altrimenti {@code false}.
     */
    public boolean getColpito() { return colpito; }

    /**
     * Imposta se la mossa ha colpito l'avversario.
     * @param colpito {@code true} se la mossa ha colpito l'avversario, altrimenti {@code false}.
     */
    public void setColpito(boolean colpito) { this.colpito = colpito; }

    /**
     * Controlla se la mossa ha esaurito i PP.
     * @return {@code true} se i PP sono esauriti, altrimenti {@code false}.
     */
    public boolean noPP() {
        if (getPP() <= 0) {
            setPP(0);
        	return true;
        }
        return false;
    }

    /**
     * Genera un numero intero casuale tra {@code a} e {@code b}.
     * Usato per verificare se una mossa va a segno.
     * 
     * @param a Estremo inferiore dell'intervallo.
     * @param b Estremo superiore dell'intervallo.
     * @return Numero casuale tra {@code a} e {@code b}.
     */
    public int generaInteroCasuale(int a, int b) {
        Random interoCasuale = new Random();
        return interoCasuale.nextInt((b - a) + 1) + a;
    }   

    /**
     * Calcola il modificatore di danno basato sul tipo del Pokémon avversario.
     * Se il Pokémon ha un secondo tipo, il modificatore viene moltiplicato per entrambi i valori.
     * 
     * @param difensore Il Pokémon che subisce l'attacco.
     * @return Il valore del modificatore di danno.
     */
    public double modificatore(Pokemon difensore) {
        modificatore = 1;
        if (difensore.getTipo2() != -1) { // Se il Pokémon ha un secondo tipo
            modificatore *= efficacia[getElementoMossa()][difensore.getTipo2()];
        }
        modificatore *= efficacia[getElementoMossa()][difensore.getTipo1()];
        return modificatore;
    }

    /**
     * Restituisce l'effetto della mossa.
     * Per impostazione predefinita, non ha effetti speciali.
     * 
     * @return Stringa descrittiva dell'effetto della mossa.
     */
    public String getEffetto() {
        return ""; // Default: nessun effetto
    }
}
