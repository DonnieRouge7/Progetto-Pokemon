package Lotta_Pokemon;
import java.util.Random; 

public class Mossa{

	private String nomeMossa;
	private int elementoMossa; // fuoco, erba, etc...
	private String tipo; // fisico, speciale, stato
	private int PP; // numero massimo di volte che quella mossa può essere usata, non si resetta dopo una lotta
	int precisioneMossa;
	private double modificatore = 1;
	private boolean colpito = false;
	
	public Mossa(String nomeMossa, int elementoMossa, String tipo, int PP, int precisioneMossa){
		this.nomeMossa = nomeMossa; 
		this.elementoMossa = elementoMossa; 
		this.tipo = tipo; 
		this.PP = PP;
		this.precisioneMossa = precisioneMossa;
	}
	
	// Tabella per l'assegnazione del modificatore del danno a seconda del tipo della mossa e del Pokemon avversario
	
	double[][] efficacia = {
	     //                   	 NOR, FUO, ACQ, ELE, ERB, GHI, LOT, VEL, TER, VOL, PSI, COL, ROC, SPE, DRA, BUI, ACC
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

	
	public String getNomeMossa() {
		return nomeMossa;
	}

	public void setNomeMossa(String nomeMossa) {
		this.nomeMossa = nomeMossa;
	}

	public int getElementoMossa() {
		return elementoMossa;
	}

	public void setElementoMossa(int elementoMossa) {
		this.elementoMossa = elementoMossa;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getPP() {
		return PP;
	}

	public void setPP(int pP) {
		PP = pP;
	}

	public int getPrecisioneMossa() {
		return precisioneMossa;
	}

	public void setPrecisioneMossa(int precisioneMossa) {
		this.precisioneMossa = precisioneMossa;
	}

	public double getModificatore() {
		return modificatore;
	}

	public void setModificatore(double modificatore) {
		this.modificatore = modificatore;
	}
	
	public boolean getColpito() {
		return colpito;
	}

	public void setColpito(boolean colpito) {
		this.colpito = colpito;
	}
	
	// Per verificare quando una mossa ha esaurito i PP
	
	public boolean noPP() {
		boolean b1 = false;
		if(getPP() <= 0) {
			System.out.println("hai finito i PP"); 
			b1 = true;
		}else {
			b1 = false; 
		}
	return b1; 
	}
	
	// Per generari interi o double casuali usati per verificare quando un attacco di un Pokemon va a segno
	
	public int generaInteroCasuale(int a, int b) {
		Random interoCasuale = new Random(); 
		return interoCasuale.nextInt((b - a) + 1) + a;
	}	
	
	public double modificatore(Pokemon difensore) {
		modificatore = 1;
		if(difensore.getTipo2() != -1) { // nel costruttore del Pokemon, se non c'è un secondo tipo, il valore è -1
			modificatore *= efficacia[getElementoMossa()][difensore.getTipo2()]; 
		}
		modificatore *= efficacia[getElementoMossa()][difensore.getTipo1()];
		if(modificatore > 1) {
			System.out.println("è superefficace");
		}else if(modificatore < 1) {
			System.out.println("non è molto efficace...");
		}
	return modificatore;
	}
	
	public String getEffetto() {
        return ""; // Default: nessun effetto
    }

}





