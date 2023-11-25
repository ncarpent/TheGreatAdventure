package game;

import java.util.Objects;

public record Decoration(DecoTyped deco, int x, int y) implements Element{
	public Decoration{
		Objects.requireNonNull(deco);

		if(x < 0 || y < 0) {
			throw new IllegalArgumentException("The position must be positive");
		}
		
	}
	
}
