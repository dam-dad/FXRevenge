package dad.fxrevenge.menu.bestiary;

import dad.fxrevenge.models.Enemy;
import dad.fxrevenge.models.Race;
import dad.fxrevenge.scene.SceneManager;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Clase que lanzará una prueba de BestiaryController para su testeo
 * 
 * @author Adan
 *
 */
public class BestiaryApp extends Application {

	private BestiaryController controller;
	
	private Enemy bichito = new Enemy(Race.Jelly, 1);
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		bichito.setAppearance(new Image(getClass().getResource("/images/chest.png").toString()));
		
		controller = new BestiaryController(bichito);
		
		SceneManager.setMainStage(primaryStage);
		SceneManager.changeScene(controller); // SceneManager coge la Scene del controller directamente y la inicia
		
		primaryStage.setTitle("Bestiary TEST");
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
