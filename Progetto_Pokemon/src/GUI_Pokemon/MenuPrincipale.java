package GUI_Pokemon;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class MenuPrincipale extends JPanel{
	
	private JButton bottoneStart; 
	private JButton bottoneEsc;
	
	private JFrame menuLotta;
	private MenuSceltaSquadra menuSceltaSquadra;
	
	private JLabel labelBenvenuto;
	private JTextField fieldBenvenuto;
	
	private JLabel labelSfondo;
	private ImageIcon sfondo;
	
	private AudioPlayer audioPlayer;
		
	MenuPrincipale(){	
		
		setLayout(null);
		
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
		
		bottoneStart = new JButton("START");
		bottoneStart.setBackground(Color.BLUE);
		bottoneStart.setForeground(Color.YELLOW);
		bottoneStart.setBounds(300, 200, 200, 100);
		bottoneStart.setFont(new Font("Arial", Font.PLAIN, 40));
		bottoneStart.setBorder(bordoStart);
		
		bottoneStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				bottoneEsc.setEnabled(false);
				
				menuLotta = new JFrame("Menù di Lotta");
				
				menuSceltaSquadra = new MenuSceltaSquadra(menuLotta, audioPlayer);
				
				menuLotta.add(menuSceltaSquadra);
				
				menuLotta.setSize(new Dimension(1000, 600));
				menuLotta.setLocationRelativeTo(null);
				menuLotta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				menuLotta.setVisible(true);
			}
		});
		
		add(bottoneStart);
		
		// Button Esc
		
		bottoneEsc = new JButton("ESCI");
		bottoneEsc.setBackground(Color.BLUE);
		bottoneEsc.setForeground(Color.YELLOW);
		bottoneEsc.setFont(new Font("Arial", Font.PLAIN, 20));
		bottoneEsc.setBounds(680, 410, 80, 40);
		bottoneEsc.setBorder(bordoEsc);
		
		bottoneEsc.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		add(bottoneEsc);
		
		// Label Benvenuto
		
		labelBenvenuto = new JLabel("Welcome to Pokemon Fight!");
		labelBenvenuto.setForeground(Color.YELLOW);
		labelBenvenuto.setFont(new Font("Times New Roman", Font.PLAIN, 50));
		labelBenvenuto.setBounds(110, 10, 600, 100);
        add(labelBenvenuto);
        
        // TextField Benvenuto
        
        fieldBenvenuto = new JTextField();
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
