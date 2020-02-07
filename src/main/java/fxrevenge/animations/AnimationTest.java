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

public class AnimationTest {

	private static ImageView pjImage;
	private Animation pjAni = null;
	private boolean inMove = false;
	private int [][] map;
	private int myPosX;
	private int myPosY;
	private int movePX=50;
	private int aniS=900;
	private int colsX = 3;
	private int counts = 3;
	private int offset_x = 0;
	private int offset_y = 36;
	private int width = 32;
	private int height = 39;
	
	public AnimationTest(int[][] habitability,String urlImage, int colX, int rowY,int colsX, int counts, int offset_x, int offset_y, int width, int height) {
		pjImage = new ImageView(new Image(urlImage));
		pjImage.setViewport(new Rectangle2D(0, 0, width, height));
		map = habitability;
		myPosX = colX;
		myPosY = rowY;
		this.colsX=colsX;
		this.counts=counts;
		this.offset_x=offset_x;
		this.offset_y=offset_y;
		this.width=width;
		this.height=height;

	}

	public void Ani() {
			
					pjAni = new SprinteAnimation(pjImage, Duration.millis(aniS), colsX, counts, offset_x, offset_y,
							width, height);
					pjAni.setCycleCount(Animation.INDEFINITE);
					pjAni.play();
	
	}

	public static ImageView getPjImage() {
		return pjImage;
	}
}
