package Lotta_Pokemon;
import java.util.ArrayList;
import java.util.List;

public class Bulbasaur extends Pokemon implements TipoErba {

	public Bulbasaur() {
		super("213", tipoErba, -1, "Bulbasaur", 0, 1, 45, 49, 49, 65,
				65, 45, 30);
	
	List<Mossa> mosse = new ArrayList<>();	
		
	Mossa frustata = new MossaAttacco("Frustata", 5, "fisico", 25, 100, 45);
	Mossa foglielama = new MossaAttacco("Foglielama", 5, "fisico", 25, 100, 55);
	Mossa ruggito = new MossaStato("Ruggito", 0, "stato", 40, 100, "Diminuisci Attacco");
	Mossa crescita = new MossaStato("Crescita", 0, "stato", 20, 100, "Aumenta Attacco");
	
	mosse.add(frustata);
	mosse.add(foglielama);
	mosse.add(ruggito);
	mosse.add(crescita);
	
	super.setMosse(mosse);
	
	}
	
}
