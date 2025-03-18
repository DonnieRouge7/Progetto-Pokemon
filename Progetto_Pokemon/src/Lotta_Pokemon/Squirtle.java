package Lotta_Pokemon;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Classe del pokemon Squirtle che estende la classe Pokemon
 * ed inizializza le sue caratteristiche base e le sue mosse
 *
 */

public class Squirtle extends Pokemon {

	/**
	 * Costruttore del Pokemon Squirtle
	 * Inizializza il Pokémon con le sue statistiche di base e le mosse disponibili.
	 * 
	 */
	public Squirtle() {

		super(
				"002", // codice
				2, // codice tipo
				-1, // codice 2 tipo, se presente
				"Squirtle", // nome
				0, // xp attuali
				1, // livello
				44, // xp attuali
				44, // xp massimi
				48, // attacco
				65, // difesa
				50, // attacco speciale
				50, // difesa speciale
				43); // velocità

		// Creazione delle mosse ed aggiunta alla lista
		List<Mossa> mosse = new ArrayList<>();

		Mossa bolla = new MossaAttacco("Bolla", 2, "speciale", 30, 30, 100, 40);
		Mossa pistolacqua = new MossaAttacco("Pistolacqua", 2, "speciale", 25, 25, 100, 40);
		Mossa colpocoda = new MossaStato("Colpocoda", 0, "stato", 30, 30, 100, "Diminuisce Difesa");
		Mossa azione = new MossaAttacco("Azione", 0, "fisico", 35, 35, 100, 40);

		mosse.add(bolla);
		mosse.add(azione);
		mosse.add(pistolacqua);
		mosse.add(colpocoda);

		// Assegnazione delle mosse
		super.setMosse(mosse);
	}
}
