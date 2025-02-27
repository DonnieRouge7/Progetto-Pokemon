package Lotta_Pokemon;

public class MossaStato extends Mossa{
	
	private String effetto;
	
	MossaStato(String nomeMossa, int elementoMossa, String tipo, int PP, int precisioneMossa, String effetto) {
		super(nomeMossa, elementoMossa, tipo, PP, precisioneMossa);
		this.effetto = effetto;
	}
	
	// Per l'applicazione dell'effetto delle mosse che modificano le caratteristiche
	
	public void usaMossaStato(Pokemon attaccante, Pokemon difensore) {
		double x = 0;
		double y = 0;
		switch(effetto) {
		case "Aumenta Difesa":
			attaccante.setDifesaPokemon(attaccante.getDifesaPokemon() + ((attaccante.getDifesaPokemon()/100) * 33));
			System.out.println("la difesa di " + attaccante.getNome() + " sale");
			break;
		case "Aumenta Attacco":
			attaccante.setAttaccoPokemon(attaccante.getAttaccoPokemon() + ((attaccante.getAttaccoPokemon()/100) * 33));
			System.out.println("l'attacco di " + attaccante.getNome() + " sale");
			break;
		case "Aumenta Difesa Speciale":
			attaccante.setDifesaSpecialePokemon(attaccante.getDifesaSpecialePokemon() + ((attaccante.getDifesaSpecialePokemon()/100) * 33));
			System.out.println("la difesa speciale di " + attaccante.getNome() + " sale");
			break;
		case "Aumenta Attacco Speciale":
			attaccante.setAttaccoSpecialePokemon(attaccante.getAttaccoSpecialePokemon() + ((attaccante.getAttaccoSpecialePokemon()/100) * 33));
			System.out.println("l'attacco speciale di " + attaccante.getNome() + " avversario"+ " sale");
			break;
		case "Aumenta Velocità":
			attaccante.setVelocitàPokemon(attaccante.getVelocitàPokemon() + ((attaccante.getVelocitàPokemon()/100) * 33));
			System.out.println("la velocità di " + attaccante.getNome() + " sale");
			break;
		case "Aumenta Elusione": 
			attaccante.setElusione(attaccante.getElusione() + ((attaccante.getElusione()/100) * 33));
			System.out.println("l'elusione di " + attaccante.getNome() + " sale");
			break;
		case "Diminuisci Difesa":
			x = difensore.getDifesaPokemon();
			y = x - (x/100 * 33);
			difensore.setDifesaPokemon((int) Math.max(1, y)); // Evita che l'attacco vada sotto 1
			System.out.println("la difesa di " + difensore.getNome() + " avversario"+ " cala");
			break;
		case "Diminuisci Attacco":
			 x = difensore.getAttaccoPokemon();
			 y = x - (x/100 * 33);
			 difensore.setAttaccoPokemon((int) Math.max(1, y)); // Evita che l'attacco vada sotto 1
			System.out.println("l'attacco di " + difensore.getNome() + " avversario"+ " cala");
			break;
		case "Diminuisci Difesa Speciale":
			difensore.setDifesaSpecialePokemon(difensore.getDifesaSpecialePokemon() - ((difensore.getDifesaSpecialePokemon()/100)*33));
			System.out.println("la difesa speciale di " + difensore.getNome() + " avversario" + " cala");
			break;
		case "Diminuisci Attacco Speciale":
			difensore.setAttaccoSpecialePokemon(difensore.getAttaccoSpecialePokemon() - ((difensore.getAttaccoSpecialePokemon()/100)*33));
			System.out.println("l'attacco speciale di " + difensore.getNome() + " avversario"+ " cala");
			break;
		case "Diminuisci Velocità":
			difensore.setVelocitàPokemon(difensore.getVelocitàPokemon() - ((difensore.getVelocitàPokemon()/100)*33));
			System.out.println("la velocità di " + difensore.getNome() + " avversario"+ " cala");
			break;
		case "Diminuisci Elusione":
			difensore.setElusione(difensore.getElusione() - ((difensore.getElusione()/100)*33));
			System.out.println("l'elusione di " + difensore.getNome() + " avversario"+ " cala");
			break;
		}
		setPP(getPP() - 1);
	}
	
	@Override
	public boolean noPP() {
		return super.noPP();
	}
	
	// Per verificare se un attacco va a segno o meno
	
	public void attaccaStato(Pokemon att, Pokemon dif) {
		int precisione = getPrecisioneMossa();
		double elusione = dif.getElusione();
		int a = generaInteroCasuale(0, 100);
		double probabilitaSuccesso = precisione / elusione;
		if(probabilitaSuccesso < a) {
			setColpito(true);
			usaMossaStato(att, dif);
		}else {
			setColpito(false);
			this.setPP(this.getPP() - 1);
		}
	}
}

