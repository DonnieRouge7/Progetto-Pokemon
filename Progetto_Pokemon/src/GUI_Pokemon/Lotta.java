package GUI_Pokemon;

import Lotta_Pokemon.Pokemon;
import Lotta_Pokemon.Mossa;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List; 
import java.awt.*;
import java.awt.image.AreaAveragingScaleFilter;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Lotta extends JPanel{
	
	private Pokemon attaccante;
	private Pokemon difensore;
	
	private ImageIcon sfondo;
	private JLabel labelSfondo;
	
	private JProgressBar healthBar;
	private int health = 100;
	
	private JProgressBar healthBar2;
	private int health2 = 100;

	private Border bordoHealthBar;
	
	private JLabel labelPokemonAtt;
	private JPanel areaPokemonAtt;
	
	private JLabel labelPokemonDif;
	private JPanel areaPokemonDif;
	
	private JPanel areaMessaggi;
	private JTextArea testoMessaggi;
	
	private String name;
    private int level;
    private int hp;
    private int maxHp;
	
	Lotta(List<Pokemon> pokemonUtente, List<Pokemon> pokemonCPU){
		
		setLayout(null);
		setBackground(Color.GRAY);
		
		// Sfondo pannello
		
		sfondo = new ImageIcon("C:/Users/megam/OneDrive/Desktop/sfondo lotta ridimensionato.jpg/");
		Image sfondoscalato = sfondo.getImage();
		labelSfondo = new JLabel(new ImageIcon(sfondoscalato));
		labelSfondo.setBounds(0,0,1000,600);
		add(labelSfondo);
		
		// HealthBarCPU
		
		bordoHealthBar = new LineBorder(Color.BLACK);
		
		healthBar = new JProgressBar(0, 100);
        healthBar.setValue(health);
        healthBar.setStringPainted(true); // Mostra il valore numerico
        
        healthBar.setForeground(Color.GREEN);
        healthBar.setBorder(bordoHealthBar);
        
        // Imposta colori della barra al variare della vita
        
        if(health <= 70) {
        	healthBar.setForeground(Color.ORANGE);
        	if(health <= 20) {
        		healthBar.setForeground(Color.RED);
        	}
        }
        
        healthBar.setBackground(Color.WHITE);
        healthBar.setBounds(750, 130, 200, 20);
        add(healthBar);
        
        // HealthBarUtente
		
		healthBar2 = new JProgressBar(0, 100);
        healthBar2.setValue(health2);
        healthBar2.setStringPainted(true); // Mostra il valore numerico
        
        healthBar2.setForeground(Color.GREEN);
        healthBar2.setBorder(bordoHealthBar);
        
        // **
        
        if(health2 <= 70) {
        	healthBar2.setForeground(Color.ORANGE);
        	if(health2 <= 20) {
        		healthBar2.setForeground(Color.RED);
        	}
        }
        
        healthBar2.setBackground(Color.WHITE);
        healthBar2.setBounds(30, 420, 200, 20);
        add(healthBar2);
        
        // Area messaggi durante la lotta
        
        areaMessaggi = new JPanel();
        areaMessaggi.setBackground(Color.BLACK);
        areaMessaggi.setBounds(570, 400, 400, 150);
        areaMessaggi.setBorder(new LineBorder(Color.WHITE, 2));
        
        testoMessaggi = new JTextArea();
        testoMessaggi.setEditable(false); // L'utente non può scrivere
        testoMessaggi.setLineWrap(true);  // Testo va a capo automaticamente
        testoMessaggi.setWrapStyleWord(true); // Mantiene parole intere quando va a capo
        testoMessaggi.setBackground(Color.BLACK);
        testoMessaggi.setForeground(Color.WHITE);
        testoMessaggi.setFont(new Font("Arial", Font.BOLD, 18));
        
        areaMessaggi.add(testoMessaggi);
        add(areaMessaggi);
        
        // Inizio lotta
        
        if (!pokemonUtente.isEmpty() && !pokemonCPU.isEmpty()) {
	        this.attaccante = pokemonUtente.get(0);  // Primo Pokémon dell'utente
	        this.difensore = pokemonCPU.get(0);  // Primo Pokémon della CPU
	    } else {
	        System.out.println("Errore: Le liste dei Pokémon sono vuote!");
	    }
        
        // Pokemon utente
        
        areaPokemonAtt = new JPanel();
        Border bordo = new LineBorder(Color.WHITE);
        areaPokemonAtt.setBackground(Color.BLACK);
        areaPokemonAtt.setBounds(30, 390, 200, 30);
        areaPokemonAtt.setBorder(bordo);
        
        labelPokemonAtt = new JLabel(attaccante.getNome());
        labelPokemonAtt.setForeground(Color.WHITE);
        
        areaPokemonAtt.add(labelPokemonAtt);
        add(areaPokemonAtt);
        
        // Pokemon CPU
        
        areaPokemonDif = new JPanel();
        Border bordo2 = new LineBorder(Color.WHITE);
        areaPokemonDif.setBackground(Color.BLACK);
        areaPokemonDif.setBounds(750, 100, 200, 30);
        areaPokemonDif.setBorder(bordo2);
        
        labelPokemonDif = new JLabel(difensore.getNome());
        labelPokemonDif.setForeground(Color.WHITE);
        
        areaPokemonDif.add(labelPokemonDif);
        add(areaPokemonDif);
        
        
        setComponentZOrder(labelSfondo, getComponentCount() - 1);
              
	}
	
	public void mostraMessaggio(String messaggio) {
	    testoMessaggi.setText(messaggio);
	}
}

