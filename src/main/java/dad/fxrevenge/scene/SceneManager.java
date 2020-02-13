package dad.fxrevenge.scene;

import javafx.stage.Stage;

public class SceneManager {
	
	private final static int sceneWidth = 800, sceneHeight = 600;

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

	public static int getSceneWidth() {
		return sceneWidth;
	}

	public static int getSceneHeight() {
		return sceneHeight;
	}
	
}
