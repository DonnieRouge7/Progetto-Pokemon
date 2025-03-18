package GUI_Pokemon;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 * Classe che rappresenta il menu principale del gioco Pokémon.
 * Il menu permette di avviare una nuova lotta o uscire dal gioco.
 */
public class MenuPrincipale extends JPanel {
    
    /** Bottone per avviare la partita */
    private JButton buttonStart; 
    
    /** Bottone per uscire dal gioco */
    private JButton buttonEsc;
    
    /** Finestra del menu di lotta */
    private JFrame menuLotta;
    
    /** Pannello per la scelta della squadra */
    private MenuSceltaSquadra menuSceltaSquadra;
    
    /** Etichetta per il messaggio di benvenuto */
    private JLabel labelBenvenuto;
    
    /** Campo di testo per il messaggio di benvenuto */
    private JTextArea fieldBenvenuto;
    
    /** Etichetta per l'immagine di sfondo */
    private JLabel labelSfondo;
    
    /** Icona per lo sfondo del menu */
    private ImageIcon sfondo;
    
    /** Lettore audio per la musica di sottofondo */
    private AudioPlayer audioPlayer;

    /**
     * Costruttore della classe {@code MenuPrincipale}.
     * Inizializza i componenti grafici del menu principale e avvia la musica di sottofondo.
     */
    
    public MenuPrincipale() {    
        setLayout(null);
        
        // Audio 
        audioPlayer = new AudioPlayer();
        audioPlayer.playMusic("C:/Users/megam/eclipse-workspace/Progetto-Pokemon-Git/Progetto-Pokemon/Pokemon [Gotta Catch Em All] - Giorgio Vanni (Sigla Completa).wav");
        
        // Sfondo Pannello 
        sfondo = new ImageIcon("C:/Users/megam/eclipse-workspace/Progetto-Pokemon-Git/Progetto-Pokemon/sfondo schermata principale.jpg");
        Image sfondoScalato = sfondo.getImage();
        Image immagineScalata = sfondoScalato.getScaledInstance(1200, 1000, Image.SCALE_SMOOTH);
        labelSfondo = new JLabel(new ImageIcon(immagineScalata));
        labelSfondo.setBounds(0, 0, 1000, 1000);
        add(labelSfondo);
        
        // Bordi 
        Border bordoFieldBenvenuto = new LineBorder(Color.WHITE, 2, true);
        Border bordoStart = new LineBorder(Color.WHITE, 2, true);
        Border bordoEsc = new LineBorder(Color.WHITE, 2, true);
        
        // Button Start 
        buttonStart = new JButton("START");
        buttonStart.setBackground(Color.BLUE);
        buttonStart.setForeground(Color.YELLOW);
        buttonStart.setBounds(300, 200, 200, 100);
        buttonStart.setFont(new Font("Arial", Font.PLAIN, 40));
        buttonStart.setBorder(bordoStart);
        
        /**
         * ActionListener per il bottone START.
         * Quando premuto, disabilita i pulsanti e apre il menu di scelta della squadra.
         */
        
        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonEsc.setEnabled(false);
                buttonStart.setEnabled(false);
                
                menuLotta = new JFrame("Menù di Lotta");
                
                menuSceltaSquadra = new MenuSceltaSquadra(menuLotta, audioPlayer);
                
                menuLotta.add(menuSceltaSquadra);
                menuLotta.setSize(new Dimension(1000, 600));
                menuLotta.setLocationRelativeTo(null);
                menuLotta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                menuLotta.setVisible(true);
            }
        });
        
        add(buttonStart);
        
        // Button Esc 
        buttonEsc = new JButton("ESCI");
        buttonEsc.setBackground(Color.BLUE);
        buttonEsc.setForeground(Color.YELLOW);
        buttonEsc.setFont(new Font("Arial", Font.PLAIN, 20));
        buttonEsc.setBounds(680, 410, 80, 40);
        buttonEsc.setBorder(bordoEsc);
        
        /**
         * ActionListener per il bottone ESCI.
         * Quando premuto, azzera la leaderboard e chiude il gioco.
         */
        
        buttonEsc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LeaderboardManager.azzeraLeaderboard();
                System.exit(0);
            }
        });
        
        add(buttonEsc);
        
        // Label Benvenuto 
        labelBenvenuto = new JLabel("Welcome to Pokémon Fight!");
        labelBenvenuto.setForeground(Color.YELLOW);
        labelBenvenuto.setFont(new Font("Times New Roman", Font.PLAIN, 50));
        labelBenvenuto.setBounds(110, 10, 600, 100);
        add(labelBenvenuto);
        
        // TextField Benvenuto 
        fieldBenvenuto = new JTextArea();
        fieldBenvenuto.setEditable(false);
        fieldBenvenuto.setBounds(100, 10, 600, 100);
        fieldBenvenuto.setBackground(Color.BLUE);
        fieldBenvenuto.setBorder(bordoFieldBenvenuto);
        add(fieldBenvenuto);
        
        // Porta il JLabel dello sfondo in fondo 
        setComponentZOrder(labelSfondo, getComponentCount() - 1);
        
        // Revalidate e Repaint 
        revalidate();
        repaint();
    }
}
