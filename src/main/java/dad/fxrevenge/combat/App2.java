package dad.fxrevenge.combat;

import java.io.IOException;

import dad.fxrevenge.models.Avatar;
import dad.fxrevenge.models.ClassType;
import dad.fxrevenge.models.Enemy;
import dad.fxrevenge.models.Item;
import dad.fxrevenge.models.Race;
import dad.fxrevenge.models.Skill;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.image.Image;

public class App2 extends dad.fxrevenge.scene.Scene {

	private EscenarioController controller;
	private Avatar pj = new Avatar(new Image(getClass().getResource("/images/lightstream.png").toString()), ClassType.Archmage, FXCollections.observableArrayList(), "Rayo");
	private Item item1=new Item(), item2=new Item(), item3=new Item();
	private Skill skill1 = new Skill(),skill2 = new Skill(),skill3 = new Skill();
	
	Scene scene;

	@Override
	public void load() {
		// TODO Auto-generated method stub
		item1.setName("poti");
		item1.setQuantity(2);
		item2.setName("galleta");
		item2.setQuantity(5);
		item3.setName("orbe");
		item3.setQuantity(1);

		skill1.setName("miniataque igneo");
		skill2.setName("minihelada");
		skill3.setName("minirayo");
		
		ObservableList<Item> items =FXCollections.observableArrayList (item1, item2, item3);
		ObservableList<Skill> skills =FXCollections.observableArrayList (skill1, skill2, skill3);
		pj.setInventory(items);
		pj.setSkills(skills);
		
		Enemy bichito = new Enemy(Race.Jelly, 1);
		bichito.setAppearance(new Image(getClass().getResource("/images/chest.png").toString()));
		
		try {
			controller = new EscenarioController(pj, bichito);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		scene = new Scene(controller.getView());
		

		
	}

	@Override
	protected void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unload() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Scene getScene() {
		return scene;
	}
}
