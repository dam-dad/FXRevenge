package dad.fxrevenge.combat;

import java.io.IOException;

import dad.fxrevenge.models.Avatar;
import dad.fxrevenge.models.Enemy;
import dad.fxrevenge.scene.SceneManager;
import dad.fxrevenge.world.WorldMapController;
import javafx.scene.image.Image;

public class SimpleCombat extends CombatController {

	private static Image background = new Image("/image/background/v.png");

	public SimpleCombat(Avatar player, Enemy enemy) throws IOException {
		super(player, enemy, background);
	}

	@Override
	protected void victory() {
		SceneManager.changeScene(new WorldMapController());
	}

}
