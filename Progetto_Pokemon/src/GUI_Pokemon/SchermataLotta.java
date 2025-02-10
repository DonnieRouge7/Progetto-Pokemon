package GUI_Pokemon;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.border.*;
import Lotta_Pokemon.*;

public class SchermataLotta extends JPanel{
	
 	private JFrame frame;
 	private JFrame lottaFrame;
 	
 	private Lotta lotta;
 	
 	private Bulbasaur bulbasaur;
 	private Pikachu pikachu;
 	private Charmander charmander;
 	private Squirtle squirtle;
 	
 	private JLabel labelLotta;
	
	private JLabel labelCharmander;
	private JCheckBox Charmander;
	
	private JLabel labelSquirtle;
	private JCheckBox Squirtle;
	
	private JLabel labelBulbasaur;
	private JCheckBox Bulbasaur;
	
	private JButton confirm;
	private JButton back;
	private JButton ESC;

    // Costruttore che accetta un riferimento al frame
	SchermataLotta(JFrame frame) {
		
		this.frame = frame;
		
		setLayout(new GridBagLayout());
		
		Border bordo = new LineBorder(Color.WHITE);
		
		setBorder(bordo);
		
		setBackground(Color.BLACK);
		
		// Creazione squadra CPU
		
		List<Pokemon> pokemonCPU = new ArrayList<>();
		pokemonCPU.add(new Charmander());
		pokemonCPU.add(new Squirtle());
		pokemonCPU.add(new Bulbasaur());
		pokemonCPU.add(new Pikachu());
		
		// Label Lotta
		
		labelLotta = new JLabel("Scegli i pokemon con cui lottare:");
		labelLotta.setFont(new Font("Arial", Font.PLAIN, 30));
		labelLotta.setOpaque(true);
		labelLotta.setForeground(Color.WHITE);
		labelLotta.setBackground(Color.BLACK);
		
		
		// CheckBox Pokemon 
		
		Charmander = new JCheckBox("Charmander");
		Charmander.setBackground(Color.BLACK);
		Charmander.setForeground(Color.WHITE);
		
		Squirtle = new JCheckBox("Squirtle");
		Squirtle.setBackground(Color.BLACK);
		Squirtle.setForeground(Color.WHITE);
		
		Bulbasaur = new JCheckBox("Bulbasaur");
		Bulbasaur.setBackground(Color.BLACK);
		Bulbasaur.setForeground(Color.WHITE);
		
		// Button confirm
		
		confirm = new JButton("Conferma");
		confirm.setForeground(Color.BLACK);
		confirm.setBackground(Color.WHITE);
		confirm.setFont(new Font("Arial", Font.PLAIN, 20));
		
		confirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Charmander.isSelected() || Squirtle.isSelected() || Bulbasaur.isSelected()) {
					
					// Creazione squadra utente
					
					List<Pokemon> pokemonUtente = new ArrayList<>(3);
					
					if(Charmander.isSelected()) {
						pokemonUtente.add(new Charmander());
					}
					if(Bulbasaur.isSelected()) {
						pokemonUtente.add(new Bulbasaur());
					}
					if(Squirtle.isSelected()) {
						pokemonUtente.add(new Squirtle());
					}
					
					lottaFrame = new JFrame("Lotta");
					
					lotta = new Lotta(pokemonUtente, pokemonCPU);
					
					lottaFrame.add(lotta);
					
					lottaFrame.setSize(new Dimension(1000, 600));
					lottaFrame.setLocationRelativeTo(null);
					lottaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					lottaFrame.setVisible(true);
					
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
		back.setForeground(Color.BLACK);
		back.setBackground(Color.WHITE);
		back.setFont(confirm.getFont());
		
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
		// Button ESC
		
		ESC = new JButton("ESCI");
		ESC.setForeground(Color.BLACK);
		ESC.setBackground(Color.WHITE);
		ESC.setFont(confirm.getFont());
		
		ESC.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		// Layout Lotta
		
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
		
		// Button confirm
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
				
		gbc.anchor = GridBagConstraints.LINE_START;
				
		gbc.insets = new Insets(20, 0, 0, 0);
				
		add(confirm, gbc);
		
		// Button back
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
				
		gbc.anchor = GridBagConstraints.CENTER;
				
		gbc.insets = new Insets(20, 0, 0, 0);
				
		add(back, gbc);
		
		// Button ESC
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
				
		gbc.anchor = GridBagConstraints.LINE_END;
				
		gbc.insets = new Insets(20, 0, 0, 0);
				
		add(ESC, gbc);
	}
	
}
