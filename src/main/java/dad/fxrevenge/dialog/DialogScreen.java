package dad.fxrevenge.dialog;

import java.util.HashSet;
import dad.fxrevenge.dialog.character.Character;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class DialogScreen {
	
	@SuppressWarnings("unused")
	private Stage stage;

	private Group root = new Group();
	private Scene scene = new Scene(root);

	private Canvas canvas;
	private GraphicsContext graphicsContext;

	private HashSet<String> currentlyActiveKeys;

	protected Image background, leftCharacter, rightCharacter;

	private Dialog dialog;
	protected int dialogNumber = 0;

	public DialogScreen(Stage stage, Canvas canvas, GraphicsContext graphicContext) {
		this.stage = stage;
		this.canvas = canvas;
		this.graphicsContext = graphicContext;
	}

	public void setGraphics(Image background, Character leftCharacter, Character rightCharacter) {
		this.background = background;
		this.leftCharacter = leftCharacter.getPortrait();
		this.rightCharacter = rightCharacter.getPortrait();
	}

	public void start() {

		root.getChildren().add(canvas);
		graphicsContext = canvas.getGraphicsContext2D();

		dialog = new Dialog(scene, graphicsContext);

		prepareActionHandlers();

		// Main "game" loop
		new AnimationTimer() {
			public void handle(long currentNanoTime) {
				tickAndRender();
			}
		}.start();

	}

	private void prepareActionHandlers() {

		// use a set so duplicates are not possible
		currentlyActiveKeys = new HashSet<String>();

		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				currentlyActiveKeys.add(event.getCode().toString());
			}
		});
	}

	protected void tickAndRender() {

		// Redimensionar canvas
		canvas.setWidth(scene.getWidth());
		canvas.setHeight(scene.getHeight());

		// Limpiar canvas
		graphicsContext.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

		// Dibujar fondo
		graphicsContext.drawImage(background, 0, 0, canvas.getWidth(), canvas.getHeight());

		// Si se presiona la flecha izquierda volver al diálogo anterior
		if (currentlyActiveKeys.contains("LEFT")) {
			currentlyActiveKeys.clear();
			if (dialogNumber > 0)
				dialogNumber--;
		}

		// Si se presiona la flecha derecha avanzar al diálogo siguiente
		if (currentlyActiveKeys.contains("RIGHT")) {
			currentlyActiveKeys.clear();
			dialogNumber++;
		}

	}

	protected void CharacterTalking(Character character, String dialogText) {

		if (character.getIsLeft()) {
			graphicsContext.drawImage(character.getPortrait(), scene.getWidth() / 6, scene.getHeight() / 7);
		} else {
			graphicsContext.drawImage(character.getPortrait(), scene.getWidth() / 2, scene.getHeight() / 7);
		}

		dialog.showDialog(character.getName(), dialogText);
	}

	public Scene getScene() {
		return scene;
	}

}
