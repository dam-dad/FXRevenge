package dad.fxrevenge.dialog;

import dad.fxrevenge.parameters.Player;
import javafx.scene.image.Image;

public class CharacterList {
	
	// Personajes especiales
	private static Character nullChar = new Character(null, null);
	
	// Avatar
	private static Character player = new Character(Player.getPlayer().getName(), new Image("/image/characters/other/warrior.png"));
	
	// Aliados
	private static Character javaGoddess = new Character("Diosa Java", new Image("/image/characters/other/java_goddess.png"));

	// Villanos
	private static Character M = new Character("Meridio", new Image("/image/characters/boss/portrait/m.png"));
	private static Character V = new Character("Valery", new Image("/image/characters/boss/portrait/v.png"));
	private static Character C = new Character("Calipso", new Image("/image/characters/boss/portrait/c.png"));
	private static Character FX = new Character("Mr. FX", new Image("/image/characters/boss/portrait/fx.png"));
	
	// Getters
	public static Character getNullChar() {
		return nullChar;
	}
	
	public static Character getPlayer() {
		return player;
	}
	
	public static Character getJavaGoddess() {
		return javaGoddess;
	}
	
	public static Character getM() {
		return M;
	}
	
	public static Character getV() {
		return V;
	}
	
	public static Character getC() {
		return C;
	}
	
	public static Character getFX() {
		return FX;
	}

}
