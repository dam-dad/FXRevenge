package dad.fxrevenge.combat;

import java.io.IOException;

import dad.fxrevenge.combat.CombatController;
import dad.fxrevenge.dialog.CharacterList;
import dad.fxrevenge.models.Avatar;
import dad.fxrevenge.models.ClassType;
import dad.fxrevenge.models.Effect;
import dad.fxrevenge.models.Enemy;
import dad.fxrevenge.models.Item;
import dad.fxrevenge.models.Race;
import dad.fxrevenge.models.Skill;
import dad.fxrevenge.scene.SceneManager;
import dad.fxrevenge.world.WorldMapController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

public class SimpleCombat extends CombatController {

	// COSITAS DEL COMBATE

	private Image background = new Image("/image/background/v.png");

	private Avatar pj;

	private Enemy enemy;
	private WorldMapController worldMapController;

	// FIN COSITAS DEL COMBATE

	public SimpleCombat(Avatar avatar,Enemy enemy) throws IOException {
		super();
		this.pj=avatar;
		this.enemy=enemy;
//		this.worldMapController=worldMapController;
	}

	@Override
	public void start() {
		super.setPj(pj);
		super.setEnemy(enemy);
		super.setBackgroundImage(background);
		super.start();

	}

	@Override
	protected void victory() {
		SceneManager.changeScene(new WorldMapController(pj));
	}

}
