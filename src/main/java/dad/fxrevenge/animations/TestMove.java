package dad.fxrevenge.animations;


import dad.fxrevenge.boss.dialog.*;
import dad.fxrevenge.boss.map.*;
import dad.fxrevenge.models.Avatar;
import dad.fxrevenge.scene.SceneManager;
import dad.fxrevenge.world.Orientation;
import dad.fxrevenge.world.WorldMapController;
import javafx.animation.Animation;
import javafx.animation.Animation.Status;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

public class TestMove {

	private Avatar avatar;
	private ImageView pjImage;
	private Animation pjAni = null;
	private boolean inMove = false;
	private String[][] map;
	private int posX;
	private int posY;
	private int movePX = 50;
	private int animationTime = 900;
	private Orientation orientation = Orientation.SOUTH;

	/**
	 * Constructs an <code>TestMove</code> with the specified detail message.
	 *
	 * @param habitability  collision map based on Strings. "." = Passable; "M" =
	 *                      Enemy; "I" = Interactible Object;
	 * @param movePX        displacement PIXEL;
	 * @param animationTime animation duration in seconds
	 * @param image         sprite sheet
	 * @param minX          The x coordinate of the upper-left corner of the
	 *                      {@code Rectangle2D}
	 * @param minY          The y coordinate of the upper-left corner of the
	 *                      {@code Rectangle2D}
	 * @param width         The width of the {@code Rectangle2D}
	 * @param height        The height of the {@code Rectangle2D}
	 * @param orientation   character visual orientation point
	 */

	public TestMove(String[][] world, int movePX, int animationTime, Avatar avatar, int minX, int minY, int width,
			int heigth, Orientation orientation) {

		this.map = world;
		this.movePX = movePX;
		this.animationTime = animationTime;
		this.avatar=avatar;
		this.pjImage = new ImageView(this.avatar.getWorldSprite());
		pjImage.setViewport(new Rectangle2D(0, 108, 32, 39));
		this.orientation = orientation;
		CheckPlayer();
		System.out.println("Inicio");
		CheckArray();
	}

