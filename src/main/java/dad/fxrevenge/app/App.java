package dad.fxrevenge.app;

import dad.fxrevenge.scene.SceneManager;
import dad.fxrevenge.screen.TitleScreen;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class App extends Application {
	
	private Stage mainStage;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		mainStage = primaryStage;
		SceneManager.setMainStage(mainStage);
		
		mainStage.initStyle(StageStyle.UNDECORATED);
		mainStage.setWidth(800);
		mainStage.setHeight(600);
		
		SceneManager.changeScene(new TitleScreen());
		
		mainStage.setTitle("FX Revenge");
		mainStage.setResizable(false);
		mainStage.show();

	}

}
