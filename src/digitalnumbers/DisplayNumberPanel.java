/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitalnumbers;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author Biljana
 */
public class DisplayNumberPanel extends JPanel {

	private int rows;
	private int columns;
	private List<LedComponent> ledComponents = new ArrayList<>();

	public DisplayNumberPanel() {
		this(12, 16, 12);
	}

	public DisplayNumberPanel(int rows, int columns, int ledWidth) {
		this.rows = rows;
		this.columns = columns;
		setLayout(new GridLayout(rows, columns, 2, 2));
		setBorder(new LineBorder(Color.BLACK));

		for (int i = 0; i < columns * rows; i++) {
			LedComponent ledComponent = createLedComponent(ledWidth);
			add(ledComponent);
			ledComponents.add(ledComponent);
		}
	}

	private LedComponent createLedComponent(int ledSize) {
		LedComponent ledComponent = new LedComponent(ledSize);
		ledComponent.setDisabledLedColor(new Color(0, 40, 40, 20));
		ledComponent.setForeground(getForeground());
		return ledComponent;
	}

	@Override
	public void setForeground(Color fg) {
		super.setForeground(fg);
		Component[] components = getComponents();

		for (Component temp : components) {
			temp.setForeground(fg);
		}
	}

	public void displayChars(LedGlyph lg) {
		int linesCounter = 0;
		
		if(lg.getGlyphHeight() != this.rows){
			throw new RuntimeException("The number of glyph row elements doesn't match the panel's rows. Suggested size is 12 rows.");
		}
		if(lg.getGlyphWidth() != this.columns){
			throw new RuntimeException("The number of glyph column elements doesn't match the panel's columns. Suggested size is 16 columns");
		}

		for (String line : lg.getGlyphList()) {
			int charCounter = 0;
			char[] toCharArray = line.toCharArray();
			for (char c : toCharArray) {
				setStatusOfLed(linesCounter, charCounter, (c == 'o'));
				charCounter++;
			}
			linesCounter++;

		}

	}

	private void setStatusOfLed(int r, int c, boolean status) {
		int index = r * columns + c;
		LedComponent comp = ledComponents.get(index);
		comp.setLuminated(status);
	}

}
