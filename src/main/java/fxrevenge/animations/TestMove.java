package fxrevenge.animations;

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

	public TestMove(boolean[][] habitability, int colX, int rowY) {
		pjImage = new ImageView(new Image("anfibio.png"));
		pjImage.setViewport(new Rectangle2D(0, 300, 100, 100));
		map = habitability;
		myPosX = colX;
		myPosY = rowY;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.println(map[i][j]);
			}
		}

	}

	public void move(KeyEvent event) {
		if (inMove == false & (event.getText().equals("w") | event.getText().equals("s") | event.getText().equals("a")
				| event.getText().equals("d"))) {
			TranslateTransition transicion = new TranslateTransition();
			int cols, counts, offset_x, offset_y, width, height;
			if (pjAni != null && pjAni.getStatus() == Status.RUNNING)
				pjAni.stop();
			switch (event.getCode()) {

			case W:
				System.out.println(myPosY);
				if ((myPosY-1) >= 0 && map[myPosY - 1][myPosX] == true) {
					System.out.println(myPosY+"_");
					inMove = true;
					cols = 4;
					counts = 4;
					offset_x = 0;
					offset_y = 300;
					width = 100;
					height = 100;
					pjAni = new SprinteAnimation(pjImage, Duration.millis(1000), cols, counts, offset_x, offset_y,
							width, height);
					pjAni.setCycleCount(2);
					pjAni.play();
					pjImage.setViewport(new Rectangle2D(0, 300, 100, 100));
					transicion = new TranslateTransition();
					transicion.setDelay(Duration.ZERO);
					transicion.setDuration(Duration.seconds(1));
					double nextPos = pjImage.getY() - 100;
					transicion.setToY(-100);
					transicion.setNode(pjImage);
					transicion.setInterpolator(Interpolator.EASE_BOTH);
					transicion.setOnFinished(e -> {
						pjImage.setY(nextPos);
						pjImage.setTranslateY(0);
						inMove = false;
						myPosY--;
					});
					transicion.play();
				}
//			pjImage.setX(pjImage.getX()pjImage.getX());
				break;
			case D:
				if ((myPosX + 1) < map[0].length && map[myPosY][myPosX + 1] == true) {
					inMove = true;
					cols = 4;
					counts = 4;
					offset_x = 0;
					offset_y = 200;
					width = 100;
					height = 100;
					pjAni = new SprinteAnimation(pjImage, Duration.millis(1000), cols, counts, offset_x, offset_y,
							width, height);
					pjAni.setCycleCount(2);
					pjAni.play();
					transicion = new TranslateTransition();
					transicion.setDelay(Duration.ZERO);
					transicion.setDuration(Duration.seconds(1));
					double nextPos2 = pjImage.getX() + 100;
					transicion.setToX(100);
					transicion.setNode(pjImage);
					transicion.setInterpolator(Interpolator.EASE_BOTH);
					transicion.setOnFinished(e -> {
						pjImage.setX(nextPos2);
						pjImage.setTranslateX(0);
						myPosX++;
						inMove = false;
						
					});
					transicion.play();
					pjImage.setViewport(new Rectangle2D(0, 200, 100, 100));
				}
				break;
			case A:
				if ((myPosX - 1) >= 0 && map[myPosY][myPosX - 1] == true) {
					inMove = true;
					cols = 4;
					counts = 4;
					offset_x = 0;
					offset_y = 100;
					width = 100;
					height = 100;
					pjAni = new SprinteAnimation(pjImage, Duration.millis(1000), cols, counts, offset_x, offset_y,
							width, height);
					pjAni.setCycleCount(2);
					pjAni.play();
					transicion = new TranslateTransition();
					transicion.setDelay(Duration.ZERO);
					transicion.setDuration(Duration.seconds(1));
					double nextPos3 = pjImage.getX() - 100;
					transicion.setToX(-100);
					transicion.setNode(pjImage);
					transicion.setInterpolator(Interpolator.EASE_BOTH);
					transicion.setOnFinished(e -> {
						pjImage.setX(nextPos3);
						pjImage.setTranslateX(0);
						myPosX--;
						inMove = false;
					});
					transicion.play();
					pjImage.setViewport(new Rectangle2D(0, 100, 100, 100));
				}
				break;
			case S:
				if ((myPosY + 1) < map.length && map[myPosY + 1][myPosX] == true) {
					inMove = true;
					cols = 4;
					counts = 4;
					offset_x = 0;
					offset_y = 0;
					width = 100;
					height = 100;
					pjAni = new SprinteAnimation(pjImage, Duration.millis(1000), cols, counts, offset_x, offset_y,
							width, height);
					pjAni.setCycleCount(2);
					pjAni.play();
					transicion = new TranslateTransition();
					transicion.setDelay(Duration.ZERO);
					transicion.setDuration(Duration.seconds(1));
					double nextPos4 = pjImage.getY() + 100;
					transicion.setToY(+100);
					transicion.setNode(pjImage);
					transicion.setInterpolator(Interpolator.EASE_BOTH);
					transicion.setOnFinished(e -> {
						pjImage.setY(nextPos4);
						pjImage.setTranslateY(0);
						myPosY++;
						inMove = false;
					});
					transicion.play();
					pjImage.setViewport(new Rectangle2D(0, 0, 100, 100));
					break;
				}
			case E:
				System.out.println(event.getCode());
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
