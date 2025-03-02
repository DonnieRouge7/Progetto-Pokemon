package Lotta_Pokemon;
import java.util.ArrayList;
import java.util.List;

// Classe del Pokemon Squirtle

public class Squirtle extends Pokemon {

	public Squirtle() {
		super("002", 2, -1, "Squirtle", 0, 1, 44, 44, 48, 65, 50,
				50, 43, 30);
		
		// Creazione delle mosse ed aggiunta alla lista
		
		List<Mossa> mosse = new ArrayList<>();	
		
		Mossa bolla = new MossaAttacco("Bolla", 2, "speciale", 30, 100, 40);
		Mossa pistolacqua = new MossaAttacco("Pistolacqua", 2, "speciale", 25, 100, 40);
		Mossa colpocoda = new MossaStato("Colpocoda", 0, "stato", 30, 100, "Diminuisce Difesa");
		Mossa morso = new MossaAttacco("Morso", 0, "fisico", 25, 100, 60);
		
		mosse.add(bolla);
		mosse.add(morso);
		mosse.add(pistolacqua);
		mosse.add(colpocoda);
		
		super.setMosse(mosse);
	}

	
}
