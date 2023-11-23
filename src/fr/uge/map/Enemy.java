package fr.uge.map;

import java.util.Objects;

public record Enemy(String name, int x, int y, Kind kind, int health, String behavior, int damage) implements Element {
	
	public Enemy{
		Objects.requireNonNull(name);
		Objects.requireNonNull(kind);
		Objects.requireNonNull(behavior);
		Objects.requireNonNull(damage);
		if(x < 0 || y < 0) {
			throw new IllegalArgumentException("The position must be positive");
		}
		if(health < 0) {
			throw new IllegalArgumentException("health must be positive");
		}
		
	}
}


