
public class Attacco extends Mossa {
	int potenzaMossa;
	int precisioneMossa;
	double[][] efficacia = {
		    //  No   Fu  Ac  El  Er  Gh  Lo  Ve  Te  Vo  Ps  Co  Ro  Sp  Dr  Bu  Ac
		    { 1,   1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  0.5, 0,  1,  1,  0.5},  // Normale
		    { 1,  0.5, 2,  1,  0.5, 2,  1,  1,  2,  1,  1,  2,  0.5, 1,  0.5, 1,  2},  // Fuoco
		    { 1,   0.5, 0.5, 1,  2,  1,  1,  1,  1,  1,  1,  1,  2,  1,  0.5, 1,  1},  // Acqua
		    { 1,   1,  2,  0.5, 0.5, 1,  1,  1,  0,  2,  1,  1,  1,  1,  0.5, 1,  1},  // Elettrico
		    { 1,   2,  0.5, 1,  0.5, 1,  1,  0.5, 2,  0.5, 1,  0.5, 2,  1,  0.5, 1,  0.5},  // Erba
		    { 1,   1,  1,  1,  2,  0.5, 1,  1,  2,  2,  1,  1,  1,  1,  2,  1,  0.5},  // Ghiaccio
		    { 2,   1,  1,  1,  1,  2,  1,  0.5, 1,  0.5, 0.5, 0.5, 2,  0,  1,  2,  2},  // Lotta
		    { 1,   1,  1,  1,  2,  1,  1,  0.5, 0.5, 1,  1,  0.5, 0.5, 0.5, 1,  1,  0},  // Veleno
		    { 1,   2,  1,  2,  0.5, 1,  1,  2,  1,  0,  1,  0.5, 2,  1,  1,  1,  2},  // Terra
		    { 1,   1,  1,  0.5, 2,  1,  2,  1,  1,  1,  1,  2,  0.5, 1,  1,  1,  0.5},  // Volante
		    { 1,   1,  1,  1,  1,  1,  2,  2,  1,  1,  0.5, 1,  1,  1,  1,  0,  0.5},  // Psico
		    { 1,   0.5, 1,  1,  2,  1,  0.5, 1,  1,  0.5, 2,  1,  1,  0.5, 1,  2,  0.5},  // Coleottero
		    { 1,   2,  1,  1,  1,  2,  0.5, 1,  0.5, 2,  1,  2,  1,  1,  1,  1,  0.5},  // Roccia
		    { 0,   1,  1,  1,  1,  1,  1,  1,  1,  1,  2,  1,  1,  2,  1,  0.5, 1},  // Spettro
		    { 1,   1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  2,  1,  0.5},  // Drago
		    { 1,   1,  1,  1,  1,  1,  0.5, 1,  1,  1,  2,  1,  1,  2,  1,  0.5, 0.5},  // Buio
		    { 1,   0.5, 0.5, 0.5, 1,  2,  1,  1,  1,  1,  1,  1,  2,  1,  2,  1,  0.5}   // Acciaio
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
		if(p2.getElemento2() != -1) { // nel costruttore del Pokemon, se non c'è un secondo tipo, il valore è -1
			modificatore *= efficacia[a1.elementoMossa][p2.getElemento2()]; 
		}
		modificatore *= efficacia[a1.elementoMossa][p2.getElemento1()];
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
