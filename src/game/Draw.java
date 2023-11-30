package game;

import java.awt.Graphics2D;
import java.awt.Image;
import java.nio.file.Files;
import java.util.EnumMap;
import java.util.Objects;

import javax.imageio.ImageIO;
public class Draw {
	private final Double ELEMENTPROPORTION = 1 / 10.0;
	private final Double XCELL = width * ELEMENTPROPORTION;
	private final Double YCELL = heigth * ELEMENTPROPORTION;
	private static final EnumMap<ObstacleType, Image> obstaclesImages = new EnumMap<>(ObstacleType.class);
	private static final EnumMap<DecoType, Image> decoImages = new EnumMap<>(DecoType.class); 
	private static final EnumMap<WeaponType, Image> weaponsImages = new EnumMap<>(WeaponType.class);
	
	private void loadObstacles() {
		for(var key : ObstacleType.class.getEnumConstants()){
			   var path = Path.of(("Elements").resolve("obstacle"), key.toString() + ".png");
				try(var input = Files.newInputStream(path)) {
					obstaclesImages.put(key, ImageIO.read(input));
				}
		}
	}
	private void loadDecorations() {
		for(var key : DecoType.class.getEnumConstants()){
			   var path = Path.of(("Elements").resolve("decoration"), key.toString() + ".png");
				try(var input = Files.newInputStream(path)) {
					decoImages.put(key, ImageIO.read(input));
				}
		}
	}
	private void loadWeapons() {
		for(var key : WeaponType.class.getEnumConstants()){
			   var path = Path.of(("Elements").resolve("weapons"), key.toString() + ".png");
				try(var input = Files.newInputStream(path)) {
					weaponsImages.put(key, ImageIO.read(input));
				}
		}
	}
	
	public void loadImages() {
	   loadObstacles();
	   loadDecorations();
	   loadWeapons();
	}
	
	public void drawElements(Graphics2D graphics, List<Element> listElements){
		Objects.requireNonNull(listElements);
		Objects.requireNonNull(graphics);
		
		for(var element : listElements) {
			draw(graphics, element);
		}
	}
	private static void draw(Graphics2D graphics, Element element){
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
		graphics.drawImage(image, obstacle.x() * XCELL, obstacle.y() * YCELL, null);
	}

	private static void drawDecoration(Graphics2D graphics, Decoration decoration) {
		Objects.requireNonNull(decoration);
		Objects.requireNonNull(graphics);
		var image = obstaclesImages.get(decoration.decoration());
		graphics.drawImage(image, decoration.x() * XCELL, decoration.y() * YCELL, null);
	}

	private static void drawWeapon(Graphics2D graphics, Weapon weapon) {
		Objects.requireNonNull(weapon);
		Objects.requireNonNull(graphics);
		var image = obstaclesImages.get(weapon.decoration());
		graphics.drawImage(image, weapon.x() *XCELL, weapon.y() * YCELL, null);
	}
	
	
} 
