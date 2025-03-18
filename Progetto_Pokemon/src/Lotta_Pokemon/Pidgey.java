package Lotta_Pokemon;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe che rappresenta il Pokémon Pidgey.
 * Pidgey è un Pokémon di tipo Normale/Volante con un set di mosse predefinito.
 */

public class Pidgey extends Pokemon {

    /**
     * Costruttore della classe Pidgey.
     * Inizializza il Pokémon con i suoi attributi di base e le sue mosse.
     */
    
	public Pidgey() {
        super("005", 		// codice
              0, 			// codice tipo (Normale)
              9, 			// codice secondo tipo (Volante)
              "Pidgey", 	// nome
              0, 			// XP attuali
              1, 			// livello
              40, 			// HP attuali
              40, 			// HP massimi
              45, 			// attacco
              40, 			// difesa
              35, 			// attacco speciale
              35, 			// difesa speciale
              56);			// velocità
        		 
        // Creazione della lista di mosse del Pokémon
        List<Mossa> mosse = new ArrayList<>();
        
        // Definizione delle mosse
        Mossa attacco_rapido = new MossaAttacco("Attacco Rapido", 1, "fisico", 30, 30, 100, 40);
        Mossa doppioteam = new MossaStato("Doppioteam", 1, "stato", 15, 15, 100, "Aumenta Elusione");
        Mossa agilita = new MossaStato("Agilità", 10, "stato", 30, 30, 100, "Aumenta Velocità");
        Mossa volo = new MossaAttacco("Volo", 9, "fisico", 15, 15, 95, 70);
        
        // Aggiunta delle mosse alla lista
        mosse.add(attacco_rapido);
        mosse.add(doppioteam);
        mosse.add(agilita);
        mosse.add(volo);
        
        // Assegnazione delle mosse
        super.setMosse(mosse);
    }
}
