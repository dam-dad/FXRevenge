package dad.fxrevenge.boss.map;

import dad.fxrevenge.parameters.Backgrounds;
import dad.fxrevenge.parameters.Player;
import dad.fxrevenge.world.WorldMapController;

public class Overworld extends WorldMapController {

	public static String[][] overworld = {
//			{ "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16"},
			{ "T1", "x", "x", "x", "x", "x", "x", "x", "x", "x", "VM", "VM", "VM", "x", "x", "T1" },
			{ "x", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "x" },
			{ "T1", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "T1" },
			{ "x", ".", ".", "x", "x", "x", ".", ".", ".", ".", ".", ".", ".", ".", ".", "x" },
			{ "x", ".", ".", ".", "S", "x", ".", ".", ".", ".", ".", ".", ".", ".", ".", "T1" },
			{ "MM", ".", ".", ".", ".", "x", "L", ".", ".", ".", ".", ".", ".", ".", ".", "x" },
			{ "MM", ".", ".", ".", ".", "x", "x", "x", "x", "x", "x", ".", ".", ".", ".", "x" },
			{ "MM", ".", ".", ".", ".", ".", ".", ".", ".", ".", "x", ".", ".", ".", ".", "CM" },
			{ "x", ".", ".", "T3", ".", ".", ".", ".", ".", ".", "x", ".", ".", ".", ".", "CM" },
			{ "T1", ".", ".", ".", ".", ".", ".", "P", ".", ".", "x", ".", ".", ".", ".", "CM" },
			{ "x", ".", ".", ".", ".", ".", ".", ".", ".", ".", "x", ".", ".", ".", ".", "x" },
			{ "T1", "x", "T1", "x", "T1", "x", "T1", "x", "T1", "x", "T1", "x", "T1", "x", "T1", "x" } };


	public Overworld() {
		super(overworld, Backgrounds.getOverworld());
		Player.setInSafeZone(true);
	}

}
