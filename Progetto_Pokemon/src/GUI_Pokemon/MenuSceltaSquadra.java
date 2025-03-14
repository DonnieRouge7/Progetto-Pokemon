package GUI_Pokemon;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.*;
import Lotta_Pokemon.*;

<<<<<<< HEAD
public class MenuSceltaSquadra extends JPanel{
	
	private JFrame frameMenuLotta;
 	
	private AudioPlayer audioPlayer;
	
 	private CampoDiBattaglia campoDiBattaglia;
 	
 	private JLabel labelLotta;
	
	private JCheckBox Charmander;
	private JCheckBox Squirtle;
	private JCheckBox Bulbasaur;
	private JCheckBox Pikachu;
	private JCheckBox Pidgey;
	
	private JButton confirm;
	private JButton back;
	private JButton ESC;
	
	// Costruttore che accetta un riferimento al frame
	MenuSceltaSquadra(JFrame frame, AudioPlayer audioPlayer) {
		
		this.audioPlayer = audioPlayer;
		
		setLayout(new GridBagLayout());
		
		Border bordo = new LineBorder(Color.WHITE);
		
		setBorder(bordo);
		
		setBackground(Color.BLUE);
		
		// Creazione squadra CPU
		
		List<Pokemon> pokemonCPU = new ArrayList<>();
		
		pokemonCPU.add(new Charmander());
		pokemonCPU.add(new Bulbasaur());
		pokemonCPU.add(new Squirtle());
		 
		// Label Lotta
		
		labelLotta = new JLabel("Scegli i pokemon con cui lottare:");
		labelLotta.setFont(new Font("Arial", Font.PLAIN, 30));
		labelLotta.setOpaque(true);
		labelLotta.setForeground(Color.YELLOW);
		labelLotta.setBackground(Color.BLACK);
		Border bordoLabelLotta = new LineBorder(Color.WHITE, 2);
		labelLotta.setBorder(bordoLabelLotta);
		
		// CheckBox Pokemon 
		
		Charmander = new JCheckBox("Charmander");
		Charmander.setBackground(Color.BLUE);
		Charmander.setForeground(Color.YELLOW);
		
		Squirtle = new JCheckBox("Squirtle");
		Squirtle.setBackground(Color.BLUE);
		Squirtle.setForeground(Color.YELLOW);
		
		Bulbasaur = new JCheckBox("Bulbasaur");
		Bulbasaur.setBackground(Color.BLUE);
		Bulbasaur.setForeground(Color.YELLOW);
		
		Pikachu = new JCheckBox("Pikachu");
		Pikachu.setBackground(Color.BLUE);
		Pikachu.setForeground(Color.YELLOW);
		
		Pidgey = new JCheckBox("Pidgey");
		Pidgey.setBackground(Color.BLUE);
		Pidgey.setForeground(Color.YELLOW);
		
		// Button confirm
		
		confirm = new JButton("Conferma");
		confirm.setForeground(Color.YELLOW);
		confirm.setBackground(Color.BLACK);
		confirm.setFont(new Font("Arial", Font.PLAIN, 20));
		
		confirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Charmander.isSelected() || Squirtle.isSelected() || Bulbasaur.isSelected() || Pikachu.isSelected()) {
					
					// Creazione squadra utente
					
					List<Pokemon> pokemonUtente = new ArrayList<>(5);
					
					if(Charmander.isSelected()) pokemonUtente.add(new Charmander());
					if(Bulbasaur.isSelected()) pokemonUtente.add(new Bulbasaur());
					if(Squirtle.isSelected()) pokemonUtente.add(new Squirtle());
					if(Pikachu.isSelected()) pokemonUtente.add(new Pikachu());
					if(Pidgey.isSelected()) pokemonUtente.add(new Pidgey());
					
					frameMenuLotta = new JFrame("Lotta");
					
					campoDiBattaglia = new CampoDiBattaglia(frameMenuLotta, pokemonUtente, pokemonCPU);
					
					frameMenuLotta.add(campoDiBattaglia);
					
					frameMenuLotta.setSize(new Dimension(1000, 600));
					frameMenuLotta.setLocationRelativeTo(null);
					frameMenuLotta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frameMenuLotta.setVisible(true);
					
					audioPlayer.stopMusic();
					
				}else {
					try {
			            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			        } catch (Exception e1) {
			            e1.printStackTrace();
			        }

			        JOptionPane.showMessageDialog(null, "Seleziona almeno un Pokemon!");
				}
			}
		});
		
		// Button back
		
		back = new JButton("Indietro");
		back.setForeground(Color.YELLOW);
		back.setBackground(Color.BLACK);
		back.setFont(confirm.getFont());
		
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
		// Button ESC
		
		ESC = new JButton("ESCI");
		ESC.setForeground(Color.YELLOW);
		ESC.setBackground(Color.BLACK);
		ESC.setFont(confirm.getFont());
		
		ESC.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		/* Layout Lotta */
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		
		gbc.anchor = GridBagConstraints.CENTER;
		
		gbc.insets = new Insets(0, 0, 0, 0);
		
		add(labelLotta, gbc);
		
		// Layout CheckBox Charmander
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		
		gbc.anchor = GridBagConstraints.LINE_START;
		
		gbc.insets = new Insets(10, 0, 0, 0);
		
		add(Charmander, gbc);
		
		// Layout CheckBox Squirtle
				
		gbc.gridx = 0;
		gbc.gridy = 2;
		
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
				
		gbc.anchor = GridBagConstraints.LINE_START;
				
		gbc.insets = new Insets(10, 0, 0, 0);
				
		add(Squirtle, gbc);
		
		// Layout ChechBox Bulbasaur
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
				
		gbc.anchor = GridBagConstraints.LINE_START;
				
		gbc.insets = new Insets(10, 0, 0, 0);
				
		add(Bulbasaur, gbc);
		
		// Layout ChechBox Pikachu
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
				
		gbc.anchor = GridBagConstraints.LINE_START;
				
		gbc.insets = new Insets(10, 0, 0, 0);
				
		add(Pikachu, gbc);
		
		// Layout ChechBox Pidgey
		
		gbc.gridx = 0;
		gbc.gridy = 5;
		
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
				
		gbc.anchor = GridBagConstraints.LINE_START;
				
		gbc.insets = new Insets(10, 0, 0, 0);
				
		add(Pidgey, gbc);
		
		// Button confirm
		
		gbc.gridx = 0;
		gbc.gridy = 6;
		
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
				
		gbc.anchor = GridBagConstraints.LINE_START;
				
		gbc.insets = new Insets(20, 0, 0, 0);
				
		add(confirm, gbc);
		
		// Button back
		
		gbc.gridx = 0;
		gbc.gridy = 6;
		
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
				
		gbc.anchor = GridBagConstraints.CENTER;
				
		gbc.insets = new Insets(20, 0, 0, 0);
				
		add(back, gbc);
		
		// Button ESC
		
		gbc.gridx = 0;
		gbc.gridy = 6;
		
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
				
		gbc.anchor = GridBagConstraints.LINE_END;
				
		gbc.insets = new Insets(20, 0, 0, 0);
				
		add(ESC, gbc);
	}
	
	public int generaInteroCasuale(int a, int b) {
		Random interoCasuale = new Random(); 
		return interoCasuale.nextInt((b - a) + 1) + a;
	}
