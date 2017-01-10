/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitalnumbers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JComponent;

/**
 *
 * @author Biljana
 */
public class LedComponent extends JComponent {

	private int ledWidth;
	private boolean luminated;
	private Color disabledLedColor;// = new Color(150, 100, 250, 40);

	public Color getDisabledLedColor() {
		return disabledLedColor;
	}

	public void setDisabledLedColor(Color disabledLedColor) {
		this.disabledLedColor = disabledLedColor;
	}

	public LedComponent() {
		this(12);
	}

	public LedComponent(int width) {
		if (width == 0) {
			this.ledWidth = 12;
		} else {
			this.ledWidth = width;
		}
		setPreferredSize(new Dimension(ledWidth, ledWidth));
//		setBorder(new LineBorder(Color.BLACK));
	}

	public boolean isLuminated() {
		return luminated;
	}

	public void setLuminated(boolean luminated) {
		this.luminated = luminated;
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		if (luminated) {
			g.setColor(getForeground());
		} else {
			if (disabledLedColor == null) {
				return;
			}
			g.setColor(disabledLedColor);
		}
		drawLed(g2d, g);
	}

	private void drawLed(Graphics2D g2d, Graphics g) {
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.fillOval(0, 0, ledWidth, ledWidth);
	}
}
