package Lotta_Pokemon;
import java.util.ArrayList;
import java.util.List;

public class Pikachu extends Pokemon {
	
	// Classe del Pokemon Pikachu
	
	public Pikachu() {
		
		super(	"004" 		/* codice */, 
				3 			/* codice tipo */, 
				-1 			/* codice 2 tipo, se presente */, 
				"Pikachu", 	/* nome */
				0, 			/* xp attuali */
				1, 	 		/* livello */
				35, 		/* xp attuali*/	
				35, 		/* xp massimi */
				55, 		/* attacco */
				40, 		/* difesa */
				50, 		/* attacco speciale */
				50, 		/* difesa speciale */	
				90, 		/* velocità */
				30);		/* elusione */
		
		// Creazione delle mosse ed aggiunta alla lista
		
		List<Mossa> mosse = new ArrayList<>();
		
		Mossa azione = new MossaAttacco("Azione", 0, "fisico", 35, 100, 40);
		Mossa attacco_rapido = new MossaAttacco("Attacco rapido", 1, "fisico", 30, 100, 40);
		Mossa fulmine = new MossaAttacco("Fulmine", 3, "speciale", 15, 100, 90);
		Mossa doppioteam = new MossaStato("Doppioteam", 1, "stato", 15, 100, "Aumenta Elusione");
		
		mosse.add(azione);
		mosse.add(attacco_rapido);
		mosse.add(fulmine);
		mosse.add(doppioteam);
		
		super.setMosse(mosse);
	}

}
