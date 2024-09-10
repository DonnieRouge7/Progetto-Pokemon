
public class MossaStato extends Mossa{
	
	private String effetto;
	
	MossaStato(String nomeMossa, int elementoMossa, String tipo, int PP, int precisioneMossa, String effetto) {
		super(nomeMossa, elementoMossa, tipo, PP, precisioneMossa);
		this.effetto = effetto;
	}
	
	public void usaMossaStato(Pokemon p1, MossaStato s1) {
		switch(s1.effetto) {
		case "Aumenta Difesa":
			p1.setDifesaPokemon(+3);
		case "Aumenta Attacco":
			p1.setAttaccoPokemon(+3);
		case "Aumenta Difesa Speciale":
			p1.setDifesaSpecialePokemon(+3);
		case "Aumenta Attacco Speciale":
			p1.setAttaccoSpecialePokemon(+3);
		case "Aumenta Velocità":
			p1.setVelocitàPokemon(+3);
		case "Aumenta Elusione": 
			p1.setElusione(+3);
		case "Diminuisci Difesa":
			p1.setDifesaPokemon(-3);
		case "Diminuisci Attacco":
			p1.setAttaccoPokemon(-3);
		case "Diminuisci Difesa Speciale":
			p1.setDifesaSpecialePokemon(-3);
		case "Diminuisci Attacco Speciale":
			p1.setAttaccoSpecialePokemon(-3);
		case "Diminuisci Velocità":
			p1.setVelocitàPokemon(-3);
		case "Diminuisci Elusione":
			p1.setElusione(-3);
		}
		s1.setPP(s1.getPP() - 1);
	}
	
	@Override
	public boolean noPP() {
		return super.noPP();
	}

	public void attacca(Pokemon attaccante, Pokemon difensore, MossaStato s1) {
		int precisione = s1.precisioneMossa;
		double elusione = difensore.getElusione();
		int a = generaInteroCasuale(0, 255);
		double b = generaDoubleCasuale(0, 100);
		if(b >= elusione) {
			if(a >= precisione) {
				System.out.println("l'attacco fallisce");
				s1.setPP(s1.getPP() - 1);
			}else {
				usaMossaStato(attaccante, s1); 
			}
		}else {
			System.out.println(difensore.getNome() + " evita il colpo");
			s1.setPP(s1.getPP() - 1);
		}
	}
}

