package game.filereader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	/* needs a String line beginning with "size".
	 * Return the list [width, height] of the dimensions of the grid. */
	private static List<Integer> importDimensions (String line) {
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
	
	private static HashMap<Character, Tile> importEncoding (String mline) {
    var lexer = new Lexer(mline);
    Result result;
    var mapping = new HashMap<Character, Tile>();
    
    lexer.nextResult(); // "encodings"
    lexer.nextResult(); // ":"
    while ((result = lexer.nextResult()) != null) {
      Tile tile = new Tile(result.content());
      result = lexer.nextResult(); // "("
      result = lexer.nextResult();
      Character code = result.content().charAt(0);
      mapping.put(code, tile);
      result = lexer.nextResult(); // ")"
    }
    return mapping;
  }
	
	private static List<String> extractDataString(String mline) {
	  var lexer = new Lexer(mline);
	  Result result;
	  while ((result = lexer.nextResult()).token() != Token.QUOTE) {}
	  var quote = result.content();
	  var list = new ArrayList<>(Arrays.asList(quote.split("[\\t\\n\\x0B\\f\\r]")));
	  list.removeFirst();
	  list.removeIf(s -> s.length() == 0);
	  list.removeLast();
	  return list;
	}
	
	private static List<Tile> importTiles (int width, int height, Map<Character, Tile> mapping, List<String> lines) {
    var tiles = new ArrayList<Tile>();
	  for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        char c = lines.get(i).charAt(j);
        if (c != ' ') {
          tiles.add(mapping.get(c));
        }
      }
    }
	  return tiles;
  }
	
	public static void main(String[] args) throws IOException {
	  String line = "size: (6 x 5)";
    System.out.println("size" + importDimensions(line));
    String enc = "encodings: WALL(W) BRICK(B) FENCE(F)";
    System.out.println("enc" + importEncoding(enc));
    var p = Path.of("champ_data.txt");
    String datas = Files.readString(p);
    System.out.println(datas);
    var datalist = extractDataString(datas);
    System.out.println(datalist);
    System.out.println(importTiles(6, 5, importEncoding(enc), datalist));
	}
	 
}

// à supprimer
//class Tile {}