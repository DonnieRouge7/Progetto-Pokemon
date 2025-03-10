package GUI_Pokemon;

import java.awt.*;
import javax.swing.*;

public class JPokeBattle extends JFrame{
	
	private MenuPrincipale menuPrincipale;
	
	public JPokeBattle(){
	
		setLayout(new BorderLayout());
		
		menuPrincipale = new MenuPrincipale();
		
		menuPrincipale.setVisible(true);
		
		add(menuPrincipale, BorderLayout.CENTER);
		
		setSize(800, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}	
}
