package GUI_Pokemon;

import java.awt.*;
import javax.swing.*;

/**
 * Finestra principale dell'interfaccia grafica del gioco Pokémon.
 * Questa classe estende {@code JFrame} e ospita il menu principale.
 */

public class JPokeBattle extends JFrame {
	
	/** Pannello del menu principale del gioco */
	private MenuPrincipale menuPrincipale;
	
	/**
	 * Costruttore della classe {@code JPokeBattle}.
	 * Inizializza la finestra di gioco e aggiunge il menu principale.
	 */
	
	public JPokeBattle() {
		// Imposta il layout della finestra
		setLayout(new BorderLayout());
		
		// Crea il menu principale
		menuPrincipale = new MenuPrincipale();
		menuPrincipale.setVisible(true);
		
		// Aggiunge il menu principale alla finestra
		add(menuPrincipale, BorderLayout.CENTER);
		
		// Imposta dimensioni e posizione della finestra
		setSize(800, 500);
		setLocationRelativeTo(null);
		
		// Imposta l'operazione di chiusura
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Rende visibile la finestra
		setVisible(true);
	}	

	/**
	 * Metodo principale per avviare l'applicazione.
	 */
	
	public static void main(String[] args) {	
		new JPokeBattle();

		// Registra l'hook di shutdown
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            LeaderboardManager.shutdown();
        }));
	}
}
