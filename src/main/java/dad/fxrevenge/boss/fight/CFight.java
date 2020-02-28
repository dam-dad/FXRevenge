package dad.fxrevenge.boss.fight;

import java.io.IOException;

import dad.fxrevenge.boss.map.CMap;
import dad.fxrevenge.combat.CombatController;
import dad.fxrevenge.parameters.Backgrounds;
import dad.fxrevenge.parameters.Bosses;
import dad.fxrevenge.parameters.Player;
import dad.fxrevenge.scene.SceneManager;

public class CFight extends CombatController {

	public CFight() throws IOException {
		super(Player.getPlayer(), Bosses.getC(), Backgrounds.getC());
	}

	@Override
	protected void victory() {
		SceneManager.changeScene(new CMap());
	}

}
