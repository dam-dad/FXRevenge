package dad.fxrevenge.dialog;

import dad.fxrevenge.boss.VDialog;
import dad.fxrevenge.scene.SceneManager;
import dad.fxrevenge.titlescreen.TitleScreen;
import javafx.application.Application;
import javafx.stage.Stage;

@SuppressWarnings("unused")
public class TestApp extends Application {
	
	private Stage mainStage;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		mainStage = primaryStage;
		SceneManager.setMainStage(mainStage);
		
		mainStage.setWidth(800);
		mainStage.setHeight(600);
		
		SceneManager.changeScene(new VDialog());
		
		mainStage.setTitle("FX Revenge");
		mainStage.setResizable(false);
		mainStage.show();

	}

}
