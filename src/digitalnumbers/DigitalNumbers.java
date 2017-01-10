/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitalnumbers;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JFrame;

/**
 *
 * @author Biljana
 */
public class DigitalNumbers {

	private static GlyphFilesReader reader = new GlyphFilesReader();
	
	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {

		reader.readGlyphFilesFromDirectory();
		
		JFrame testFrame = new JFrame("Test Frame");
		testFrame.setSize(400, 300);
		DisplayNumberPanel displayNumberPanel = new DisplayNumberPanel(12, 16, 0);
		displayNumberPanel.setForeground(new Color(255, 0, 255, 100));
		
		displayNumberPanel.displayChars(reader.getGlyph('4'));
		
//		displayNumberPanel.setBackground(Color.WHITE);
		testFrame.add(displayNumberPanel);
		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		testFrame.setLayout(new FlowLayout());
		testFrame.setVisible(true);
	}

}