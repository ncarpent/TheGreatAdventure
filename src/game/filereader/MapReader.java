package game.filereader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import game.Grid;

public class MapReader {
	// tester le format .map aussi...
	public static Grid importGridFromFile (Path path) throws IOException {
		try (var reader = Files.newBufferedReader(path)) {
			String line;
			while (!(line = reader.readLine()).equals("[grid]")) {}
			
		}
		return new Grid(0, 0, new HashMap<>(), new List());
	}
	
	private static List<Integer> importDimentions (String line) {
		line = line.strip();
		line = line.substring(7, line.length()-1);
		var dimentions = Arrays.asList(line.split("x"));
		ArrayList<Integer> val = new ArrayList<>();
		dimentions.forEach(s -> val.add(Integer.parseInt(s))); 
		return val;
	}
	 
}

// à supprimer
//class Tile {}