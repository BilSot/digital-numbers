/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitalnumbers;

import java.util.*;

/**
 *
 * @author Biljana
 */
public class LedGlyph {

	private List<String> glyphList;
	private int glyphWidth;
	private int glyphHeight;

	public LedGlyph(List<String> list) {
		this.glyphList = list;
		if (!isListWithEqualLinesWidth()) {
			throw new RuntimeException("List elements are not all of the same length");
		}
		this.glyphWidth = glyphList.get(0).length();
		this.glyphHeight = glyphList.size();
	}

	public List<String> getGlyphList() {
		return glyphList;
	}

	public int getGlyphHeight() {
		return glyphHeight;
	}

	public int getGlyphWidth() {
		return glyphWidth;
	}

	private boolean isListWithEqualLinesWidth() {
		int width = glyphList.get(0).length();

		for (int i = 1; i < glyphList.size(); i++) {
			if (width != glyphList.get(i).length()) {
				return false;
			}
		}

		return true;
	}

}
