package dad.fxrevenge.scene;

import javafx.stage.Stage;

public class SceneManager {

	private static Stage mainStage;
	private static Scene currentScene;

	public static void setMainStage(Stage stage) {
		mainStage = stage;
	}
	
	public static void changeScene(Scene newScene) {
		if (currentScene != null)
			currentScene.unload();
		
		newScene.load();
		currentScene = newScene;
		mainStage.setScene(currentScene.getScene());
	}
}
