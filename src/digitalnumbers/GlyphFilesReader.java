/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitalnumbers;

import java.io.File;
import java.util.*;

/**
 *
 * @author Biljana
 */
public class GlyphFilesReader {

	private static final String LED_FILE_PATH = "D:\\Documents\\NetBeansProjects\\DigitalNumbers\\src\\led_files";
	private static final LedGlyph UNKNOWN;
	private final HashMap<Character, LedGlyph> glyphsMap;

	static {		
		ArrayList<String> list = new ArrayList<>();
		list.add("oooooo...ooooooo");
		list.add("oooo..ooo..ooooo");
		list.add("oooo..oooo..oooo");
		list.add("oooooooooo..oooo");
		list.add("oooooooooo..oooo");
		list.add("ooooooooo..ooooo");
		list.add("oooooooo..oooooo");
		list.add("ooooooo..ooooooo");
		list.add("ooooooo..ooooooo");
		list.add("oooooooooooooooo");
		list.add("ooooooo..ooooooo");
		list.add("ooooooo..ooooooo");
		UNKNOWN = new LedGlyph(list);
	}
	
	public GlyphFilesReader() {
		this.glyphsMap = new HashMap<>();
	}

	/**
	 * That method is wrong. It exposes implementation details and makes map susceptible to changes.
	 * @return 
	 */
	public HashMap<Character, LedGlyph> getGlyphsMap() {
		return glyphsMap;
	}
	
	public LedGlyph getGlyph(char key) {
		if (glyphsMap.containsKey(key)) {
			return glyphsMap.get(key);
		} else {
			return UNKNOWN;
		}
	}

	public void readGlyphFilesFromDirectory() {
		File folder = new File(LED_FILE_PATH);
		File[] fileArray = folder.listFiles();

		for (File file : fileArray) {
			if (file.isFile() && file.getName().toLowerCase().endsWith(".txt")) {
				String fileName = file.getName();
				List<String> data = utillities.Utillities.readFile(LED_FILE_PATH + "\\" + fileName);
				LedGlyph lg = new LedGlyph(data);
//				String[] splitName = fileName.split(".");
//				char[] character = splitName[0].toCharArray();
				char glyphCharacter = fileName.charAt(0);
				
				glyphsMap.put(glyphCharacter, lg);
			}
		}
	}

	public static void main(String[] args) {
//		readGlyphFilesFromDirectory();
	}
}
