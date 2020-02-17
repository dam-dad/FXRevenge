package dad.fxrevenge.menu.bestiary;

import dad.fxrevenge.scene.SceneManager;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Clase que lanzará una prueba de BestiaryController para su testeo
 * 
 * @author Adan
 *
 */
public class BestiaryApp extends Application {

	private BestiaryController controller;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		controller = new BestiaryController();
		
		SceneManager.setMainStage(primaryStage);
		SceneManager.changeScene(controller);
		
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
