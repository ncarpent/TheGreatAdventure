package game.filereader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import game.Grid;
import game.Tile;

public class MapReader {
  
  private final Path mapPath = Path.of("Maps", "demo.map");
  
	// tester le format .map aussi...
	public static Grid importGridFromFile (Path path) throws IOException {
		try (var reader = Files.newBufferedReader(path)) {
			String line;
			while (!(line = reader.readLine()).equals("[grid]")) {}
			
		}
		return new Grid(0, 0, new HashMap<>(), new List());
	}
	
	/* needs a String line beginning with "size". */
	private static List<Integer> importDimentions (String line) {
	  var lexer = new Lexer(line);
	  Result result;
	  var list = new ArrayList<Integer>();
	  while ((result = lexer.nextResult()).token() != Token.NUMBER) {}
	  int width = Integer.parseInt(result.content());
	  while ((result = lexer.nextResult()).token() != Token.NUMBER) {}
    int height = Integer.parseInt(result.content());
    list.add(width);
    list.add(height);
    return List.copyOf(list);
	  /*
		line = line.strip();
		line = line.substring(7, line.length()-1);
		var dimentions = Arrays.asList(line.split("x"));
		ArrayList<Integer> val = new ArrayList<>();
		dimentions.forEach(s -> val.add(Integer.parseInt(s))); 
		return val;
		*/    
	}
	
	private static HashMap<String, Tile> importEncoding (String mline) {
    var lexer = new Lexer(mline);
    Result result;
    var mapping = new HashMap<String, Tile>();
    
    result = lexer.nextResult(); // "encodings"
    result = lexer.nextResult(); // ":"
    while ((result = lexer.nextResult()) != null) {
      Tile tile = new Tile(result.content());
      result = lexer.nextResult(); // "("
      result = lexer.nextResult();
      String code = result.content();
      mapping.put(code, tile);
      result = lexer.nextResult(); // ")"
    }
    return mapping;
  }
	
	public static void main(String[] args) {
	  String line = "size: (6 x 5)";
    System.out.println("size" + importDimentions(line));
    String enc = "encodings: WALL(W) BRICK(B) FENCE(F)";
    System.out.println("enc" + importEncoding(enc));
  }
	 
}

// à supprimer
//class Tile {}