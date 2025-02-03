package GUI_Pokemon;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class Lotta_Tra_Pokemon extends JFrame{
	
	private SchermataStart schermataStart;
	
	public Lotta_Tra_Pokemon(){
		super("Pokemon Fight");
	
		setLayout(new BorderLayout());
		
		schermataStart = new SchermataStart();
		
		schermataStart.setVisible(true);
		
		add(schermataStart, BorderLayout.CENTER);
		
		setSize(800, 500);
		setLocationRelativeTo(null);
		//setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}	
}
