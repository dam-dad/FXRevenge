package dad.fxrevenge.scene;

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

/**
 * Clase (padre) que controla la pantalla de diálogos entre personajes
 **/

public class DialogScene extends dad.fxrevenge.scene.Scene {

	// Nodo padre del canvas
	private Group root;

	// Escena que se creará a partir del nodo root
	protected Scene scene;

	// Clase encargada de renderizar la escena
	private AnimationTimer animationTimer;

	// Lienzo (canvas) sobre el que dibujar la escena
	protected Canvas canvas;
	protected GraphicsContext graphicsContext;

	// Hashset en el que se registrarán las teclas que se vayan presionando
	protected HashSet<String> currentlyActiveKeys;

	// Gráficos de la escena: fondo y retrato de los personajes izquierdo y derecho
	private Image background, leftCharacter, rightCharacter;

	// Clase encargada de dibujar el texto de los diálogos
	protected Dialog dialog;

	// Variable encargada de que se muestre el diálogo correspondiente
	protected int dialogNumber = 0;

	// Función para asignar los gráficos: imagen de fondo y los personajes que
	// aparecerán en la escena
	public void setGraphics(Image background, Character leftCharacter, Character rightCharacter) {
		this.background = background;
		this.leftCharacter = leftCharacter.getPortrait();
		this.rightCharacter = rightCharacter.getPortrait();
	}

	// Función que inicia la escena
	@Override
	public void load() {
		
		canvas = new Canvas();
		graphicsContext = canvas.getGraphicsContext2D();
		
		root = new Group();
		scene = new Scene(root);
		root.getChildren().add(canvas);
		
		dialog = new Dialog(scene, graphicsContext);

		prepareActionHandlers();

		// Bucle principal que controla la escena
		animationTimer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				update();
			}
		};

		animationTimer.start();

	}

	// Función que detiene la escena
	@Override
	public void unload() {
		animationTimer.stop();
	}

	// Función que controla la entrada por teclado
	private void prepareActionHandlers() {

		// HashSet que registrará las teclas que se vayan presionando
		currentlyActiveKeys = new HashSet<String>();

		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				// Añade la tecla presionada al HashSet
				currentlyActiveKeys.add(event.getCode().toString());
			}
		});

	}

	// Función que se ejecuta dentro del bucle principal
	@Override
	protected void update() {
		
		// Redimensionar canvas
		canvas.setWidth(scene.getWidth());
		canvas.setHeight(scene.getHeight());

		// Limpiar canvas
		graphicsContext.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

		// Dibujar fondo
		graphicsContext.drawImage(background, 0, 0, canvas.getWidth(), canvas.getHeight());

		// Si se presiona la flecha izquierda vuelve al diálogo anterior
		if (currentlyActiveKeys.contains("LEFT")) {
			currentlyActiveKeys.clear();
			if (dialogNumber > 0)
				dialogNumber--;
		}

		// Si se presiona la flecha derecha avanza al diálogo siguiente
		if (currentlyActiveKeys.contains("RIGHT")) {
			currentlyActiveKeys.clear();
			dialogNumber++;
		}

	}

	// Función que controla los diálogos de los personajes
	protected void CharacterTalking(Character character, String dialogText) {

		// Determinar el lado de la pantalla en el que debe mostrarse el retrato del
		// personaje y dibujarlo
		if (character.getIsLeft()) {
			graphicsContext.drawImage(character.getPortrait(), scene.getWidth() / 6, scene.getHeight() / 7);
		} else {
			graphicsContext.drawImage(character.getPortrait(), scene.getWidth() / 2, scene.getHeight() / 7);
		}

		// Dibujar diálogo del personaje
		dialog.showDialog(character.getName(), dialogText);
	}

	// GETTERS Y SETTERS

	// Scene
	public Scene getScene() {
		return scene;
	}

	// Stage
	/*
	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}
	*/

	// Imagen de Fondo
	public Image getBackground() {
		return background;
	}

	public void setBackground(Image background) {
		this.background = background;
	}

	// Imagen del personaje izquierdo
	public Image getLeftCharacter() {
		return leftCharacter;
	}

	public void setLeftCharacter(Image leftCharacter) {
		this.leftCharacter = leftCharacter;
	}

	// Imagen del personaje derecho
	public Image getRightCharacter() {
		return rightCharacter;
	}

	public void setRightCharacter(Image rightCharacter) {
		this.rightCharacter = rightCharacter;
	}

}
