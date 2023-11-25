package game;

import java.util.Objects;

public record Character(String name, boolean isPlayer, int health, int x, int y){
	public Character{
		Objects.requireNonNull(name);
		if(x < 0 || y < 0) {
			throw new IllegalArgumentException("The position must be positive");
		}
		if(health < 0) {
			throw new IllegalArgumentException("health must be positive");
		}
		
	}
}
