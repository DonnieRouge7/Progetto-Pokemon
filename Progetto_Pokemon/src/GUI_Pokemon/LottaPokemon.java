package GUI_Pokemon;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class LottaPokemon extends JFrame{
	
	private SchermataStart schermataStart;
	
	public LottaPokemon(){
	
		setLayout(new BorderLayout());
		
		schermataStart = new SchermataStart();
		
		schermataStart.setVisible(true);
		
		add(schermataStart, BorderLayout.CENTER);
		
		setSize(800, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}	
}
