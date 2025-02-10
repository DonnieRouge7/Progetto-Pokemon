package Lotta_Pokemon;

import java.util.ArrayList;
import java.util.List;

public class Pikachu extends Pokemon implements TipoElettro{

	public Pikachu() {
		super("111",tipoElettro, -1, "Pikachu", 0, 1, 35, 55, 40, 50,
				50, 90, 30);
		
		List<Mossa> mosse = new ArrayList<>();
		
		Mossa locomovolt = new MossaAttacco("Locomvolt", 3, "fisico", 15, 100, 120);
		Mossa attacco_rapido = new MossaAttacco("Attacco rapido", 1, "fisico", 30, 100, 40);
		Mossa fulmine = new MossaAttacco("Fulmine", 3, "speciale", 15, 100, 90);
		Mossa doppioteam = new MossaStato("Doppioteam", 1, "stato", 15, 100, "Aumenta Elusione");
		
		mosse.add(locomovolt);
		mosse.add(attacco_rapido);
		mosse.add(fulmine);
		mosse.add(doppioteam);
		
		super.setMosse(mosse);
	}

}
