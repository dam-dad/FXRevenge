package dad.fxrevenge.menu;

import dad.fxrevenge.models.Avatar;
import dad.fxrevenge.models.ClassType;
import dad.fxrevenge.models.Skill;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MenuApp extends Application {

	private MenuController controller;

	@Override
	public void start(Stage primaryStage) throws Exception {

		Avatar pj = new Avatar(new Image(getClass().getResource("/image/characters/mage_fIco.png").toExternalForm()),
				ClassType.Archmage, Skill.generateClassSkills(ClassType.Archmage), "Veronica");
		
		controller = new MenuController(pj);
		
		Scene scene = new Scene(controller.getView());

		primaryStage.setTitle("TEST MENU");

		primaryStage.setScene(scene);

		primaryStage.show();
	}

	

	/**
	 * Ejecutamos para que la app aparezca y con ello el combate
	 * 
	 * @param args parametros necesario para el lanzamiento de la app
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
