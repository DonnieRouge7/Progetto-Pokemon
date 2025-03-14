package Lotta_Pokemon;
import java.util.Random; 

/**
 * La classe {@code Mossa} rappresenta una mossa utilizzabile dai Pokémon.
 * Ogni mossa può essere di tipo fisico, speciale o di stato e ha parametri come 
 * potenza, precisione, numero massimo di utilizzi (PP) e un modificatore 
 * di efficacia contro determinati tipi di Pokémon.
 */

public class Mossa {

    private String nomeMossa; // Nome della mossa
    private int elementoMossa; // Tipo elementale della mossa (Fuoco, Acqua, Erba, ecc.)
    private String tipo; // Categoria della mossa: "fisico", "speciale" o "stato"
    private int PP; // Numero di utilizzi rimanenti della mossa (non si resetta dopo una lotta)
    private int PPmax; // Numero massimo di utilizzi della mossa (si resetta dopo una lotta)
    private int precisioneMossa; // Probabilità che la mossa vada a segno
    private double modificatore = 1; // Modificatore del danno in base al tipo del bersaglio
    private boolean colpito = false; // Indica se la mossa ha colpito l'avversario

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

    public String getNomeMossa() { return nomeMossa; }
    public void setNomeMossa(String nomeMossa) { this.nomeMossa = nomeMossa; }

    public int getElementoMossa() { return elementoMossa; }
    public void setElementoMossa(int elementoMossa) { this.elementoMossa = elementoMossa; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public int getPP() { return PP; }
    public void setPP(int PP) { this.PP = PP; }

    public int getPPmax() { return PPmax; }
    public void setPPmax(int PPmax) { this.PPmax = PPmax; }

    public int getPrecisioneMossa() { return precisioneMossa; }
    public void setPrecisioneMossa(int precisioneMossa) { this.precisioneMossa = precisioneMossa; }

    public double getModificatore() { return modificatore; }
    public void setModificatore(double modificatore) { this.modificatore = modificatore; }

    public boolean getColpito() { return colpito; }
    public void setColpito(boolean colpito) { this.colpito = colpito; }

    /**
     * Controlla se la mossa ha esaurito i PP.
     * @return {@code true} se i PP sono esauriti, altrimenti {@code false}.
     */
    
    public boolean noPP() {
        if (getPP() <= 0) {
            System.out.println("Hai finito i PP!");
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

        if (modificatore > 1) {
            System.out.println("È superefficace!");
        } else if (modificatore < 1) {
            System.out.println("Non è molto efficace...");
        }
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
