package dad.fxrevenge.world;

import dad.fxrevenge.scene.SceneManager;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		SceneManager.setMainStage(primaryStage);
		SceneManager.changeScene(new WorldMapController());

		primaryStage.setTitle("WORLD MAP TEST");
		primaryStage.setResizable(false);
		primaryStage.show();
	}

}
