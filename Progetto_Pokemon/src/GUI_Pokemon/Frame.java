package GUI_Pokemon;

import java.awt.*;
import javax.swing.*;

public class Frame extends JFrame{
	
	public Frame() {
		super("Lotta Pokemon");
		
		setLayout(new BorderLayout());
		
		setSize(800, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
