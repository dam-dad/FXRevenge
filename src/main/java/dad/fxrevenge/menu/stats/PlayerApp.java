package dad.fxrevenge.menu.stats;

import dad.fxrevenge.models.Avatar;
import dad.fxrevenge.models.ClassType;
import dad.fxrevenge.models.Skill;
import dad.fxrevenge.scene.SceneManager;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Clase que lanzará una prueba de PlayerController para su testeo
 *
 */
public class PlayerApp extends Application {

	private PlayerController controller;

	@Override
	public void start(Stage primaryStage) throws Exception {

		Avatar pj = new Avatar(new Image(getClass().getResource("/image/characters/mage_fIco.png").toExternalForm()),
				ClassType.Archmage, Skill.generateClassSkills(ClassType.Archmage), "Veronica");
		
		controller = new PlayerController(pj);

		SceneManager.setMainStage(primaryStage);
		SceneManager.changeScene(controller);

		primaryStage.setTitle("Inventory TEST");
		primaryStage.setResizable(false);
		primaryStage.show();

	}

	/**
	 * Ejecutamos para que la app aparezca y con ello los atributos del personaje
	 * 
	 * @param args parametros necesario para el lanzamiento de la app
	 */
	public static void main(String[] args) {
		launch(args);
	}

}
