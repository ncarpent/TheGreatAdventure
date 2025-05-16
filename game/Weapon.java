package game;

import java.util.Objects;

public record Weapon(String name, WeaponType weapon, int x, int y, Kind kind, int damage) implements Element {
	
	public Weapon{
		Objects.requireNonNull(name);
		Objects.requireNonNull(weapon);
		Objects.requireNonNull(kind);
		if(damage < 0) {
			throw new IllegalArgumentException("The damage must be positive or equal to zero");
		}
		if(x < 0 || y < 0) {
			throw new IllegalArgumentException("The position must be positive");
		}
	}
	

}
