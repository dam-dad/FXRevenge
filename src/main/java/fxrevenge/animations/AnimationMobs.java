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

	public AnimationMobs(String urlImage) {
		imageMob = new ImageView(new Image(urlImage));
		imageMob.setViewport(new Rectangle2D(0, 0, 56, 84));
	}

	public void staticAni(int colsX, int counts, int offset_x, int offset_y, int width, int height) {
		animation = new SprinteAnimation(imageMob, Duration.millis(1000), colsX, counts, offset_x, offset_y, width,
				height);
		animation.setCycleCount(100);
		animation.setOnFinished(e-> finalizeAni());
		animation.play();
	}
	 private void finalizeAni() {
		 animation.play();
	}

	public ImageView getImageMob() {
		return imageMob;
	}
}
