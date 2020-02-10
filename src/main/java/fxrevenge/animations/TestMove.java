package fxrevenge.animations;

import dad.fxrevenge.combat.App2;
import dad.fxrevenge.dialog.screen.VDialog;
import dad.fxrevenge.scene.SceneManager;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.animation.Animation.Status;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class TestMove {

	private static ImageView pjImage;
	private Animation pjAni = null;
	private boolean inMove = false;
	private boolean[][] map;
	private int myPosX;
	private int myPosY;
	private int movePX=50;
	private int aniS=900;
	
	public TestMove(boolean[][] habitability, int colX, int rowY) {
		pjImage = new ImageView(new Image("./Image/characters/mage_f.png"));
		pjImage.setViewport(new Rectangle2D(0, 108, 32, 39));
		map = habitability;
		myPosX = colX;
		myPosY = rowY;

	}

	public void move(KeyEvent event) {
		if (inMove == false) {
			TranslateTransition transicion = new TranslateTransition();
			int colsX, counts, offset_x, offset_y, width, height;
			if (pjAni != null && pjAni.getStatus() == Status.RUNNING)
				pjAni.stop();
			switch (event.getCode()) {

			case W:
				if ((myPosY-1) >= 0 && map[myPosY - 1][myPosX] == true) {
					inMove = true;
					colsX = 3;
					counts = 3;
					offset_x = 0;
					offset_y = 36;
					width = 32;
					height = 39;
					pjAni = new SprinteAnimation(pjImage, Duration.millis(aniS), colsX, counts, offset_x, offset_y,
							width, height);
					pjAni.setCycleCount(0);
					pjAni.play();
					transicion = new TranslateTransition();
					transicion.setDelay(Duration.ZERO);
					transicion.setDuration(Duration.seconds(1));
					double nextPos = pjImage.getY() - movePX;
					transicion.setToY(-movePX);
					transicion.setNode(pjImage);
					transicion.setInterpolator(Interpolator.EASE_BOTH);
					transicion.setOnFinished(e -> {
						pjImage.setY(nextPos);
						pjImage.setTranslateY(0);
						inMove = false;
						pjImage.setViewport(new Rectangle2D(0, 0, 32, 39));
						myPosY--;
					});
					transicion.play();
				}
//			pjImage.setX(pjImage.getX()pjImage.getX());
				break;
			case D:
				if ((myPosX + 1) < map[0].length && map[myPosY][myPosX + 1] == true) {
					inMove = true;
					colsX = 3;
					counts = 3;
					offset_x = 0;
					offset_y = 36;
					width = 32;
					height = 39;
					pjAni = new SprinteAnimation(pjImage, Duration.millis(aniS), colsX, counts, offset_x, offset_y,
							width, height);
					pjAni.setCycleCount(0);
					pjAni.play();
					transicion = new TranslateTransition();
					transicion.setDelay(Duration.ZERO);
					transicion.setDuration(Duration.seconds(1));
					double nextPos2 = pjImage.getX() + movePX;
					transicion.setToX(movePX);
					transicion.setNode(pjImage);
					transicion.setInterpolator(Interpolator.EASE_BOTH);
					transicion.setOnFinished(e -> {
						pjImage.setX(nextPos2);
						pjImage.setTranslateX(0);
						myPosX++;
						inMove = false;
						pjImage.setViewport(new Rectangle2D(0, 36, 32, 39));
					});
					
					transicion.play();
					
				}
				break;
			case A:
				if ((myPosX - 1) >= 0 && map[myPosY][myPosX - 1] == true) {
					inMove = true;
					colsX = 3;
					counts = 3;
					offset_x = 0;
					offset_y = 108;
					width = 32;
					height =39;
					pjAni = new SprinteAnimation(pjImage, Duration.millis(aniS), colsX, counts, offset_x, offset_y,
							width, height);
					pjAni.setCycleCount(0);
					pjAni.play();
					transicion = new TranslateTransition();
					transicion.setDelay(Duration.ZERO);
					transicion.setDuration(Duration.seconds(1));
					double nextPos3 = pjImage.getX() - movePX;
					transicion.setToX(-movePX);
					transicion.setNode(pjImage);
					transicion.setInterpolator(Interpolator.EASE_BOTH);
					transicion.setOnFinished(e -> {
						pjImage.setX(nextPos3);
						pjImage.setTranslateX(0);
						myPosX--;
						inMove = false;
						pjImage.setViewport(new Rectangle2D(0, 108, 32,39 ));
					});
					transicion.play();
					
				}
				break;
			case S:
				if ((myPosY + 1) < map.length && map[myPosY + 1][myPosX] == true) {
					inMove = true;
					colsX = 3;
					counts = 3;
					offset_x = 0;
					offset_y = 72;
					width = 32;
					height = 39;
					pjAni = new SprinteAnimation(pjImage, Duration.millis(aniS), colsX, counts, offset_x, offset_y,
							width, height);
					pjAni.setCycleCount(0);
					pjAni.play();
					transicion = new TranslateTransition();
					transicion.setDelay(Duration.ZERO);
					transicion.setDuration(Duration.seconds(1));
					double nextPos4 = pjImage.getY() + movePX;
					transicion.setToY(+movePX);
					transicion.setNode(pjImage);
					transicion.setInterpolator(Interpolator.EASE_BOTH);
					transicion.setOnFinished(e -> {
						pjImage.setY(nextPos4);
						pjImage.setTranslateY(0);
						myPosY++;
						inMove = false;
						pjImage.setViewport(new Rectangle2D(0, 72, 32, 39));
					});
					transicion.play();
					
					break;
				}
			case E:
				System.out.println(event.getCode());

				// Cambio de escena
				SceneManager.changeScene(new App2());

				inMove = false;
			break;
			default:
				
				break;
			}
		}
		
	}

	public static ImageView getPjImage() {
		return pjImage;
	}
}
