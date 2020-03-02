package dad.fxrevenge.animations;

import java.io.IOException;

import dad.fxrevenge.boss.dialog.CDialog;
import dad.fxrevenge.boss.dialog.FXDialog;
import dad.fxrevenge.boss.dialog.MDialog;
import dad.fxrevenge.boss.dialog.VDialog;
import dad.fxrevenge.boss.map.CMap;
import dad.fxrevenge.boss.map.FXMap;
import dad.fxrevenge.boss.map.MMap;
import dad.fxrevenge.boss.map.Overworld;
import dad.fxrevenge.boss.map.VMap;
import dad.fxrevenge.models.Vendor;
import dad.fxrevenge.parameters.Player;
import dad.fxrevenge.scene.SceneManager;
import dad.fxrevenge.shop.ShopController;
import dad.fxrevenge.world.Orientation;
import javafx.animation.Animation;
import javafx.animation.Animation.Status;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

/**
 * Clase <code>TestMove</code>.
 * 
 * Encargada de establecer el movimiento y el traspaso de mapas al igual que la
 * interactuación con los personajes.
 */
public class PlayerMove {

	private ImageView pjImage;
	private Animation pjAni = null;
	private boolean inMove = false;
	private boolean newPos = false;
	private int width;
	private int heigth;
	private String[][] map;
	private int posX;
	private int posY;
	private int movePX = 50;
	private int[][] offset;
	private int colsX, counts;
	private int animationTime = 900;
	private Orientation orientation = Orientation.SOUTH;

	/**
	 * Constructs an <code>TestMove</code> with the specified detail message.
	 *
	 * @param world         Mapa de coliciones Matriz Strings. "." = Caminable; "M"
	 *                      = Enemigo; "I" = Entidad interactuable;
	 * @param movePX        Deplacamiento en pixeles;
	 * @param animationTime duración de las tranciciones;
	 * @param width         ancho del fragmento de imagen a dibujar
	 * @param heigth        alto del fragmento de imagen a dibujar
	 * @param orientation   puntero virtual para saber donde apunta la imagen.
	 * @param colsX         Número de columnas del personaje en el sprite.
	 * @param counts        Número de filas o contador
	 * @param offset        Una matrix de valores enteros que especifican en el
	 *                      cambio del pixeles entre animación Movimiento hacia
	 *                      arriba W [0][0] deplazamiento en columna, [0][1]
	 *                      desplazamiento en fila Movimiento hacia la derecha D
	 *                      [1][0] deplazamiento en columna, [1][1] desplazamiento
	 *                      en fila Movimiento hacia izquierda A [2][0]
	 *                      deplazamiento en columna, [2][1] desplazamiento en fila
	 *                      Movimiento hacia abajo S [3][0] deplazamiento en
	 *                      columna, [3][1] desplazamiento en fila
	 */

	public PlayerMove(String[][] world, int movePX, int animationTime, int width, int heigth, Orientation orientation,
			int colsX, int counts, int[][] offset) {

		this.map = world;
		this.movePX = movePX;
		this.animationTime = animationTime;
		this.width = width;
		this.heigth = heigth;
		this.offset = offset;
		this.colsX = colsX;
		this.counts = counts;
		this.pjImage = new ImageView(Player.getPlayer().getWorldSprite());
		pjImage.setViewport(new Rectangle2D(0, 108, this.width, this.heigth));
		this.orientation = orientation;
		CheckPlayer();
	}

