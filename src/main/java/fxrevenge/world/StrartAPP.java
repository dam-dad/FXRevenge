package fxrevenge.world;

import java.rmi.server.Skeleton;

import fxrevenge.animations.AnimationMobs;
import fxrevenge.animations.SprinteAnimation;
import fxrevenge.animations.TestMove;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

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
