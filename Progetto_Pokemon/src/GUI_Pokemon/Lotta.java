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
	
	private List<Pokemon> pokemonUtente;
	private List<Pokemon> pokemonCPU;
	
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
	private JButton next;
	
	private JPanel areaMosse;
		
		private JButton mosse;
		private List<Mossa> listaMosseUtente;
			private JButton mossa1;
			private JButton mossa2;
			private JButton mossa3;
			private JButton mossa4;
		
		private JButton cambiaPokemon;
		
		private JButton borsa;
	
		
	private List<Mossa> listaMosseCPU;
		
	private String name;
    private int level;
    private int hp;
    private int maxHp;
	
	Lotta(List<Pokemon> pokemonUtente, List<Pokemon> pokemonCPU){
		
		this.pokemonUtente = pokemonUtente;
		this.pokemonCPU = pokemonCPU;
		
		setLayout(null);
		setBackground(Color.GRAY);
		
		if (!pokemonUtente.isEmpty() && !pokemonCPU.isEmpty()) {
	        this.attaccante = pokemonUtente.get(0);  // Primo Pokémon dell'utente
	        this.difensore = pokemonCPU.get(0);  // Primo Pokémon della CPU
	    } else {
	        System.out.println("Errore: Le liste dei Pokémon sono vuote!");
    	}
		
		
		// Sfondo pannello
		
		sfondo = new ImageIcon("C:/Users/megam/OneDrive/Desktop/sfondo lotta ridimensionato.jpg/");
		Image sfondoscalato = sfondo.getImage();
		labelSfondo = new JLabel(new ImageIcon(sfondoscalato));
		labelSfondo.setBounds(0,0,1000,600);
		add(labelSfondo);
		
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
        areaMessaggi.setBounds(570, 450, 400, 100);
        areaMessaggi.setBorder(new LineBorder(Color.WHITE, 3));
        areaMessaggi.setLayout(null);
        
        	// Testo Messaggi
        	
	        testoMessaggi = new JTextArea();
	        testoMessaggi.setEditable(false); // L'utente non può scrivere
	        testoMessaggi.setWrapStyleWord(true); // Mantiene parole intere quando va a capo
	        testoMessaggi.setBackground(Color.BLACK);
	        testoMessaggi.setForeground(Color.WHITE);
	        testoMessaggi.setFont(new Font("Arial", Font.BOLD, 12));
	        testoMessaggi.setText("INIZIA LA LOTTA!");
	        testoMessaggi.setBounds(120, 40, 200, 30);
	       
        areaMessaggi.add(testoMessaggi);
        add(areaMessaggi);
        
        // Panel area mosse
        
        Border bordoAreaMosse = new LineBorder(Color.BLACK, 3);
        areaMosse = new JPanel();
        areaMosse.setBackground(Color.GRAY);
        areaMosse.setBounds(20, 20, 400, 300);
        areaMosse.setBorder(bordoAreaMosse);
        
        areaMosse.setLayout(null);
        	
        	// Pulsante Mosse
        	
        	listaMosseUtente = attaccante.getMosse();
        
        	Border bordoMosse = new LineBorder(Color.WHITE, 3);
        	mosse = new JButton("Mosse");
        	mosse.setBackground(Color.RED);
        	mosse.setForeground(Color.WHITE);
        	mosse.setFont(new Font("Arial", Font.BOLD, 18));
        	mosse.setBorder(bordoMosse);
        	mosse.setBounds(15, 140, 370, 80);
        	
        	// Pulsanti delle mosse (inizialmente nascosti)
            mossa1 = creaPulsanteMossa();
            mossa2 = creaPulsanteMossa();
            mossa3 = creaPulsanteMossa();
            mossa4 = creaPulsanteMossa();

            // Posizioni nei quattro angoli
            mossa1.setBounds(10, 30, 180, 60);   // Alto sinistra
            mossa2.setBounds(200, 30, 180, 60);  // Alto destra
            mossa3.setBounds(10, 110, 180, 60);  // Basso sinistra
            mossa4.setBounds(200, 110, 180, 60); // Basso destra

            JButton[] pulsantiMosse = {mossa1, mossa2, mossa3, mossa4};
            
            for (JButton pulsante : pulsantiMosse) {
                pulsante.setVisible(false); // Inizialmente nascosti
                areaMosse.add(pulsante);
            }
            
        	mosse.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					mosse.setVisible(false); // Nasconde il pulsante principale

	                // Assegna le mosse ai pulsanti e li rende visibili
	                for (int i = 0; i < listaMosseUtente.size(); i++) {
	                    pulsantiMosse[i].setText(listaMosseUtente.get(i).getNomeMossa()); 
	                    pulsantiMosse[i].setVisible(true);

	                    final int index = i; // Variabile finale per ActionListener
	                    pulsantiMosse[i].addActionListener(new ActionListener() {
	                        @Override
	                        public void actionPerformed(ActionEvent e) {
	                            attaccante.usaMossa(difensore, listaMosseUtente.get(index)); // Usa la mossa selezionata
	                            mostraMessaggio(attaccante.getNome() + " usa " + listaMosseUtente.get(index).getNomeMossa());
	                        }
	                    });
	                }
	            }
			});
        	
        	areaMosse.add(mosse);
        	
        	// Pulsante next
	        
	    	next = new JButton("AVANTI");
	    	Border bordoNext = new LineBorder(Color.WHITE, 3);
	    	next.setBorder(bordoNext);
	    	next.setForeground(Color.WHITE);
	    	next.setBackground(Color.GRAY);
	    	next.setBounds(340, 70, 50, 20);
	    	
	    	next.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(difensore.esausto() == true) {
						mostraMessaggio((difensore.getNome() + "è esausto"));
						cambiaPokemonCPU();
						mostraMessaggio("Scende in campo " + difensore.getNome());
						labelPokemonDif.setText(difensore.getNome());
					}else {
						if()
					}
				}
			});
	    	
	    	areaMessaggi.add(next);
        	
        	// Pulsante cambia Pokemon
        	
        	Border bordoCambio = new LineBorder(Color.WHITE, 3);
        	cambiaPokemon = new JButton("Cambia Pokémon");
        	cambiaPokemon.setBackground(Color.GREEN);
        	cambiaPokemon.setForeground(Color.WHITE);
        	cambiaPokemon.setFont(new Font("Arial", Font.BOLD, 14));
        	cambiaPokemon.setBorder(bordoCambio);
        	cambiaPokemon.setBounds(15, 230, 160, 50);
        	
        	areaMosse.add(cambiaPokemon);
        	
        	// Pulsante borsa
        	
        	Border bordoBorsa = new LineBorder(Color.WHITE, 3);
        	borsa = new JButton("Borsa");
        	borsa.setBackground(Color.ORANGE);
        	borsa.setForeground(Color.WHITE);
        	borsa.setFont(new Font("Arial", Font.BOLD, 14));
        	borsa.setBorder(bordoBorsa);
        	borsa.setBounds(220, 230, 165, 50);
        	
        	areaMosse.add(borsa);
        	
        	add(areaMosse);
        
       
        
        
        setComponentZOrder(labelSfondo, getComponentCount() - 1);
              
	}
	
	public void mostraMessaggio(String messaggio) {
	    testoMessaggi.setText(messaggio);
	}
	
	// Metodo per creare un pulsante mossa con lo stile desiderato
    private JButton creaPulsanteMossa() {
        JButton button = new JButton();
        button.setBackground(Color.RED);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBorder(new LineBorder(Color.WHITE, 3));
        return button;
    }
	
    public void cambiaPokemonCPU() {
    	if (!pokemonCPU.isEmpty()) {
            pokemonCPU.remove(0); // Rimuove il Pokémon sconfitto
            if (!pokemonCPU.isEmpty()) {
                this.difensore = pokemonCPU.get(0); // Imposta il nuovo Pokémon avversario
                System.out.println("Il nuovo Pokémon avversario è: " + difensore.getNome());
            } else {
                System.out.println("L'avversario non ha più Pokémon disponibili! Hai vinto!");
            }
        }
    }
}