	public void move(KeyEvent event) {
		if (inMove == false) {
			TranslateTransition transicion = new TranslateTransition();
			int colsX, counts, offset_x, offset_y, width, height;
			if (pjAni != null && pjAni.getStatus() == Status.RUNNING)
				pjAni.stop();
			switch (event.getCode()) {

			case W:
				orientation = Orientation.NORTH;
				pjImage.setViewport(new Rectangle2D(0, 0, 32, 39));
				if ((posY - 1) >= 0 && map[posY - 1][posX] == ".") {
					inMove = true;
					colsX = 3;
					counts = 3;
					offset_x = 0;
					offset_y = 0;
					width = 32;
					height = 39;
					pjAni = new SprinteAnimation(pjImage, Duration.millis(animationTime), colsX, counts, offset_x,
							offset_y, width, height);
					pjAni.setCycleCount(0);
					pjAni.play();
					transicion = new TranslateTransition();
					double nextPos = pjImage.getY() - movePX;
					transicion.setToY(-movePX);
					transicion.setNode(pjImage);
					transicion.setInterpolator(Interpolator.EASE_BOTH);
					transicion.setOnFinished(e -> {
						pjImage.setY(nextPos);
						pjImage.setTranslateY(0);
						inMove = false;
						pjImage.setViewport(new Rectangle2D(0, 0, 32, 39));
						map[posY - 1][posX] = "P";
						map[posY][posX] = ".";
						posY--;

					});

					transicion.play();
				}

				// Pasar del mapa principal a la cueva de Valery
				if ((posY - 1) >= 0 && map[posY - 1][posX] == "VM") {
					SceneManager.changeScene(new VMap(avatar));
				} else if ((posY - 1) >= 0 && map[posY - 1][posX] == "WM") {
					SceneManager.changeScene(new WorldMapController(avatar));
				}

//			pjImage.setX(pjImage.getX()pjImage.getX());
				break;
			case D:
				orientation = Orientation.EAST;
				pjImage.setViewport(new Rectangle2D(0, 36, 32, 39));
				if ((posX + 1) < map[0].length && map[posY][posX + 1] == ".") {
					inMove = true;
					colsX = 3;
					counts = 3;
					offset_x = 0;
					offset_y = 36;
					width = 32;
					height = 39;
					pjAni = new SprinteAnimation(pjImage, Duration.millis(animationTime), colsX, counts, offset_x,
							offset_y, width, height);
					pjAni.setCycleCount(0);
					pjAni.play();
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
						pjImage.setViewport(new Rectangle2D(0, 36, 32, 39));
					});
					transicion.play();

				}

				// Pasar del mapa principal al castillo de Calipso
				if ((posX + 1) < map[0].length && map[posY][posX + 1] == "CM") {
					SceneManager.changeScene(new CMap(this.avatar));
				} else if ((posX + 1) < map[0].length && map[posY][posX + 1] == "WM") {
					SceneManager.changeScene(new WorldMapController(avatar));
				}

				break;
			case A:
				orientation = Orientation.WEST;
				pjImage.setViewport(new Rectangle2D(0, 108, 32, 39));
				if ((posX - 1) >= 0 && map[posY][posX - 1] == ".") {
					inMove = true;
					colsX = 3;
					counts = 3;
					offset_x = 0;
					offset_y = 108;
					width = 32;
					height = 39;
					pjAni = new SprinteAnimation(pjImage, Duration.millis(animationTime), colsX, counts, offset_x,
							offset_y, width, height);
					pjAni.setCycleCount(0);
					pjAni.play();
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
						pjImage.setViewport(new Rectangle2D(0, 108, 32, 39));
					});
					transicion.play();

				}

				// Pasar del mapa principal al bosque de Meridio
				if ((posX - 1) >= 0 && map[posY][posX - 1] == "MM") {
					SceneManager.changeScene(new MMap(avatar));
				} else if ((posX - 1) >= 0 && map[posY][posX - 1] == "WM") {
					SceneManager.changeScene(new WorldMapController(avatar));
				}

				break;
			case S:
				orientation = Orientation.SOUTH;
				pjImage.setViewport(new Rectangle2D(0, 72, 32, 39));
				if ((posY + 1) < map.length && map[posY + 1][posX] == ".") {
					inMove = true;
					colsX = 3;
					counts = 3;
					offset_x = 0;
					offset_y = 72;
					width = 32;
					height = 39;
					pjAni = new SprinteAnimation(pjImage, Duration.millis(animationTime), colsX, counts, offset_x,
							offset_y, width, height);
					pjAni.setCycleCount(0);
					pjAni.play();
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
						pjImage.setViewport(new Rectangle2D(0, 72, 32, 39));
					});
					transicion.play();
				}

				// Volver al World Map
				if ((posY + 1) < map.length && map[posY + 1][posX] == "WM") {
					SceneManager.changeScene(new WorldMapController(avatar));
				}

				break;

			case E:
				inMove = true;
				interaction();
				System.out.println("----");
				inMove = false;
				System.out.println(inMove);
				break;
			default:

				break;
			}
		}

	}

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
			break;
		}

		switch (interaction) {
		case "N/A":
			break;
		case "M":
			SceneManager.changeScene(new MDialog(avatar));
			break;
		case "V":
			SceneManager.changeScene(new VDialog(avatar));
			break;
		case "C":
			SceneManager.changeScene(new CDialog(avatar));
			break;
		case "FX":
			SceneManager.changeScene(new FXDialog(avatar));
			break;
		case "L":
			SceneManager.changeScene(new FXMap(avatar));
			break;

		}

	}

	private void CheckArray() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j] + "\t");
			}
			System.out.println();
		}
	}

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
}
