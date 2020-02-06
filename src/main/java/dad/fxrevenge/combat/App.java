package dad.fxrevenge.combat;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import models.Avatar;
import models.ClassType;
import models.Enemy;
import models.Item;
import models.Race;
import models.Skill;

public class App extends Application {

	private EscenarioController controller;
	private Avatar pj = new Avatar(new Image(getClass().getResource("/images/lightstream.png").toString()), ClassType.Archmage, FXCollections.observableArrayList(), "Rayo");
	private Item item1=new Item(), item2=new Item(), item3=new Item();
	private Skill skill1 = new Skill(),skill2 = new Skill(),skill3 = new Skill();
	
	@Override
	public void start(Stage primaryStage) throws Exception {
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
		
		Enemy bichito = new Enemy(new Image(getClass().getResource("/images/chest.png").toString()), Race.Jelly, 1);
		
		controller = new EscenarioController(pj, bichito);
		
		Scene scene = new Scene(controller.getView());
		
		primaryStage.setTitle("¡Pelea, pelea!");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}