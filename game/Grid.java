package game;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Grid {
	
	private final int width;
	private final int height;
	private final HashMap<String, Tile> encodings; // à supprimer
	private final List<Tile> data;
	
	public Grid (int width, int height, HashMap<String, Tile> m, List<Tile> l) {
		if (width < 0) {
			throw new IllegalArgumentException("negativ width.");
		}
		if (height < 0) {
			throw new IllegalArgumentException("negativ height.");
		} 
		Objects.requireNonNull(m);
		Objects.requireNonNull(l);
		this.width = width;
		this.height = height;
		encodings = m; // à revoir
		data = l; // à revoir
	}
}
 
// à supprimer
//class Tile {}