package fr.uge.map;

import java.util.Objects;

public record Obstacle(ObstacleType obstacle, int x, int y, Kind kind) implements Element{
	public Obstacle{
		Objects.requireNonNull(obstacle);
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
