package dad.fxrevenge.parameters;

import javafx.scene.image.Image;

public class Backgrounds {

	private static Image titleScreen = new Image("/image/background/titlescreen.png");
	private static Image intro = new Image("/image/background/introduction.png");
	private static Image m = new Image("/image/background/m.png");
	private static Image v = new Image("/image/background/v.png");
	private static Image c = new Image("/image/background/c.png");
	private static Image fx = new Image("/image/background/fx.png");
	private static Image overworld = new Image("/image/background/overworld.png");

	public static Image getTitleScreen() {
		return titleScreen;
	}

	public static Image getIntro() {
		return intro;
	}

	public static Image getM() {
		return m;
	}

	public static Image getV() {
		return v;
	}

	public static Image getC() {
		return c;
	}

	public static Image getFX() {
		return fx;
	}

	public static Image getOverworld() {
		return overworld;
	}
}
