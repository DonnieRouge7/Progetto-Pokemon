package Lotta_Pokemon;

import java.util.ArrayList;
import java.util.List;

public class Pidgey extends Pokemon{

	// CLsse del 
	
	public Pidgey() {
		
		super(	"005" 		/* codice */, 
				9 			/* codice tipo */, 
				-1 			/* codice 2 tipo, se presente */, 
				"Pikachu", 	/* nome */
				0, 			/* xp attuali */
				1, 	 		/* livello */
				40, 		/* xp attuali*/	
				40, 		/* xp massimi */
				45, 		/* attacco */
				40, 		/* difesa */
				35, 		/* attacco speciale */
				35, 		/* difesa speciale */	
				56, 		/* velocità */
				30);		/* elusione */
		
		// Creazione delle mosse ed aggiunta alla lista
		
		List<Mossa> mosse = new ArrayList<>();
		
		Mossa attacco_rapido = new MossaAttacco("Attacco rapido", 1, "fisico", 30, 100, 40);
		Mossa doppioteam = new MossaStato("Doppioteam", 1, "stato", 15, 100, "Aumenta Elusione");
		Mossa agilità = new MossaStato("Agilità", 10, "stato", 30, 100, "Aumenta Velocità");
		Mossa volo = new MossaAttacco("Volo", 9, "fisico", 15, 95, 70);
		
		mosse.add(attacco_rapido);
		mosse.add(doppioteam);
		mosse.add(agilità);
		mosse.add(volo);
		
		super.setMosse(mosse);
		
	}

	
}
