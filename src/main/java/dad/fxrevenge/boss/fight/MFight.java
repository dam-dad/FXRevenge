package dad.fxrevenge.boss.fight;

import java.io.IOException;

import dad.fxrevenge.boss.dialog.MDialog;
import dad.fxrevenge.combat.CombatController;
import dad.fxrevenge.parameters.Backgrounds;
import dad.fxrevenge.parameters.Bosses;
import dad.fxrevenge.parameters.Player;
import dad.fxrevenge.scene.SceneManager;

public class MFight extends CombatController {

	private static boolean defeated = false;

	public MFight() throws IOException {
		super(Player.getPlayer(), Bosses.getM(), Backgrounds.getM());
	}

	@Override
	protected void victory() {
		defeated = true;
		SceneManager.changeScene(new MDialog());
	}

	public static boolean isDefeated() {
		return defeated;
	}

	public static void setDefeated(boolean defeated) {
		MFight.defeated = defeated;
	}

}
