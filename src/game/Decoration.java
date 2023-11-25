package game;

import java.util.Objects;

public record Decoration(DecoType deco, int x, int y, Kind kind) implements Element{
	public Decoration{
		Objects.requireNonNull(deco);
		Objects.requireNonNull(kind);
		if(x < 0 || y < 0) {
			throw new IllegalArgumentException("The position must be positive");
		}
		
	}
	@Override
	public Kind kind() {
		return kind;
	}
}
