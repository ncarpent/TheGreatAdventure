package game;

/*   Cette interface cotient les Objets suivant: 
 * Weapon
 * Obstacle
 * Entity
 * Decoration
 */
public interface Element {
	default boolean isPlayer() {
		return false;
	}
}
