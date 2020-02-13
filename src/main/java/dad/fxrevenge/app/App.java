package dad.fxrevenge.app;

import dad.fxrevenge.scene.SceneManager;
import dad.fxrevenge.screen.TitleScreen;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		SceneManager.setMainStage(primaryStage);
		SceneManager.changeScene(new TitleScreen());

		primaryStage.setTitle("FX Revenge");
		primaryStage.setResizable(false);
		primaryStage.show();
	}

}
