package fxrevenge.animations;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class AnimationMobs {
	private Animation animation;
	private ImageView imageMob;
	private boolean loop =true;
	private int colsX, counts, offset_x, offset_y,  width, height;
	public AnimationMobs(String urlImage,int colsX, int counts, int offset_x, int offset_y, int width, int height) {
		imageMob = new ImageView(new Image(urlImage));
		imageMob.setViewport(new Rectangle2D(0, 0, 56, 84));
		this.colsX=colsX;
		this.counts=counts;
		this.offset_x=offset_x;
		this.offset_y=offset_y;
		this.width=width;
		this.height=height;
	}
	
	public void StartAni() {
		System.out.println("S");
		animation = new SprinteAnimation(imageMob, Duration.millis(1000), colsX, counts, offset_x, offset_y, width,
				height);
		animation.setCycleCount(animation.INDEFINITE);
		animation.play();
	}
	public ImageView getImageMob() {
		return imageMob;
	}

	
}