	/**
	 * Función <code>move</code>.
	 * 
	 * Según el evento del teclado que se le pase, realizará tareas de movimiento en
	 * un sentido concreto(W/D/S/A). O si es la E el jugador interactura con los
	 * personajes que lo permitan.
	 */
	public void move(KeyEvent event) {
		if (inMove == false) {
			TranslateTransition transicion = new TranslateTransition();
			int offset_x, offset_y;
			if (pjAni != null && pjAni.getStatus() == Status.RUNNING)
				pjAni.stop();
			switch (event.getCode()) {

			case W:
				orientation = Orientation.NORTH;
				// Animación
				pjImage.setViewport(new Rectangle2D(0, 0, this.width, this.heigth));
				if ((posY - 1) >= 0 && map[posY - 1][posX] == ".") {
					inMove = true;
					pjAni = new SprinteAnimation(pjImage, Duration.millis(animationTime), counts, colsX, offset[0][0],
							offset[0][1], this.width, this.heigth);
					pjAni.setCycleCount(0);
					pjAni.play();
					// Transicion de movimiento
					transicion = new TranslateTransition();
					double nextPos = pjImage.getY() - movePX;
					transicion.setToY(-movePX);
					transicion.setNode(pjImage);
					transicion.setInterpolator(Interpolator.EASE_BOTH);
					transicion.setOnFinished(e -> {
						pjImage.setY(nextPos);
						pjImage.setTranslateY(0);
						inMove = false;
						newPos = true;
						pjImage.setViewport(new Rectangle2D(0, 0, this.width, this.heigth));
						map[posY - 1][posX] = "P";
						map[posY][posX] = ".";
						posY--;

					});

					transicion.play();
				}

				// Pasar del mapa principal a la cueva de Valery
				if ((posY - 1) >= 0 && map[posY - 1][posX] == "VM") {
					SceneManager.changeScene(new VMap());
				} else if ((posY - 1) >= 0 && map[posY - 1][posX] == "WM") {
					SceneManager.changeScene(new Overworld());
				}

//			pjImage.setX(pjImage.getX()pjImage.getX());
				break;
			case D:
				orientation = Orientation.EAST;
				pjImage.setViewport(new Rectangle2D(0, 36, this.width, this.heigth));
				if ((posX + 1) < map[0].length && map[posY][posX + 1] == ".") {
					inMove = true;
					// Animación
					pjAni = new SprinteAnimation(pjImage, Duration.millis(animationTime), counts, colsX, offset[1][0],
							offset[1][1], this.width, this.heigth);
					pjAni.setCycleCount(0);
					pjAni.play();
					// Transicion de movimiento
					transicion = new TranslateTransition();
					double nextPos2 = pjImage.getX() + movePX;
					transicion.setToX(movePX);
					transicion.setNode(pjImage);
					transicion.setInterpolator(Interpolator.EASE_BOTH);
					transicion.setOnFinished(e -> {
						pjImage.setX(nextPos2);
						pjImage.setTranslateX(0);
						map[posY][posX + 1] = "P";
						map[posY][posX] = ".";
						posX++;
						inMove = false;
						newPos = true;
						pjImage.setViewport(new Rectangle2D(0, 36, this.width, this.heigth));
					});
					transicion.play();

				}

				// Pasar del mapa principal al castillo de Calipso
				if ((posX + 1) < map[0].length && map[posY][posX + 1] == "CM") {
					SceneManager.changeScene(new CMap());
				} else if ((posX + 1) < map[0].length && map[posY][posX + 1] == "WM") {
					SceneManager.changeScene(new Overworld());
				}

				break;
			case A:
				orientation = Orientation.WEST;
				pjImage.setViewport(new Rectangle2D(0, 108, this.width, this.heigth));
				if ((posX - 1) >= 0 && map[posY][posX - 1] == ".") {
					inMove = true;

					// Animación
					pjAni = new SprinteAnimation(pjImage, Duration.millis(animationTime), counts, colsX, offset[2][0],
							offset[2][1], this.width, this.heigth);
					pjAni.setCycleCount(0);
					pjAni.play();
					// Transicion de movimiento
					transicion = new TranslateTransition();
					double nextPos3 = pjImage.getX() - movePX;
					transicion.setToX(-movePX);
					transicion.setNode(pjImage);
					transicion.setInterpolator(Interpolator.EASE_BOTH);
					transicion.setOnFinished(e -> {
						pjImage.setX(nextPos3);
						pjImage.setTranslateX(0);
						map[posY][posX - 1] = "P";
						map[posY][posX] = ".";
						posX--;
						inMove = false;
						newPos = true;
						pjImage.setViewport(new Rectangle2D(0, 108, this.width, this.heigth));
					});
					transicion.play();

				}

				// Pasar del mapa principal al bosque de Meridio
				if ((posX - 1) >= 0 && map[posY][posX - 1] == "MM") {
					SceneManager.changeScene(new MMap());
				} else if ((posX - 1) >= 0 && map[posY][posX - 1] == "WM") {
					SceneManager.changeScene(new Overworld());
				}

				break;
			case S:
				orientation = Orientation.SOUTH;
				pjImage.setViewport(new Rectangle2D(0, 72, this.width, this.heigth));
				if ((posY + 1) < map.length && map[posY + 1][posX] == ".") {
					inMove = true;
					// Animación
					pjAni = new SprinteAnimation(pjImage, Duration.millis(animationTime), counts, colsX, offset[3][0],
							offset[3][1], this.width, this.heigth);
					pjAni.setCycleCount(0);
					pjAni.play();
					// Transicion de movimiento
					transicion = new TranslateTransition();
					double nextPos4 = pjImage.getY() + movePX;
					transicion.setToY(+movePX);
					transicion.setNode(pjImage);
					transicion.setInterpolator(Interpolator.EASE_BOTH);
					transicion.setOnFinished(e -> {
						pjImage.setY(nextPos4);
						pjImage.setTranslateY(0);
						map[posY + 1][posX] = "P";
						map[posY][posX] = ".";
						posY++;
						inMove = false;
						newPos = true;
						pjImage.setViewport(new Rectangle2D(0, 72, this.width, this.heigth));
					});
					transicion.play();
				}

				// Volver al World Map
				if ((posY + 1) < map.length && map[posY + 1][posX] == "WM") {
					SceneManager.changeScene(new Overworld());
				}

				break;

			case E:
				inMove = true;
				interaction();
				inMove = false;
				newPos = false;
				break;
			default:
				newPos = false;
				break;
			}
		}

	}

