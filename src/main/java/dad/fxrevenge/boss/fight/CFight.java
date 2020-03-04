package dad.fxrevenge.boss.fight;

import java.io.IOException;

import dad.fxrevenge.boss.dialog.CDialog;
import dad.fxrevenge.combat.CombatController;
import dad.fxrevenge.parameters.Backgrounds;
import dad.fxrevenge.parameters.Bosses;
import dad.fxrevenge.parameters.Player;
import dad.fxrevenge.scene.SceneManager;

public class CFight extends CombatController {

	private static boolean defeated = false;

	public CFight() throws IOException {
		super(Player.getPlayer(), Bosses.getC(), Backgrounds.getC());
	}

	@Override
	protected void victory() {
		defeated = true;
		SceneManager.changeScene(new CDialog());
	}

	public static boolean isDefeated() {
		return defeated;
	}

	public static void setDefeated(boolean defeated) {
		CFight.defeated = defeated;
	}

}
