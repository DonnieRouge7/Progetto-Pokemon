package GUI_Pokemon;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class LottaPokemon extends JFrame{
	
	private MenuPrincipale menuPrincipale;
	
	public LottaPokemon(){
	
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
