package game;

import java.awt.Graphics2D;
import java.awt.Image;
import java.util.EnumMap;
import java.util.Objects;
public class Draw {
	private static final EnumMap<ObstacleType, Image> obstaclesImages = new EnumMap<>();
	private static final EnumMap<DecoType, Image> obstaclesImages = new EnumMap<>(); 
	private static final EnumMap<WeaponType, Image> obstaclesImages = new EnumMap<>();
	
	public void drawElements(Graphics2D graphics, GameMap map){
		
	}
	
	public void draw(Graphics2D graphics, Element element){
		Objects.requireNonNull(element);
		Objects.requireNonNull(graphics);
		switch(element){
			case Obstacle o -> drawObstacle(graphics, o);
			case Decoration d -> drawDecoration(graphics, d);
			case Weapon w -> drawWeapon(graphics, w);
			default -> throw new IllegalArgumentException("Unexpected value: " + element);
		}
	}
	
	private static void drawObstacle(Graphics2D graphics, Obstacle obstacle) {
		Objects.requireNonNull(obstacle);
		Objects.requireNonNull(graphics);
		var image = obstaclesImages.get(obstacle.obstacle());
		graphics.drawImage(image, obstacle.x() * 24, obstacle.y() * 24, null);
	}

	private static void drawDecoration(Graphics2D graphics, Decoration decoration) {
		Objects.requireNonNull(decoration);
		Objects.requireNonNull(graphics);
		var image = obstaclesImages.get(decoration.decoration());
		graphics.drawImage(image, decoration.x() *24, decoration.y() * 24, null);
	}

	private static void drawWeapon(Graphics2D graphics, Weapon weapon) {
		Objects.requireNonNull(weapon);
		Objects.requireNonNull(graphics);
		var image = obstaclesImages.get(weapon.decoration());
		graphics.drawImage(image, weapon.x() *24, weapon.y() * 24, null);
	}
	
	
} 
