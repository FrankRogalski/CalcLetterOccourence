package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Haupt {
	private HashMap<Character, Integer> letters = new HashMap<>();
	private File file;
	
	public Haupt(String path) {
		File test = new File(path);
		if (test.isFile())
			this.file = test;
	}
	
	public void start() {
		try (BufferedReader br = new BufferedReader(new FileReader(file))){
			String line;
		    while ((line = br.readLine()) != null) 
		    	for (int i = 0; i < line.length(); i++) {
		    		char c = line.charAt(i);
		    		int count = letters.get(c) == null ? 0 : letters.get(c);
		    		letters.put(c, count + 1);
		    	}
		    for (Map.Entry<Character, Integer> entry : letters.entrySet()) {
		    	System.out.println("'" + entry.getKey() + "': " + entry.getValue());
		    }
		} catch (IOException ex) {
			//Not needed
		}
	}
}
