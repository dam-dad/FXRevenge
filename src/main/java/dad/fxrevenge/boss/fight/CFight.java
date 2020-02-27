package dad.fxrevenge.boss.fight;

import java.io.IOException;

import dad.fxrevenge.boss.map.CMap;
import dad.fxrevenge.combat.CombatController;
import dad.fxrevenge.dialog.CharacterList;
import dad.fxrevenge.models.Avatar;
import dad.fxrevenge.models.ClassType;
import dad.fxrevenge.models.Effect;
import dad.fxrevenge.models.Item;
import dad.fxrevenge.models.Skill;
import dad.fxrevenge.scene.SceneManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CFight extends CombatController {

	// COSITAS DEL COMBATE

	private Avatar pj = new Avatar(CharacterList.getPlayer().getPortrait(), ClassType.Warlord,
			Skill.generateClassSkills(ClassType.Warlord), CharacterList.getPlayer().getName());

	private Item item1 = new Item(), item2 = new Item(), item3 = new Item();

	// FIN COSITAS DEL COMBATE

	public CFight() throws IOException {
		super();
	}

	@Override
	public void start() {
		super.setPj(pj);
		super.setEnemy(BOSS_C);
		super.setBackgroundImage(BACKGROUND_C);

		item1.setName("poti");
		item1.setEffect(Effect.HealRestore);
		item1.setQuantity(2);
		item2.setName("galleta");
		item2.setEffect(Effect.HealRestore);
		item2.setQuantity(5);
		item3.setName("orbe");
		item3.setEffect(Effect.ManaRestore);
		item3.setQuantity(1);

		ObservableList<Item> items = FXCollections.observableArrayList(item1, item2, item3);
		pj.setInventory(items);

		super.start();

	}

	@Override
	protected void victory() {
		SceneManager.changeScene(new CMap(pj));
	}

}
