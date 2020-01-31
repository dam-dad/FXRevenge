package fxrevenge.world;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class StrartAPP extends Application {

	private WorldMAPController worldController=new WorldMAPController();
	private static Scene scene;
	@Override
	public void start(Stage primaryStage) throws Exception {
		scene=worldController.getScene();
		primaryStage.setTitle("FX-REVENGE");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	public static Scene getScene() {
		return scene;
	}
	
}