	/**
	 * Función <code>interaction</code>.
	 * 
	 * Encargada de disparar,Eventos,... Cuando el jugador este a una casilla de una
	 * entidad y este la este mirando hacia el objetivo
	 *
	 */
	private void interaction() {

		String interaction = "N/A";

		switch (orientation) {
		case NORTH:
			if ((posY - 1) >= 0 && map[posY - 1][posX] == "M")
				interaction = "M";
			else if ((posY - 1) >= 0 && map[posY - 1][posX] == "V")
				interaction = "V";
			else if ((posY - 1) >= 0 && map[posY - 1][posX] == "C")
				interaction = "C";
			else if ((posY - 1) >= 0 && map[posY - 1][posX] == "FX")
				interaction = "FX";
			else if ((posY - 1) >= 0 && map[posY - 1][posX] == "L")
				interaction = "L";
			else if ((posY - 1) >= 0 && map[posY - 1][posX] == "S")
				interaction = "S";
			break;
		case EAST:
			if ((posX + 1) < map[0].length && map[posY][posX + 1] == "M")
				interaction = "M";
			else if ((posX + 1) < map[0].length && map[posY][posX + 1] == "V")
				interaction = "V";
			else if ((posX + 1) < map[0].length && map[posY][posX + 1] == "C")
				interaction = "C";
			else if ((posX + 1) < map[0].length && map[posY][posX + 1] == "FX")
				interaction = "FX";
			else if ((posX + 1) < map[0].length && map[posY][posX + 1] == "L")
				interaction = "L";
			else if ((posX + 1) < map[0].length && map[posY][posX + 1] == "S")
				interaction = "S";
			break;
		case WEST:
			if ((posX - 1) >= 0 && map[posY][posX - 1] == "M")
				interaction = "M";
			else if ((posX - 1) >= 0 && map[posY][posX - 1] == "V")
				interaction = "V";
			else if ((posX - 1) >= 0 && map[posY][posX - 1] == "C")
				interaction = "C";
			else if ((posX - 1) >= 0 && map[posY][posX - 1] == "FX")
				interaction = "FX";
			else if ((posX - 1) >= 0 && map[posY][posX - 1] == "L")
				interaction = "L";
			else if ((posX - 1) >= 0 && map[posY][posX - 1] == "S")
				interaction = "S";
			break;
		case SOUTH:
			if ((posY + 1) < map.length && map[posY + 1][posX] == "M")
				interaction = "M";
			else if ((posY + 1) < map.length && map[posY + 1][posX] == "V")
				interaction = "V";
			else if ((posY + 1) < map.length && map[posY + 1][posX] == "C")
				interaction = "C";
			else if ((posY + 1) < map.length && map[posY + 1][posX] == "FX")
				interaction = "FX";
			else if ((posY + 1) < map.length && map[posY + 1][posX] == "L")
				interaction = "L";
			else if ((posY + 1) < map.length && map[posY + 1][posX] == "S")
				interaction = "S";
			break;
		}

		switch (interaction) {
		case "N/A":
			break;
		case "M":
			SceneManager.changeScene(new MDialog());
			break;
		case "V":
			SceneManager.changeScene(new VDialog());
			break;
		case "C":
			SceneManager.changeScene(new CDialog());
			break;
		case "FX":
			SceneManager.changeScene(new FXDialog());
			break;
		case "L":
			SceneManager.changeScene(new FXMap());
			break;
		case "S":
			try {
				SceneManager.changeScene(new ShopController(Player.getPlayer(), new Vendor()));
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	/**
	 * Función <code>CheckArray</code> para developers.
	 * 
	 * Simplemente muestra el mapa actual por terminal.
	 */
	private void CheckArray() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j] + "\t");
			}
			System.out.println();
		}
	}

	/**
	 * Función <code>CheckPlayer</code>.
	 * 
	 * Localiza la ubicación para que la clase TestMove sepa donde empieza el
	 * jugador. Permitiendo que se pueda matipular de forma correcta el movimiento
	 */
	private void CheckPlayer() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (map[i][j].equals("P")) {
					posX = j;
					posY = i;
				}
			}
		}
	}

	public ImageView getPjImage() {
		return pjImage;
	}

	public boolean isNewPos() {
		return newPos;
	}
}
