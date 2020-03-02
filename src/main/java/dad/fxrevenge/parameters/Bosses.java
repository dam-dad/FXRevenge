package dad.fxrevenge.parameters;

import dad.fxrevenge.models.Enemy;
import dad.fxrevenge.models.Race;

public class Bosses {

	private static Enemy M = new Enemy(Race.M, 1);
	private static Enemy V = new Enemy(Race.V, 3);
	private static Enemy C = new Enemy(Race.C, 5);
	private static Enemy FX = new Enemy(Race.FX, 9);

	public static Enemy getM() {
		return M;
	}

	public static Enemy getV() {
		return V;
	}

	public static Enemy getC() {
		return C;
	}

	public static Enemy getFX() {
		return FX;
	}

}
