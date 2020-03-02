package dad.fxrevenge.combat;

import dad.fxrevenge.models.Avatar;
import dad.fxrevenge.models.ClassType;
import dad.fxrevenge.models.Enemy;
import dad.fxrevenge.models.Race;
import dad.fxrevenge.models.Skill;
import dad.fxrevenge.scene.SceneManager;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Clase que lanzará una prueba de CombatController para su testeo
 *
 */
public class CombatApp extends Application {

	// Imagen de fondo del combate
//	private Image backgroundImage = new Image("/image/background/c.png");
	private Image backgroundImage = new Image("/image/background/fx.png");
//	private Image backgroundImage = new Image("/image/background/m.png");
//	private Image backgroundImage = new Image("/image/background/v.png");

	private CombatController controller;
	private Avatar pj = new Avatar(new Image(getClass().getResource("/image/characters/select/m/warrior.png").toString()),
			ClassType.Warlord, Skill.generateClassSkills(ClassType.Warlord), "Rayo");

	@Override
	public void start(Stage primaryStage) throws Exception {

		Enemy bichito = new Enemy(Race.FX, 1);
		controller = new CombatController(pj, bichito, backgroundImage);

		SceneManager.setMainStage(primaryStage);
		SceneManager.changeScene(controller); // SceneManager coge la Scene del controller directamente y la inicia

		primaryStage.setTitle("COMBAT TEST");
		primaryStage.setResizable(false);
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
