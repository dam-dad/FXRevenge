package dad.fxrevenge.test;

import dad.fxrevenge.scene.SceneManager;
import dad.fxrevenge.screen.CDialog;
import dad.fxrevenge.screen.FXDialog;
import dad.fxrevenge.screen.MDialog;
import dad.fxrevenge.screen.TitleScreen;
import dad.fxrevenge.screen.VDialog;
import javafx.application.Application;
import javafx.stage.Stage;

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
