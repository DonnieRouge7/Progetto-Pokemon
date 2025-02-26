package Lotta_Pokemon;
import java.util.ArrayList;
import java.util.List;

public class Charmander extends Pokemon {
	
	// Classe del Pokemon Charmander 
	
	public Charmander() {
		super("123", 1, -1, "Charmander", 0, 1, 39, 39, 52, 43, 50,
				50, 65, 30);
		
		// Creazione delle mosse ad aggiunta alla lista
		
		List<Mossa> mosse = new ArrayList<>();
		
		Mossa braciere = new MossaAttacco("Braciere", 1, "speciale", 25, 100, 40);
		Mossa morso = new MossaAttacco("Morso", 0, "fisico", 25, 100, 60);
		Mossa colpocoda = new MossaStato("Colpocoda", 0, "stato", 30, 100, "Diminuisci Difesa");
		Mossa ruggito = new MossaStato("Ruggito", 0, "stato", 40, 100, "Diminuisci Attacco"); 
		
		mosse.add(braciere);
		mosse.add(morso);
		mosse.add(ruggito);
		mosse.add(colpocoda);
		
	/*	Mossa[] mosse = new Mossa[4];
		mosse[0] = braciere;
		mosse[1] = morso;
		mosse[2] = colpocoda;
		mosse[3] = ruggito;
	*/	
		super.setMosse(mosse);
	}
}
