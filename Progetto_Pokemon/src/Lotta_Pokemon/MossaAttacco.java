package Lotta_Pokemon;

public class MossaAttacco extends Mossa{
	
	private int potenzaMossa;

	public MossaAttacco(String nomeMossa, int elementoMossa, String tipo, int PP, int precisioneMossa, int potenzaMossa) {
		super(nomeMossa, elementoMossa, tipo, PP, precisioneMossa);
		this.potenzaMossa = potenzaMossa;
	}

	@Override
	public boolean noPP() {
		return super.noPP();
	}
	
	// Per il calcolo del danno una volta che l'attacco va a segno
	
	public void Danno(Pokemon attaccante, Pokemon difensore) { 
		int danno = 0;
		if(getTipo().equals("speciale")) {
			danno = (int) (((potenzaMossa * attaccante.getAttaccoSpecialePokemon())/difensore.getDifesaSpecialePokemon())*modificatore(difensore));
		}else if(getTipo().equals("fisico")){
			danno = (int) (((potenzaMossa * attaccante.getAttaccoPokemon())/difensore.getDifesaPokemon())* modificatore(difensore));
		}
		danno = Math.max(1, danno); // Impedisce che il danno sia 0 o negativo
		difensore.subisciDanno(danno);
		setPP(getPP() - 1);
	}
	
	// Per verificare se l'attacco va a segno o meno
	
	public void attaccaDanno(Pokemon att, Pokemon dif) {
		int precisione = getPrecisioneMossa();
		double elusione = dif.getElusione();
		int a = generaInteroCasuale(0, 100);
		double probabilitaSuccesso = precisione / elusione;
		if(probabilitaSuccesso < a) {
			setColpito(true);
			Danno(att, dif);
		}else {
			setColpito(false);
			this.setPP(this.getPP() - 1);
		}
	}
}
