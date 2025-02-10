package Lotta_Pokemon;

public class MossaStato extends Mossa{
	
	private String effetto;
	
	MossaStato(String nomeMossa, int elementoMossa, String tipo, int PP, int precisioneMossa, String effetto) {
		super(nomeMossa, elementoMossa, tipo, PP, precisioneMossa);
		this.effetto = effetto;
	}
	
	public void usaMossaStato(Pokemon p1) {
		double x = 0;
		double y = 0;
		switch(effetto) {
		case "Aumenta Difesa":
			p1.setDifesaPokemon(p1.getDifesaPokemon() + ((p1.getDifesaPokemon()/100) * 33));
			break;
		case "Aumenta Attacco":
			p1.setAttaccoPokemon(p1.getDifesaPokemon() + ((p1.getAttaccoPokemon()/100) * 33));
			break;
		case "Aumenta Difesa Speciale":
			p1.setDifesaSpecialePokemon(p1.getDifesaSpecialePokemon() + ((p1.getDifesaSpecialePokemon()/100) * 33));
			break;
		case "Aumenta Attacco Speciale":
			p1.setAttaccoSpecialePokemon(p1.getAttaccoSpecialePokemon() + ((p1.getAttaccoSpecialePokemon()/100) * 33));
			break;
		case "Aumenta Velocità":
			p1.setVelocitàPokemon(p1.getVelocitàPokemon() + ((p1.getVelocitàPokemon()/100) * 33));
			break;
		case "Aumenta Elusione": 
			p1.setElusione(p1.getElusione() + ((p1.getElusione()/100) * 33));
			break;
		case "Diminuisci Difesa":
			x = p1.getDifesaPokemon();
			y = x - (x/100 * 33);
			p1.setDifesaPokemon((int) y);
			break;
		case "Diminuisci Attacco":
			x = p1.getAttaccoPokemon();
			y = x - (x/100 * 33);
			p1.setAttaccoPokemon((int) y);
			break;
		case "Diminuisci Difesa Speciale":
			p1.setDifesaSpecialePokemon(p1.getDifesaSpecialePokemon() - ((p1.getDifesaSpecialePokemon()/100)*33));
			break;
		case "Diminuisci Attacco Speciale":
			p1.setAttaccoSpecialePokemon(p1.getAttaccoSpecialePokemon() - ((p1.getAttaccoSpecialePokemon()/100)*33));
			break;
		case "Diminuisci Velocità":
			p1.setVelocitàPokemon(p1.getVelocitàPokemon() - ((p1.getVelocitàPokemon()/100)*33));
			break;
		case "Diminuisci Elusione":
			p1.setElusione(p1.getElusione() - ((p1.getElusione()/100)*33));
			break;
		}
		setPP(getPP() - 1);
	}
	
	@Override
	public boolean noPP() {
		return super.noPP();
	}

//	public void attacca(Pokemon attaccante, Pokemon difensore, MossaStato s1) {
//		int precisione = s1.precisioneMossa;
//		double elusione = difensore.getElusione();
//		int a = generaInteroCasuale(0, 255);
//		double b = generaDoubleCasuale(0, 100);
//		if(b >= elusione) {
//			if(a >= precisione) {
//				System.out.println("l'attacco fallisce");
//				s1.setPP(s1.getPP() - 1);
//			}else {
//				usaMossaStato(attaccante, s1); 
//			}
//		}else {
//			System.out.println(difensore.getNome() + " evita il colpo");
//			s1.setPP(s1.getPP() - 1);
//		}
//	}
	
	public void attaccaStato(Pokemon att, Pokemon dif) {
		int precisione = getPrecisioneMossa();
		double elusione = dif.getElusione();
		int a = generaInteroCasuale(0, 100);
		double probabilitaSuccesso = precisione / elusione;
		if(probabilitaSuccesso < a) {
			usaMossaStato(dif);
		}else {
			System.out.println(dif.getNome() + " evita il colpo");
			setPP(getPP() - 1);
		}
	}
}

