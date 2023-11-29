package game;

import java.awt.Graphics2D;
import java.awt.Image;
import java.util.EnumMap;
import java.util.Objects;
public class Draw {
	private static final EnumMap<ObstacleType, Image> obstaclesImages = new EnumMap<>(ObstacleType.class); 
	
	public void draw(Element element){
		Objects.requireNonNull(element);
		switch(element){
			case Obstacle o -> drawObstacle(o);
			
			default -> throw new IllegalArgumentException("Unexpected value: " + element);
		}
	}
	
	private static void drawObstacle(Graphics2D graphics, int height, int width, Obstacle obstacle) {
		Objects.requireNonNull(obstacle);
		Objects.requireNonNull(graphics);
		var image = obstaclesImages.get(obstacle.obstacle());
		graphics.drawImage(image, obstacle.x() * width, obstacle.y() * height, null);
	
	}
	
	
} 
