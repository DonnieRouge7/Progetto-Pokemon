package GUI_Pokemon;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class SchermataStart extends JPanel{

	private JButton bottoneStart; 
	private JButton bottoneEsc;
	private JFrame frameLotta;
	private SchermataLotta schermataLotta;
	private JLabel campoBenvenuto;
	private JTextField testoBenvenuto;
	private JLabel labelSfondo;
	private ImageIcon sfondo;
	private JLabel labelScore;
	private JTextField fieldScore;
	
	private GUI_Pokemon.FormListener formListener; 
	
	SchermataStart(){	
		
		setLayout(null);
		
		// Sfondo Pannello
		
		sfondo = new ImageIcon("C://Users//megam//OneDrive//Desktop//thumb-1920-1243956.jpg");
		Image sfondoScalato = sfondo.getImage();
		Image immagineScalata = sfondoScalato.getScaledInstance(1200, 1000, Image.SCALE_SMOOTH);
		labelSfondo = new JLabel(new ImageIcon(immagineScalata));
		labelSfondo.setBounds(0, 0, 1000, 1000);
		add(labelSfondo);
		
		// Bordi
		
		Border bordoCampoBenvenuto = new LineBorder(Color.WHITE, 2, true);
		Border bordoStart = new LineBorder(Color.WHITE, 2, true);
		Border bordoEsc = new LineBorder(Color.WHITE, 2, true);
		Border bordoScore = new TitledBorder("Migliori Score");
		((TitledBorder) bordoScore).setTitleColor(Color.YELLOW);
		
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
				
				frameLotta = new JFrame("Menù di Lotta");
				
				schermataLotta = new SchermataLotta(frameLotta);
				
				frameLotta.add(schermataLotta);
				
				frameLotta.setSize(new Dimension(1000, 600));
				frameLotta.setLocationRelativeTo(null);
				frameLotta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frameLotta.setVisible(true);
		
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
		
		campoBenvenuto = new JLabel("Welcome to Pokemon Fight!");
		campoBenvenuto.setForeground(Color.YELLOW);
		campoBenvenuto.setFont(new Font("Times New Roman", Font.PLAIN, 50));
		campoBenvenuto.setBounds(110, 10, 600, 100);
        add(campoBenvenuto);
        
        // TextField Benvenuto
        
        testoBenvenuto = new JTextField();
        testoBenvenuto.setBounds(100, 10, 600, 100);
        testoBenvenuto.setBackground(Color.BLUE);
        testoBenvenuto.setBorder(bordoCampoBenvenuto);
        add(testoBenvenuto);
        
        // Label Score
        
        labelScore = new JLabel();
        labelScore.setBounds(0, 150, 200, 300);
        add(labelScore);
        
        // Testo Score
        
        fieldScore = new JTextField();
        fieldScore.setBounds(30, 150, 200, 300);
        fieldScore.setBackground(Color.BLUE);
        fieldScore.setBorder(bordoScore);
        add(fieldScore);
        
        // Porta il JLabel dello sfondo in fondo
        setComponentZOrder(labelSfondo, getComponentCount() - 1);

        // Revalidate e Repaint
        revalidate();
        repaint();
		
        // Layout
        
		/* GridBagConstraints gbc = new GridBagConstraints();
		
		//Posizione Menù Welcome
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		
		gbc.weightx = 0.01;
		gbc.weighty = 0.01;
		
		gbc.anchor = GridBagConstraints.CENTER;
		
		gbc.insets = new Insets(0, 0, 0, 0);
		
		add(campoBenvenuto, gbc);
		
		// Posizione Bottone Start
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		
		gbc.weightx = 0.01;
		gbc.weighty = 0.01;
		
		gbc.anchor = GridBagConstraints.CENTER;
		
		gbc.insets = new Insets(0, 0, 0, 0);
		
		add(bottoneStart, gbc);
		
		// Posizione Bottone Esc
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		
		gbc.weightx = 0.01;
		gbc.weighty = 0.01;
		
		gbc.anchor = GridBagConstraints.LAST_LINE_END;
		
		gbc.insets = new Insets(0, 0, 0, 0);
		
		add(bottoneEsc, gbc);
		
		*/
	}

	public void setFormListener(FormListener formListener) {
		this.formListener = formListener;
	}
}
