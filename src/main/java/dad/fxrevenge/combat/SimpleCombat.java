package dad.fxrevenge.combat;

import java.io.IOException;

import dad.fxrevenge.models.Avatar;
import dad.fxrevenge.models.Enemy;
import dad.fxrevenge.scene.SceneManager;
import dad.fxrevenge.world.WorldMapController;
import javafx.scene.image.Image;

public class SimpleCombat extends CombatController {
	private Avatar player;
	private Enemy enemy;
	private static Image background = new Image("/image/background/v.png");

	public SimpleCombat(Avatar player, Enemy enemy) throws IOException {
		super(player, enemy, background);
		this.player = player;
		this.enemy = enemy;
	}

	@Override
	protected void victory() {
		int DropGearProc = (int) (Math.random() * 100);
		if (DropGearProc > 25) {
			player.equipar(enemy.getGearDrop());
		} else {

		}
		
		//pendiente de comprobar si suma exp y dinero
		player.sumarexp(enemy.getExpDrop());
		player.setMoney(player.getMoney() + enemy.getMoneyDrop());

		SceneManager.changeScene(new WorldMapController());
	}

}
