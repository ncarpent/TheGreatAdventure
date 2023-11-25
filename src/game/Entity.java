package game;

import java.util.Objects;

public record Entity(String name, int x, int y, Kind kind, int health, int damage, boolean isPlayer) implements Element {
	
	public Entity{
		Objects.requireNonNull(name);
		Objects.requireNonNull(kind);
		if(damage < 0) {
			throw new IllegalArgumentException("The damage must be positive or equal to zero");
		}
		if(x < 0 || y < 0) {
			throw new IllegalArgumentException("The position must be positive");
		}
		if(health < 0) {
			throw new IllegalArgumentException("health must be positive");
		}
		
		if(isPlayer && kind != Kind.friend) {
			throw new IllegalArgumentException("If isPlayer is true, the kind must be friend");
		}
	}
	
	
	
}


