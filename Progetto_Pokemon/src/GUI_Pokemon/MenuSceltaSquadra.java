package GUI_Pokemon;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.*;
import Lotta_Pokemon.*;

/**
* Classe che rappresenta il menu di selezione della squadra Pokémon da parte dell'utente.
* L'utente può scegliere tra diversi Pokémon e confermare la sua selezione per iniziare la lotta.
*/
public class MenuSceltaSquadra extends JPanel {
    
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
    
    /** Set per memorizzare l'ordine di selezione dei Pokémon */
    private Set<JCheckBox> ordineSelezione;
    
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
       /* pokemonCPU.add(new Squirtle());
        pokemonCPU.add(new Bulbasaur());
       */ 
        // Etichetta per la selezione della squadra
        labelLotta = new JLabel("Scegli i Pokémon con cui lottare:");
        labelLotta.setFont(new Font("Arial", Font.PLAIN, 30));
        labelLotta.setOpaque(true);
        labelLotta.setForeground(Color.YELLOW);
        labelLotta.setBackground(Color.BLACK);
        labelLotta.setBorder(new LineBorder(Color.WHITE, 2));
        
        // Inizializza l'ordine di selezione
        ordineSelezione = new LinkedHashSet<>();
        
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
            checkBox.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        ordineSelezione.add(checkBox);
                    } else {
                        ordineSelezione.remove(checkBox);
                    }
                }
            });
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
                
                if (!ordineSelezione.isEmpty()) {
                    
                    // Creazione della squadra dell'utente
                    List<Pokemon> pokemonUtente = new ArrayList<>();
                    for (JCheckBox checkBox : ordineSelezione) {
                        if (checkBox == Charmander) pokemonUtente.add(new Charmander());
                        if (checkBox == Squirtle) pokemonUtente.add(new Squirtle());
                        if (checkBox == Bulbasaur) pokemonUtente.add(new Bulbasaur());
                        if (checkBox == Pikachu) pokemonUtente.add(new Pikachu());
                        if (checkBox == Pidgey) pokemonUtente.add(new Pidgey());
                    }
                    
                    // Creazione della finestra di lotta
                    
                    JFrame frameMenuLotta = new JFrame("Pokémon Fight!");
                    frameMenuLotta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frameMenuLotta.setSize(frame.getSize());
                    frameMenuLotta.setLocationRelativeTo(null);
                    campoDiBattaglia = new CampoDiBattaglia(frame, frameMenuLotta, pokemonUtente, pokemonCPU);
                    frameMenuLotta.add(campoDiBattaglia);
                    frameMenuLotta.setVisible(true);
                    frame.setVisible(false);
                    
             /*        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(MenuSceltaSquadra.this);
                    frame.getContentPane().remove(MenuSceltaSquadra.this); // Rimuove il pannello corrente
                    campoDiBattaglia = new CampoDiBattaglia(frame, pokemonUtente, pokemonCPU);
                    frame.add(campoDiBattaglia); // Aggiunge il nuovo pannello
                    frame.revalidate(); // Aggiorna il layout
                    frame.repaint(); // Ridisegna il frame
            */    
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
                frame.remove(MenuSceltaSquadra.this);
                frame.add(new MenuPrincipale());
                frame.revalidate(); // Aggiorna il layout
                frame.repaint(); // Ridisegna il frame
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
        
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e){
                int width = getWidth();
                int height = getHeight();
                
                // Ridimensiona e riposiziona l'etichetta
                labelLotta.setBounds(0, 0, width, height / 10);
                labelLotta.setFont(new Font("Arial", Font.PLAIN, height / 20));
                
                // Ridimensiona e riposiziona le checkbox
                for (int i = 0; i < checkboxes.length; i++) {
                    checkboxes[i].setBounds(width / 10, height / 10 + (i * height / 10), width / 5, height / 10);
                    checkboxes[i].setFont(new Font("Arial", Font.PLAIN, height / 30));
                }
                
                // Ridimensiona e riposiziona il pulsante di conferma
                confirm.setBounds(width / 10, height / 10 * 6, width / 5, height / 10);
                confirm.setFont(new Font("Arial", Font.PLAIN, height / 30));
                
                // Ridimensiona e riposiziona il pulsante Indietro
                back.setBounds(width / 10 * 7, height / 10 * 6, width / 5, height / 10);
                back.setFont(new Font("Arial", Font.PLAIN, height / 30));
                
                // Ridimensiona e riposiziona il pulsante ESC
                ESC.setBounds(width / 10 * 7, height / 10 * 8, width / 5, height / 10);
                ESC.setFont(new Font("Arial", Font.PLAIN, height / 30));
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
