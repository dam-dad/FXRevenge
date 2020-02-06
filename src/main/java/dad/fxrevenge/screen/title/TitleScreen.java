package dad.fxrevenge.screen.title;

import java.util.HashSet;

import dad.fxrevenge.screen.dialog.Dialog;
import dad.fxrevenge.screen.dialog.IntroDialogScreen;
import javafx.animation.AnimationTimer;
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

public class TitleScreen {

	private Image background = new Image("/image/title_screen/background.jpg");

	private Stage stage;

	private Group root = new Group();
	private Scene scene = new Scene(root);

	private Canvas canvas;
	private GraphicsContext graphicsContext;

	private HashSet<String> currentlyActiveKeys;

	private Dialog dialog;

	public TitleScreen(Stage stage, Canvas canvas, GraphicsContext graphicContext) {
		this.stage = stage;
		this.canvas = canvas;
		this.graphicsContext = graphicContext;
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

		Font titleFont = Font.font("Arial", FontWeight.BOLD, 100);
		Font pressKeyFont = Font.font("Arial", FontWeight.BOLD, 25);
		Font creditsFont = Font.font("Arial", FontWeight.NORMAL, 15);

		drawText(titleFont, "FX Revenge", true);
		drawText(pressKeyFont, "Pulsa ENTER para comenzar", false);

		graphicsContext.setFont(creditsFont);

		dialog.showDialog("Realizado por:", "Adán Jiménez Sacramento" + "\n" + "Andrés Galván García" + "\n"
				+ "Luis Adán Pérez Nazco" + "\n" + "Roberto González Linares");

		if (currentlyActiveKeys.contains("ENTER")) {
			currentlyActiveKeys.clear();

			// QUE HACER CUANDO SE PULSA LA TECLA ENTER

			loadIntroDialog();

			System.out.println("ENTER pulsado");
		}

	}

	private void drawText(Font font, String text, Boolean isTitle) {

		Double x = canvas.getWidth() / 2;
		Double y = canvas.getHeight();
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

	private void loadIntroDialog() {

		// Limpiar el canvas
		graphicsContext.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

		// Iniciar pantalla de diálogo
		IntroDialogScreen introDialog = new IntroDialogScreen(stage, canvas, graphicsContext);
		introDialog.start();

		// Cambiar la escena a la pantalla de diálogo
		stage.setScene(introDialog.getScene());
	}

	public Scene getScene() {
		return scene;
	}

}
