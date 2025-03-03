package Lotta_Pokemon;
import java.util.ArrayList;
import java.util.List;

// Classe del Pokemon Bulbasaur

public class Bulbasaur extends Pokemon {

	public Bulbasaur() {
		
		super(	"003" 			/* codice */, 
				4 				/* codice tipo */, 
				-1 				/* codice 2 tipo, se presente */, 
				"Bulbasaur", 	/* nome */
				0, 				/* xp attuali */
				1, 	 			/* livello */
				45, 			/* xp attuali*/	
				45, 			/* xp massimi */
				49, 			/* attacco */
				49, 			/* difesa */
				65, 			/* attacco speciale */
				65, 			/* difesa speciale */	
				45, 			/* velocità */
				30);			/* elusione */		
		
		// Creazione delle mosse ed aggiunta alla lista	
		
		List<Mossa> mosse = new ArrayList<>();	
		
		Mossa frustata = new MossaAttacco("Frustata", 4, "fisico", 25, 100, 45);
		Mossa foglielama = new MossaAttacco("Foglielama", 4, "fisico", 25, 100, 55);
		Mossa ruggito = new MossaStato("Ruggito", 0, "stato", 40, 100, "Diminuisce Attacco");
		Mossa azione = new MossaAttacco("Azione", 0, "fisico", 35, 100, 40);
	
		mosse.add(frustata);
		mosse.add(foglielama);
		mosse.add(ruggito);
		mosse.add(azione);
	
		super.setMosse(mosse);
	
	}
	
}
