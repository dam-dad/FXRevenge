package dad.fxrevenge.dialog.character;

import javafx.scene.image.Image;

public class CharacterList {
	
	// Personajes especiales
	private static Character nullChar = new Character(null, null, false);
	private static Character unknownChar = new Character("???", null, false);
	
	// Avatar
	private static Character player = new Character("Protagonista genérico (tú)", new Image("/image/dialog/character/player.png"), true);
	
	// Aliados
	private static Character javaGoddess = new Character("Diosa Java", new Image("/image/dialog/character/java_goddess.png"), false);

	// Villanos
	private static Character M = new Character("M", new Image("/image/dialog/character/m.png"), false);
	private static Character V = new Character("V", new Image("/image/dialog/character/v.png"), false);
	private static Character C = new Character("C", new Image("/image/dialog/character/c.png"), false);
	private static Character FX = new Character("Mr. FX", new Image("/image/dialog/character/fx.png"), false);
	
	// Getters
	public static Character getNullChar() {
		return nullChar;
	}
	
	public static Character getUnknownChar() {
		return unknownChar;
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
