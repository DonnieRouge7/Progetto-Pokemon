package Lotta_Pokemon;

import java.util.ArrayList;
import java.util.List;

/**
 * La classe {@code Charmander} rappresenta il Pokémon Charmander,
 * estendendo la classe {@code Pokemon}.
 * Questo Pokémon è di tipo Fuoco e possiede un set di mosse iniziali.
 */

public class Charmander extends Pokemon {
    
    /**
     * Costruttore della classe {@code Charmander}.
     * Inizializza le statistiche di base e le mosse disponibili.
     */
    
	public Charmander() {
        super( "001",  			// Codice identificativo
               1,      			// Codice tipo (Fuoco)
               -1,     			// Codice del secondo tipo (non presente)
               "Charmander",  	// Nome
               0,      			// Esperienza attuale
               1,      			// Livello
               39,     			// Punti Vita attuali
               39,     			// Punti Vita massimi
               52,     			// Attacco
               43,    			// Difesa
               50,     			// Attacco Speciale
               50,     			// Difesa Speciale
               65);     		// Velocità        		    

        // Creazione delle mosse e aggiunta alla lista
        List<Mossa> mosse = new ArrayList<>();

        Mossa braciere = new MossaAttacco("Braciere", 1, "speciale", 25, 25, 100, 40);
        Mossa graffio = new MossaAttacco("Graffio", 0, "fisico", 25, 25, 100, 40);
        Mossa colpocoda = new MossaStato("Colpocoda", 0, "stato", 30, 30, 100, "Diminuisce Difesa");
        Mossa ruggito = new MossaStato("Ruggito", 0, "stato", 40, 40, 100, "Diminuisce Attacco");

        mosse.add(braciere);
        mosse.add(graffio);
        mosse.add(ruggito);
        mosse.add(colpocoda);

        // Assegnazione delle mosse
        super.setMosse(mosse);
    }
}
