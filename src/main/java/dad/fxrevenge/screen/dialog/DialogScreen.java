package dad.fxrevenge.screen.dialog;

import java.util.HashSet;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class DialogScreen extends Application {

	static Scene mainScene;
	static GraphicsContext graphicsContext;

	static Dialog dialog;

	// Roberto está usando una pantalla de 1000x800
	// Mi resolución de prueba es 750x600
	static int WIDTH = 750;
	static int HEIGHT = 600;

	static Canvas canvas;
	static Image background;

	static Image leftCharacter;
	static Image rightCharacter;

	static Image left;
	static Image leftGreen;

	static Image right;
	static Image rightGreen;

	static HashSet<String> currentlyActiveKeys;

	static Image character;
	static String charName;
	static String textDialog;
	static Group root = new Group();
	static int dialogNumber = 0;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage mainStage) {

		mainStage.setTitle("DialogScene");

		
		mainScene = new Scene(root, WIDTH, HEIGHT);
		mainStage.setScene(mainScene);

		canvas = new Canvas(mainScene.getWidth(), mainScene.getHeight());
		root.getChildren().add(canvas);

		prepareActionHandlers();

		graphicsContext = canvas.getGraphicsContext2D();

		dialog = new Dialog(mainScene, graphicsContext);

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
		
		background = new Image("/img/background.jpg");

		leftCharacter = new Image("img/all_might.png");
		rightCharacter = new Image("img/all_might.png");

		left = new Image(getResource("/img/left.png"));
		leftGreen = new Image(getResource("/img/leftG.png"));

		right = new Image(getResource("/img/right.png"));
		rightGreen = new Image(getResource("/img/rightG.png"));

	}

	private static String getResource(String filename) {
		return DialogScreen.class.getResource(filename).toString();
	}

	private static void tickAndRender() {

		canvas.setWidth(mainScene.getWidth());
		canvas.setHeight(mainScene.getHeight());

		// clear canvas
		graphicsContext.clearRect(0, 0, WIDTH, HEIGHT);

		graphicsContext.drawImage(background, 0, 0, mainScene.getWidth(), mainScene.getHeight());

		switch (dialogNumber) {

		case 0:
			CharacterTalking(leftCharacter, "MVC", "Mi venganza será terrible", true);
			break;

		case 1:
			CharacterTalking(rightCharacter, "Mr. FX", "Y la mía también", false);
			break;

		default:
			CharacterTalking(null, "(...)", "(Nadie está hablando...)", false);

		}

		if (currentlyActiveKeys.contains("LEFT"))
        {
			currentlyActiveKeys.clear();
            graphicsContext.drawImage(leftGreen, 10 ,10);
            
            if (dialogNumber > 0) dialogNumber--;
            System.out.println(dialogNumber);
        } else {
            graphicsContext.drawImage(left, 10 ,10);
        }

        if (currentlyActiveKeys.contains("RIGHT")) {
        	currentlyActiveKeys.clear();
            graphicsContext.drawImage(rightGreen, mainScene.getWidth() - 64 - 10, 10);
            
            dialogNumber++;
            System.out.println(dialogNumber);
        } else {
            graphicsContext.drawImage(right, mainScene.getWidth() - 64 - 10, 10);
        }
	}

	private static void CharacterTalking(Image image, String characterName, String dialogText,
			Boolean isLeftCharacter) {

		if (isLeftCharacter) {
			graphicsContext.drawImage(image, mainScene.getWidth() / 6, mainScene.getHeight() / 7);
		} else {
			graphicsContext.drawImage(image, mainScene.getWidth() / 2, mainScene.getHeight() / 7);
		}

		dialog.showDialog(characterName, dialogText);

	}
	
	public static Group getRoot() {
		return root;
	}
	
	public static Scene getScene() {
		return mainScene;
	}

}
