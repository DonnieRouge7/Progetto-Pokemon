
public class Stato extends Mossa{
	int bersaglio; 
	
	public void stato(Pokemon p1, Pokemon p2, Stato s1) {
		if(s1.bersaglio == 1) {
			if(s1.codiceMossa == 1) {
				int attaccoPokemon = p1.getAttaccoPokemon();
				attaccoPokemon += 3;
			}else if(s1.codiceMossa == 2) {
				int difesaPokemon = p1.getDifesaPokemon();
				difesaPokemon += 3;
			}else if(s1.codiceMossa == 3) {
				int attaccoSpecialePokemon = p1.getAttaccoSpecialePokemon();
				attaccoSpecialePokemon += 3; 
			}else if(s1.codiceMossa == 4) {
				int difesaSpecialePokemon = p1.getDifesaSpecialePokemon();
				difesaSpecialePokemon += 3; 
			}else if(s1.codiceMossa == 5) {
				int velocitàPokemon = p1.getVelocitàPokemon();
				velocitàPokemon += 3; 
			}else if(s1.codiceMossa == 6) {
				double elusione = p1.getElusione();
				elusione += 3;
			}
		}else if(s1.bersaglio == 2){
			if(s1.codiceMossa == 1) {
				int attaccoPokemon = p2.getAttaccoPokemon();
				attaccoPokemon -= 3;
			}else if(s1.codiceMossa == 2) {
				int difesaPokemon = p2.getDifesaPokemon();
				difesaPokemon -= 3;
			}else if(s1.codiceMossa == 3) {
				int attaccoSpecialePokemon = p2.getAttaccoSpecialePokemon();
				attaccoSpecialePokemon -= 3; 
			}else if(s1.codiceMossa == 4) {
				int difesaSpecialePokemon = p2.getDifesaSpecialePokemon();
				difesaSpecialePokemon -= 3; 
			}else if(s1.codiceMossa == 5) {
				int velocitàPokemon = p2.getVelocitàPokemon();
				velocitàPokemon -= 3; 
			}else if(s1.codiceMossa == 6) {
				double elusione = p2.getElusione();
				elusione -= 3;
			}
		}
	s1.PP--; 
	}
	
	public void colpoASegno(Pokemon p1, Pokemon p2, Stato s1) {
		int precisione = precisioneMossa;
		double elusione = p2.getElusione();
		int a = generaInteroCasuale(0, 100);
		double b = generaDoubleCasuale(0, 100);
		if(b >= elusione) {
			if(a >= precisione) {
				System.out.println("l'attacco fallisce");
				s1.PP--;
			}else {
				stato(p1, p2, s1); 
			}
		}else {
			System.out.println(p2.getNome() + " evita il colpo");
			s1.PP--;
		}
	}
}