=======
/**
 * Classe che rappresenta il menu di selezione della squadra Pokémon da parte dell'utente.
 * L'utente può scegliere tra diversi Pokémon e confermare la sua selezione per iniziare la lotta.
 */
public class MenuSceltaSquadra extends JPanel {
    
    /** Il frame della finestra del menu di lotta */
    private JFrame frameMenuLotta;
    
    /** Il pannello che rappresenta il campo di battaglia */
    private CampoDiBattaglia campoDiBattaglia;
    
    /** Etichetta che mostra il titolo della selezione */
    private JLabel labelLotta;
    
    /** Checkbox per la selezione del Pokémon Charmander */
    private JCheckBox Charmander;
    
    /** Checkbox per la selezione del Pokémon Squirtle */
    private JCheckBox Squirtle;
    
    /** Checkbox per la selezione del Pokémon Bulbasaur */
    private JCheckBox Bulbasaur;
    
    /** Checkbox per la selezione del Pokémon Pikachu */
    private JCheckBox Pikachu;
    
    /** Checkbox per la selezione del Pokémon Pidgey */
    private JCheckBox Pidgey;
    
    /** Pulsante per confermare la selezione e iniziare la lotta */
    private JButton confirm;
    
    /** Pulsante per tornare al menu precedente */
    private JButton back;
    
    /** Pulsante per uscire dal gioco e azzerare la leaderboard */
    private JButton ESC;
>>>>>>> 9ccb2dfefe5bdb0ad0937017e02b4abd8e6e246e

    /**
     * Costruttore della classe MenuSceltaSquadra.
     * 
     * @param frame il frame della finestra che contiene il menu
     * @param audioPlayer il gestore della musica per controllare l'audio di sottofondo
     */
    
