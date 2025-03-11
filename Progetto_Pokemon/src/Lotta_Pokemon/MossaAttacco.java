package Lotta_Pokemon;

public class MossaAttacco extends Mossa{
	
	private int potenzaMossa;

	public MossaAttacco(String nomeMossa, int elementoMossa, String tipo, int PP, int PPmax, int precisioneMossa, int potenzaMossa) {
		super(nomeMossa, elementoMossa, tipo, PP, PPmax, precisioneMossa);
		this.potenzaMossa = potenzaMossa;
	}

	
	
	// Per il calcolo del danno una volta che l'attacco va a segno
	
	public void Danno(Pokemon att, Pokemon dif) { 
	    int danno = 0;
	    
	    System.out.println(dif.getHp());
	    
	    if(getTipo().equals("speciale")) {
	        danno = (int) (((potenzaMossa * (double) att.getAttaccoSpeciale()) / dif.getDifesaSpeciale()) * modificatore(dif));
	    } else if(getTipo().equals("fisico")) {
	        danno = (int) (((potenzaMossa * (double) att.getAttacco()) / dif.getDifesa()) * modificatore(dif));
	    }	   
	    
	    danno = Math.max(danno, 0); // Assicura che il danno non sia negativo
	    
	    dif.setHp(dif.getHp()-danno);
	}

	
	@Override
	public boolean noPP() {
		return super.noPP();
	}
	
	// Per verificare se l'attacco va a segno o meno
	
	public void attaccaDanno(Pokemon att, Pokemon dif) {
		int precisione = getPrecisioneMossa();
		double elusione = dif.getElusione();
		int a = generaInteroCasuale(0, 100);
		double probabilitaSuccesso = precisione / elusione;
		if (probabilitaSuccesso * 100 > a) {
			setColpito(true);
			Danno(att, dif);
			setPP(getPP()-1);
		}else {
			setColpito(false);
			setPP(getPP() - 1);
		}
	}
	
	@Override
	public String getEffetto() {
	    return ""; // Restituisce null
	}
	
}
