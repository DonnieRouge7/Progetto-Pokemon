package Lotta_Pokemon;

public class MossaAttacco extends Mossa{
	
	private int potenzaMossa;
	
	public MossaAttacco(String nomeMossa, int elementoMossa, String tipo, int PP, int precisioneMossa, int potenzaMossa) {
		super(nomeMossa, elementoMossa, tipo, PP, precisioneMossa);
		this.potenzaMossa = potenzaMossa;
	}

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

	@Override
	public boolean noPP() {
		return super.noPP();
	}

	public void Danno(Pokemon attaccante, Pokemon difensore) { 
		int danno = 0;
		if(getTipo() == "speciale") {
			danno = (int) (((potenzaMossa * attaccante.getAttaccoSpecialePokemon())/difensore.getDifesaSpecialePokemon())*modificatore(difensore));
		}else if(getTipo() == "fisico"){
			danno = (int) (((potenzaMossa * attaccante.getAttaccoPokemon())/difensore.getDifesaPokemon())* modificatore(difensore));
		}
		difensore.subisciDanno(difensore, danno);
		setPP(getPP() - 1);
	}
	
	public double modificatore(Pokemon difensore) {
		double modificatore = 1; 
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
	
//	public void attacca(Pokemon attaccante, Pokemon difensore) {
//		int precisione = getPrecisioneMossa();
//		double elusione = difensore.getElusione();
//		int a = generaInteroCasuale(0, 255);
//		double b = generaDoubleCasuale(0, 100);
//		if(b >= elusione) {
//			if(a >= precisione) {
//				System.out.println("l'attacco fallisce");
//				setPP(getPP() - 1);
//			}else {
//				Danno(attaccante, difensore);
//			}
//		}else {
//			System.out.println(difensore.getNome() + " evita il colpo");
//			this.setPP(this.getPP() - 1);
//		}
//	}
	
	public void attaccaDanno(Pokemon att, Pokemon dif) {
		int precisione = getPrecisioneMossa();
		double elusione = dif.getElusione();
		int a = generaInteroCasuale(0, 100);
		double probabilitaSuccesso = precisione / elusione;
		if(probabilitaSuccesso < a) {
			Danno(att, dif);
		}else {
			System.out.println(dif.getNome() + " evita il colpo");
			this.setPP(this.getPP() - 1);
		}
	}

}