    public MenuSceltaSquadra(JFrame frame, AudioPlayer audioPlayer) {
        
        setLayout(new GridBagLayout());
        setBorder(new LineBorder(Color.WHITE));
        setBackground(Color.BLUE);
        
        // Creazione della squadra della CPU
        List<Pokemon> pokemonCPU = new ArrayList<>();
        pokemonCPU.add(new Charmander());
       /*  pokemonCPU.add(new Bulbasaur());
        pokemonCPU.add(new Squirtle());
        */
        // Etichetta per la selezione della squadra
        labelLotta = new JLabel("Scegli i Pokémon con cui lottare:");
        labelLotta.setFont(new Font("Arial", Font.PLAIN, 30));
        labelLotta.setOpaque(true);
        labelLotta.setForeground(Color.YELLOW);
        labelLotta.setBackground(Color.BLACK);
        labelLotta.setBorder(new LineBorder(Color.WHITE, 2));
        
        // Checkbox per la selezione dei Pokémon
        Charmander = new JCheckBox("Charmander");
        Squirtle = new JCheckBox("Squirtle");
        Bulbasaur = new JCheckBox("Bulbasaur");
        Pikachu = new JCheckBox("Pikachu");
        Pidgey = new JCheckBox("Pidgey");
        
        JCheckBox[] checkboxes = {Charmander, Squirtle, Bulbasaur, Pikachu, Pidgey};
        for (JCheckBox checkBox : checkboxes) {
            checkBox.setBackground(Color.BLUE);
            checkBox.setForeground(Color.YELLOW);
        }
        
        // Pulsante di conferma
        confirm = new JButton("Conferma");
        confirm.setForeground(Color.YELLOW);
        confirm.setBackground(Color.BLACK);
        confirm.setFont(new Font("Arial", Font.PLAIN, 20));
        
        // ActionListener per il pulsante di conferma
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Charmander.isSelected() || Squirtle.isSelected() || Bulbasaur.isSelected() || Pikachu.isSelected() || Pidgey.isSelected()) {
                    
                    // Creazione della squadra dell'utente
                    List<Pokemon> pokemonUtente = new ArrayList<>();
                    if (Charmander.isSelected()) pokemonUtente.add(new Charmander());
                    if (Squirtle.isSelected()) pokemonUtente.add(new Squirtle());
                    if (Bulbasaur.isSelected()) pokemonUtente.add(new Bulbasaur());
                    if (Pikachu.isSelected()) pokemonUtente.add(new Pikachu());
                    if (Pidgey.isSelected()) pokemonUtente.add(new Pidgey());
                    
                    // Creazione della finestra di lotta
                    frameMenuLotta = new JFrame("Lotta");
                    campoDiBattaglia = new CampoDiBattaglia(frameMenuLotta, pokemonUtente, pokemonCPU);
                    frameMenuLotta.add(campoDiBattaglia);
                    frameMenuLotta.setSize(new Dimension(1000, 600));
                    frameMenuLotta.setLocationRelativeTo(null);
                    frameMenuLotta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frameMenuLotta.setVisible(true);
                    
                    // Ferma la musica attuale
                    audioPlayer.stopMusic();
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Seleziona almeno un Pokémon!");
                }
            }
        });
        
        // Pulsante Indietro
        back = new JButton("Indietro");
        back.setForeground(Color.YELLOW);
        back.setBackground(Color.BLACK);
        back.setFont(confirm.getFont());
        
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        
        // Pulsante ESC
        ESC = new JButton("ESCI");
        ESC.setForeground(Color.YELLOW);
        ESC.setBackground(Color.BLACK);
        ESC.setFont(confirm.getFont());
        
        ESC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LeaderboardManager.azzeraLeaderboard();
                System.exit(0);
            }
        });
        
        // Layout dei componenti
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        add(labelLotta, gbc);
        
        for (int i = 0; i < checkboxes.length; i++) {
            gbc.gridy = i + 1;
            gbc.anchor = GridBagConstraints.LINE_START;
            add(checkboxes[i], gbc);
        }
        
        gbc.gridy = checkboxes.length + 1;
        add(confirm, gbc);
        
        gbc.anchor = GridBagConstraints.CENTER;
        add(back, gbc);
        
        gbc.anchor = GridBagConstraints.LINE_END;
        add(ESC, gbc);
    }
    
    /**
     * Genera un numero intero casuale tra due valori dati.
     * 
     * @param a valore minimo
     * @param b valore massimo
     * @return un numero intero casuale tra a e b
     */
    
    public int generaInteroCasuale(int a, int b) {
        Random interoCasuale = new Random(); 
        return interoCasuale.nextInt((b - a) + 1) + a;
    }
}
