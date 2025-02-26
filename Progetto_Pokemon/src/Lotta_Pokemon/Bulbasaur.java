package Lotta_Pokemon;
import java.util.ArrayList;
import java.util.List;

// Classe del Pokemon Bulbasaur

public class Bulbasaur extends Pokemon {

	public Bulbasaur() {
		super("213", 4, -1, "Bulbasaur", 0, 1, 45, 45, 49, 49, 65,
				65, 45, 30);
	
		// Creazione delle mosse ed aggiunta alla lista	
		
		List<Mossa> mosse = new ArrayList<>();	
		
		Mossa frustata = new MossaAttacco("Frustata", 4, "fisico", 25, 100, 45);
		Mossa foglielama = new MossaAttacco("Foglielama", 4, "fisico", 25, 100, 55);
		Mossa ruggito = new MossaStato("Ruggito", 0, "stato", 40, 100, "Diminuisci Attacco");
		Mossa crescita = new MossaStato("Crescita", 0, "stato", 20, 100, "Aumenta Attacco");
	
		mosse.add(frustata);
		mosse.add(foglielama);
		mosse.add(ruggito);
		mosse.add(crescita);
	
		super.setMosse(mosse);
	
	}
	
}
