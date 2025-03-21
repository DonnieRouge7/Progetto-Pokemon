package GUI_Pokemon;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

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
     * 
     * @param frameMenuPrincipale Il frame che contiene il menu principale.
     */
    public MenuPrincipale() {

        // Imposta il layout del pannello
        setLayout(null);

        // Audio
        audioPlayer = new AudioPlayer();
        java.net.URL audioURL = getClass().getClassLoader().getResource("assets/pokemonTheme.wav");
        audioPlayer.playMusic(audioURL.getPath());

        // Sfondo Pannello
        java.net.URL imgURL = getClass().getClassLoader().getResource("assets/sfondoSchermataPrincipale.jpg");
        sfondo = new ImageIcon(imgURL);
        labelSfondo = new JLabel();
        labelSfondo.setBounds(0, 0, getWidth(), getHeight());
        add(labelSfondo);

        // Bordi
        Border bordoFieldBenvenuto = new LineBorder(Color.WHITE, 2, true);
        Border bordoStart = new LineBorder(Color.WHITE, 2, true);
        Border bordoEsc = new LineBorder(Color.WHITE, 2, true);

        // Button Start
        buttonStart = new JButton("START");
        buttonStart.setBackground(Color.BLUE);
        buttonStart.setForeground(Color.YELLOW);
        buttonStart.setFont(new Font("Arial", Font.PLAIN, 40));
        buttonStart.setBorder(bordoStart);
        add(buttonStart);

        // Button Esc
        buttonEsc = new JButton("ESCI");
        buttonEsc.setBackground(Color.BLUE);
        buttonEsc.setForeground(Color.YELLOW);
        buttonEsc.setFont(new Font("Arial", Font.PLAIN, 20));
        buttonEsc.setBorder(bordoEsc);
        add(buttonEsc);

        // Label Benvenuto
        labelBenvenuto = new JLabel("Welcome to Pokémon Fight!");
        labelBenvenuto.setForeground(Color.YELLOW);
        labelBenvenuto.setFont(new Font("Times New Roman", Font.PLAIN, 50));
        add(labelBenvenuto);

        // TextField Benvenuto
        fieldBenvenuto = new JTextArea();
        fieldBenvenuto.setEditable(false);
        fieldBenvenuto.setBackground(Color.BLUE);
        fieldBenvenuto.setBorder(bordoFieldBenvenuto);
        add(fieldBenvenuto);

        setComponentZOrder(labelSfondo, getComponentCount() - 1);

        // Listener per il ridimensionamento
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int width = getWidth();
                int height = getHeight();

                // Ridimensiona e riposiziona lo sfondo
                Image sfondoScalato = sfondo.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
                labelSfondo.setIcon(new ImageIcon(sfondoScalato));
                labelSfondo.setBounds(0, 0, width, height);

                // Riposiziona e ridimensiona il bottone START
                int buttonStartWidth = width / 5;
                int buttonStartHeight = height / 7;
                int buttonStartX = (width - buttonStartWidth) / 2;
                int buttonStartY = (height / 2) - (buttonStartHeight / 2);
                buttonStart.setBounds(buttonStartX, buttonStartY, buttonStartWidth, buttonStartHeight);
                buttonStart.setFont(new Font("Arial", Font.PLAIN, height / 20));

                // Riposiziona e ridimensiona il bottone ESC
                int buttonEscWidth = width / 10;
                int buttonEscHeight = height / 15;
                int buttonEscX = (int) (width * 0.8);
                int buttonEscY = (int) (height * 0.8);
                buttonEsc.setBounds(buttonEscX, buttonEscY, buttonEscWidth, buttonEscHeight);
                buttonEsc.setFont(new Font("Arial", Font.PLAIN, height / 30));

                // Riposiziona e ridimensiona la label di benvenuto
                int labelBenvenutoWidth = (int) (width / 2.2);
                int labelBenvenutoHeight = height / 10;
                int labelBenvenutoX = (width - labelBenvenutoWidth) / 2; // Centra orizzontalmente
                int labelBenvenutoY = height / 20; // Posiziona in alto
                labelBenvenuto.setBounds(labelBenvenutoX, labelBenvenutoY, labelBenvenutoWidth, labelBenvenutoHeight);
                labelBenvenuto.setFont(new Font("Times New Roman", Font.PLAIN, height / 15));

                // Riposiziona e ridimensiona il campo di testo di benvenuto
                fieldBenvenuto.setBounds(labelBenvenutoX - 10, labelBenvenutoY - 10, labelBenvenutoWidth + 20, labelBenvenutoHeight + 20);
            }
        });

        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(MenuPrincipale.this);
                frame.getContentPane().remove(MenuPrincipale.this); // Rimuove il pannello corrente
                menuSceltaSquadra = new MenuSceltaSquadra(frame, audioPlayer);
                frame.add(menuSceltaSquadra); // Aggiunge il nuovo pannello
                frame.revalidate(); // Aggiorna il layout
                frame.repaint(); // Ridisegna il frame
            }
        });

        buttonEsc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LeaderboardManager.azzeraLeaderboard();
                System.exit(0);
            }
        });

        revalidate();
        repaint();
    }
}