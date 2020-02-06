package dad.fxrevenge.app;

import dad.fxrevenge.screen.title.TitleScreen;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

public class App extends Application {
	
	private Group root;
	private Canvas canvas;
	private GraphicsContext graphicsContext;
	
	private TitleScreen titleScreen;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.setWidth(800);
		primaryStage.setHeight(600);
		
		root = new Group();
		canvas = new Canvas(primaryStage.getWidth(), primaryStage.getHeight());
		root.getChildren().add(canvas);
		
		graphicsContext = canvas.getGraphicsContext2D();
		
		titleScreen = new TitleScreen(primaryStage, canvas, graphicsContext);
		titleScreen.start();
		
		primaryStage.setTitle("FX Revenge");
		primaryStage.setScene(titleScreen.getScene());
		primaryStage.setResizable(false);
		primaryStage.show();

	}

}
