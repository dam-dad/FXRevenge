package dad.fxrevenge.combat;

import dad.fxrevenge.models.Avatar;
import dad.fxrevenge.models.ClassType;
import dad.fxrevenge.models.Enemy;
import dad.fxrevenge.models.Item;
import dad.fxrevenge.models.Race;
import dad.fxrevenge.models.Skill;
import dad.fxrevenge.scene.SceneManager;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {

	// Imagen de fondo del combate
//	private Image backgroundImage = new Image("/image/background/c.png");
	private Image backgroundImage = new Image("/image/background/fx.jpg");
//	private Image backgroundImage = new Image("/image/background/m.png");
//	private Image backgroundImage = new Image("/image/background/v.png");

	private EscenarioController controller;
	private Avatar pj = new Avatar(new Image(getClass().getResource("/images/lightstream.png").toString()),
			ClassType.Warlord, Skill.generateClassSkills(ClassType.Warlord), "Rayo");
	private Item item1 = new Item(), item2 = new Item(), item3 = new Item();

	@Override
	public void start(Stage primaryStage) throws Exception {
		item1.setName("poti");
		item1.setQuantity(2);
		item2.setName("galleta");
		item2.setQuantity(5);
		item3.setName("orbe");
		item3.setQuantity(1);

		ObservableList<Item> items = FXCollections.observableArrayList(item1, item2, item3);
		pj.setInventory(items);

		Enemy bichito = new Enemy(Race.Jelly, 1);
		bichito.setAppearance(new Image(getClass().getResource("/images/chest.png").toString()));

		controller = new EscenarioController(pj, bichito, backgroundImage);

		SceneManager.setMainStage(primaryStage);
		SceneManager.changeScene(controller); // SceneManager coge la Scene del controller directamente y la inicia

		primaryStage.setTitle("COMBAT TEST");
		primaryStage.setResizable(false);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
