package game;
import java.util.List;
import java.util.Objects;

public class GameMap {
	
	private final Grid grid;
	private final List<Element> elements;
	
	public GameMap (Grid grid, List<Element> elements) {
		Objects.requireNonNull(grid);
		Objects.requireNonNull(elements);
		this.grid = grid;
		this.elements = elements;
	}
	
}

//class Element {}