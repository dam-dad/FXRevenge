package dad.fxrevenge.scene;

import javafx.stage.Stage;

public class SceneManager {

	private static Stage mainStage;
	private static GameScene currentScene;

	public static void setMainStage(Stage stage) {
		mainStage = stage;
	}
	
	public static void changeScene(GameScene newScene) {
		if (currentScene != null)
			currentScene.stop();
		
		newScene.start();
		currentScene = newScene;
		mainStage.setScene(currentScene.getScene());
	}
	
}
