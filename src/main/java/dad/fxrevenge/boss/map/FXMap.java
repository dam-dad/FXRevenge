package dad.fxrevenge.boss.map;

import dad.fxrevenge.parameters.Backgrounds;
import dad.fxrevenge.parameters.Player;
import dad.fxrevenge.world.WorldMapController;

public class FXMap extends WorldMapController {

	private static String[][] map = {
//			{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16"},
			{ ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
			{ ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
			{ ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
			{ ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
			{ ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
			{ ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
			{ ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
			{ ".", ".", ".", ".", "P", ".", ".", ".", ".", "FX", ".", ".", ".", ".", ".", "." },
			{ ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
			{ ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
			{ ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
			{ ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." } };

	public FXMap() {
		super(map, Backgrounds.getFX());
		Player.setInSafeZone(false);
	}

}
