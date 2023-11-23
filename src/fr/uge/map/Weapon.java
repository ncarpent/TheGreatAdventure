package fr.uge.map;

import java.util.Objects;

public record Weapon(String name, WeaponType weapon, int x, int y, Kind kind, int damage) implements Element {
	
	public Weapon{
		Objects.requireNonNull(name);
		Objects.requireNonNull(weapon);
		Objects.requireNonNull(kind);
		Objects.requireNonNull(damage);
		if(x < 0 || y < 0) {
			throw new IllegalArgumentException("The position must be positive");
		}
	}
}
