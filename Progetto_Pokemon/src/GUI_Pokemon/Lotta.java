package GUI_Pokemon;

import java.awt.*;
import javax.swing.*;

public class Lotta extends JPanel{

	private JProgressBar healthBar;
	private int health = 5;
	
	private JFrame frame;
	
	Lotta(JFrame frame){
		
		setLayout(new GridBagLayout());
		setBackground(Color.GRAY);
		
		this.frame = frame;
		
		healthBar = new JProgressBar(0, 100);
        healthBar.setValue(health);
        healthBar.setStringPainted(true); // Mostra il valore numerico

        // Imposta colori della barra
        healthBar.setForeground(Color.GREEN);
        healthBar.setBackground(Color.RED);

        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.gridx = 0;
		gbc.gridy = 0;
		
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		
		gbc.anchor = GridBagConstraints.CENTER;
		
		gbc.insets = new Insets(0, 0, 0, 0);
		
		add(healthBar, gbc);
        
	}
}

