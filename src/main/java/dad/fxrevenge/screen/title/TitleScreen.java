package dad.fxrevenge.screen.title;

import java.util.HashSet;

import dad.fxrevenge.screen.dialog.Dialog;
import dad.fxrevenge.screen.dialog.DialogScreen;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class TitleScreen extends Application {
	

	static Scene mainScene;
	static GraphicsContext graphicsContext;
	
	static Dialog credits;

	// Roberto está usando una pantalla de 1000x800
	// Mi resolución de prueba es 750x600
	static int WIDTH = 750;
	static int HEIGHT = 600;
	
	static Canvas canvas;
	static Image background;

	static HashSet<String> currentlyActiveKeys;

	static Image character;
	static String charName;
	static String textDialog;
	
	static Stage mainStage;

	static int dialogNumber = 0;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage mainStage) {
		
		TitleScreen.mainStage = mainStage;

		mainStage.setTitle("DialogScene");

		Group root = new Group();
		mainScene = new Scene(root, WIDTH, HEIGHT);
		mainStage.setScene(mainScene);

		canvas = new Canvas(mainScene.getWidth(), mainScene.getHeight());
		root.getChildren().add(canvas);

		prepareActionHandlers();

		graphicsContext = canvas.getGraphicsContext2D();
		
		credits = new Dialog(mainScene, graphicsContext);

		loadGraphics();

		/**
		 * Main "game" loop
		 */
		new AnimationTimer() {
			public void handle(long currentNanoTime) {

				tickAndRender();

			}
		}.start();

		mainStage.show();
	}

	private static void prepareActionHandlers() {

		// use a set so duplicates are not possible
		currentlyActiveKeys = new HashSet<String>();

		mainScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				currentlyActiveKeys.add(event.getCode().toString());
			}
		});

	}

	private static void loadGraphics() {

		background = new Image(getResource("/image/title_screen/background.jpg"));

	}

	private static String getResource(String filename) {
		return TitleScreen.class.getResource(filename).toString();
	}

	private static void tickAndRender() {

		canvas.setWidth(mainScene.getWidth());
		canvas.setHeight(mainScene.getHeight());

		// clear canvas
		graphicsContext.clearRect(0, 0, mainScene.getWidth(), mainScene.getHeight());

		graphicsContext.drawImage(background, 0, 0, mainScene.getWidth(), mainScene.getHeight());	

		Font titleFont = Font.font("Arial", FontWeight.BOLD, 100);
		Font pressKeyFont = Font.font("Arial", FontWeight.BOLD, 25);
		
		drawText(titleFont, "FX Revenge", true);
		drawText(pressKeyFont, "Pulsa ENTER para comenzar", false);

		Font creditsFont = Font.font("Arial", FontWeight.NORMAL, 14);
		
		graphicsContext.setFont(creditsFont);
		
		credits.showDialog(
				"Realizado por:",
				"Adán Jiménez Sacramento" + "\n" +
				"Andrés Galván García" + "\n" +
				"Luis Adán Pérez Nazco" + "\n" +
				"Roberto González Linares");

		if (currentlyActiveKeys.contains("ENTER")) {
			currentlyActiveKeys.clear();
			
			// QUE HACER CUANDO SE PULSA LA TECLA ENTER
			
			System.out.println("ENTER pulsado");
		}
	}
	
	private static void drawText(Font font, String text, Boolean isTitle) {
		
		Double x = mainScene.getWidth() / 2;
		Double y = mainScene.getHeight();
		Double offset = (double) 3;
		
		graphicsContext.setTextAlign(TextAlignment.CENTER);
		graphicsContext.setFont(font);
		graphicsContext.setStroke(Color.BLACK);
		graphicsContext.setFill(Color.BLACK);
		graphicsContext.setLineWidth(1);
		
		if (isTitle) {
			y = y / 3;
		} else {
			y = y / 1.75;
		}

		graphicsContext.strokeText(text, x, y);
		graphicsContext.fillText(text, x + offset, y + offset);

		graphicsContext.setFill(Color.WHITE);
		graphicsContext.fillText(text, x, y);
		
	}
}
