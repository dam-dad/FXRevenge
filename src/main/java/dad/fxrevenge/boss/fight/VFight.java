package dad.fxrevenge.boss.fight;

import java.io.IOException;

import dad.fxrevenge.boss.map.VMap;
import dad.fxrevenge.combat.CombatController;
import dad.fxrevenge.parameters.Backgrounds;
import dad.fxrevenge.parameters.Bosses;
import dad.fxrevenge.parameters.Player;
import dad.fxrevenge.scene.SceneManager;

public class VFight extends CombatController {

	public VFight() throws IOException {
		super(Player.getPlayer(), Bosses.getV(), Backgrounds.getV());
	}

	@Override
	protected void victory() {
		SceneManager.changeScene(new VMap());
	}

}
