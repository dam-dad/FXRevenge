package dad.fxrevenge.shop;

import dad.fxrevenge.models.Avatar;
import dad.fxrevenge.models.ClassType;
import dad.fxrevenge.models.Skill;
import dad.fxrevenge.models.Vendor;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class ShopApp extends Application {

	private ShopController controller;
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		Avatar pj = new Avatar(new Image(getClass().getResource("/image/characters/mage_fIco.png").toExternalForm()),
				ClassType.Archmage, Skill.generateClassSkills(ClassType.Archmage), "Veronica");
		pj.setMoney(1000);
		
		controller = new ShopController(pj, new Vendor());
		
		Scene scene = new Scene(controller.getView(), 800, 600);
		
		primaryStage.setTitle("TEST SHOP");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);	
	}
}
