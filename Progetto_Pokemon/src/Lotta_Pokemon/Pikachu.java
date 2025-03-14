package Lotta_Pokemon;
import java.util.ArrayList;
import java.util.List;

/**

Classe che rappresenta il Pokémon Pikachu ed estende la classe base Pokemon.
Contiene i dati relativi alle statistiche e alle mosse di Pikachu.
*/

public class Pikachu extends Pokemon {
	
	/**
	 * Costruttore della classe Pikachu.
	 *
	 * Inizializza un'istanza del Pokémon Pikachu con valori predefiniti per le sue statistiche
	 * e assegna un set di mosse disponibili.
	 */
	
	public Pikachu() {
	    super(
	        "004",     /* codice */
	        3,         /* codice tipo (Elettrico) */
	        -1,        /* codice secondo tipo (non presente) */
	        "Pikachu", /* nome */
	        0,         /* XP attuali */
	        1,         /* livello */
	        35,        /* HP attuali */    
	        35,        /* HP massimi */
	        55,        /* attacco */
	        40,        /* difesa */
	        50,        /* attacco speciale */
	        50,        /* difesa speciale */    
	        90,        /* velocità */
	        30         /* elusione */
	    );
	    
	    // Creazione delle mosse e aggiunta alla lista
	    List<Mossa> mosse = new ArrayList<>();
	    
	    Mossa azione = new MossaAttacco("Azione", 0, "fisico", 35, 35, 100, 40);
	    Mossa attacco_rapido = new MossaAttacco("Attacco rapido", 0, "fisico", 30, 30, 100, 40);
	    Mossa fulmine = new MossaAttacco("Fulmine", 3, "speciale", 15, 15, 100, 90);
	    Mossa doppioteam = new MossaStato("Doppioteam", 0, "stato", 15, 15, 100, "Aumenta Elusione");
	    
	    mosse.add(azione);
	    mosse.add(attacco_rapido);
	    mosse.add(fulmine);
	    mosse.add(doppioteam);
	    
	    // Imposta la lista delle mosse di Pikachu
	    super.setMosse(mosse);
	}
	
}
