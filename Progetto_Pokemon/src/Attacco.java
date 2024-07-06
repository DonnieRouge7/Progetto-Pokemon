
public class Attacco extends Mossa {
	int potenzaMossa;
	int precisioneMossa;
	double[][] efficacia = {
			//                   NOR, FUO, ACQ, ELE, ERB, GHI, LOT, VEL, TER, VOL, PSI, COL, ROC, SPE, DRA, BUI, ACC
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
	
	public double Danno(Pokemon p1, Pokemon p2, Attacco a1) {
		double danno = 0;
		double hp = p1.getHp();
		if(a1.tipo == "speciale") {
			danno = ((a1.potenzaMossa * p1.getAttaccoSpecialePokemon())/p2.getDifesaSpecialePokemon())* modificatore(p2, a1);
		}else if(a1.tipo == "fisico"){
			danno = ((a1.potenzaMossa * p1.getAttaccoPokemon())/p2.getDifesaPokemon())* modificatore(p2, a1);
		}
	a1.PP--; 
	return subisciDanno(hp, danno);
	}
	
	public double subisciDanno(double hp, double danno) {
		hp = hp - danno;
		return hp;	
	}
	
	public double modificatore(Pokemon p2, Attacco a1) {
		double modificatore = 1; 
		if(p2.getTipo2() != -1) { // nel costruttore del Pokemon, se non c'è un secondo tipo, il valore è -1
			modificatore *= efficacia[a1.elementoMossa][p2.getTipo2()]; 
		}
		modificatore *= efficacia[a1.elementoMossa][p2.getTipo1()];
	return modificatore;
	}
	
	public void colpoASegno(Attacco a1, Pokemon p1, Pokemon p2) {
		int precisione = precisioneMossa;
		double elusione = p2.getElusione();
		int a = generaInteroCasuale(0, 100);
		double b = generaDoubleCasuale(0, 100);
		if(b >= elusione) {
			if(a >= precisione) {
				System.out.println("l'attacco fallisce");
				a1.PP--;
			}else {
				Danno(p1, p2, a1); 
			}
		}else {
			System.out.println(p2.getNome() + " evita il colpo");
			a1.PP--;
		}
	}
}
