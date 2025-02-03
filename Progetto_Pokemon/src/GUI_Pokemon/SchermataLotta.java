package GUI_Pokemon;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.*;

public class SchermataLotta extends JPanel{
	
 	private JFrame frame;
 	private JFrame lottaFrame;
 	
 	private Lotta lotta;
 	
 	private JLabel labelLotta;
	private JTextArea fieldlotta;
	
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
		
		// Label Lotta
		
		labelLotta = new JLabel("Scegli i pokemon con cui lottare:");
		labelLotta.setFont(new Font("Arial", Font.PLAIN, 30));
		labelLotta.setOpaque(true);
		labelLotta.setForeground(Color.WHITE);
		labelLotta.setBackground(Color.BLACK);
		
		// Label Pokemon
		
		labelCharmander = new JLabel("Charmander");
		labelCharmander.setForeground(Color.WHITE);
		
		labelSquirtle = new JLabel("Squirtle");
		labelSquirtle.setForeground(Color.WHITE);
		
		labelBulbasaur = new JLabel("Bulbasaur");
		labelBulbasaur.setForeground(Color.WHITE);
		
		// CheckBox Pokemon 
		
		Charmander = new JCheckBox();
		Charmander.setBackground(Color.BLACK);
		
		Squirtle = new JCheckBox();
		Squirtle.setBackground(Color.BLACK);
		
		Bulbasaur = new JCheckBox();
		Bulbasaur.setBackground(Color.BLACK);
		
		// Button confirm
		
		confirm = new JButton("Conferma");
		confirm.setForeground(Color.BLACK);
		confirm.setBackground(Color.WHITE);
		confirm.setFont(new Font("Arial", Font.PLAIN, 20));
		
		confirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Charmander.isSelected() || Squirtle.isSelected() || Bulbasaur.isSelected()) {
					lottaFrame = new JFrame("Lotta");
					
					lotta = new Lotta(lottaFrame);
					
					lottaFrame.add(lotta);
					
					lottaFrame.setSize(new Dimension(1000, 600));
					lottaFrame.setLocationRelativeTo(null);
					lottaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					lottaFrame.setVisible(true);
					
				}else {
					JOptionPane.showMessageDialog(frame, "Nessuna checkbox selezionata!");
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
		
		// Layout Label Charmander
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		
		gbc.anchor = GridBagConstraints.LINE_START;
		
		gbc.insets = new Insets(10, 25, 0, 0);
		
		
		add(labelCharmander, gbc);
		
		// Layout CheckBox Charmander
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		
		gbc.anchor = GridBagConstraints.LINE_START;
		
		gbc.insets = new Insets(10, 0, 0, 0);
		
		add(Charmander, gbc);
		
		// Layout Label Squirtle
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
				
		gbc.anchor = GridBagConstraints.LINE_START;
				
		gbc.insets = new Insets(10, 25, 0, 0);
			
		add(labelSquirtle, gbc);
				
		// Layout CheckBox Squirtle
				
		gbc.gridx = 0;
		gbc.gridy = 2;
		
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
				
		gbc.anchor = GridBagConstraints.LINE_START;
				
		gbc.insets = new Insets(10, 0, 0, 0);
				
		add(Squirtle, gbc);
		
		// Layout Label Bulbasaur
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
				
		gbc.anchor = GridBagConstraints.LINE_START;
				
		gbc.insets = new Insets(10, 25, 0, 0);
			
		add(labelBulbasaur, gbc);
		
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
