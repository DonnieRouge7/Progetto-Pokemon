package Lotta_Pokemon;
import java.util.ArrayList;
import java.util.List;

public class Charmander extends Pokemon {
	
	// Classe del Pokemon Charmander 
	
	public Charmander() {
	
		super(	"001" 			/* codice */, 
				1 				/* codice tipo */, 
				-1 				/* codice 2 tipo, se presente */, 
				"Charmander", 	/* nome */
				0, 				/* xp attuali */
				1, 	 			/* livello */
				39, 			/* xp attuali*/	
				39, 			/* xp massimi */
				52, 			/* attacco */
				43, 			/* difesa */
				50, 			/* attacco speciale */
				50, 			/* difesa speciale */	
				65, 			/* velocità */
				30);			/* elusione */
		
		// Creazione delle mosse ad aggiunta alla lista
		
		List<Mossa> mosse = new ArrayList<>();
		
		Mossa braciere = new MossaAttacco("Braciere", 1, "speciale", 25, 100, 40);
		Mossa graffio = new MossaAttacco("Graffio", 0, "fisico", 35, 100, 40);
		Mossa colpocoda = new MossaStato("Colpocoda", 0, "stato", 30, 100, "Diminuisce Difesa");
		Mossa ruggito = new MossaStato("Ruggito", 0, "stato", 40, 100, "Diminuisce Attacco"); 
		
		mosse.add(braciere);
		mosse.add(graffio);
		mosse.add(ruggito);
		mosse.add(colpocoda);
		
		super.setMosse(mosse);
	}
}
