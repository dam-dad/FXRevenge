package dad.fxrevenge.animations;

import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.util.Duration;


/**
 * Clase <code>SprinteAnimation</code>.
 * 
 * @implNote Es una clase de tipo transition,
 *  la cual empleamos para poder 
 *  animar imagenes recoriendo recuadros de pixeles
 */
public class SprinteAnimation extends Transition {

	private final ImageView imageView;
	private final int count;
	private final int columns;
	private final int offsetX;
	private final int offsetY;
	private final int width;
	private final int height;

	private int lastIndex;

	
	/**
	 * Clase <code>SprinteAnimation</code>.
	 * @param imageView  contiene el objeto Imagen de fx;
	 * @param duration duración de las tranciciones;
	 * @param counts  Número de filas o contador
	 * @param columns Número de columnas del personaje en el sprite.
	 * @param offsetX desplasamiento en columnas,
	 * @param offsetY desplasamiento por fila.
	 * @param width   ancho del fragmento de imagen a dibujar
	 * @param height  alto del fragmento de imagen a dibujar
	 */
	public SprinteAnimation(ImageView imageView, Duration duration, int count, int columns, int offsetX, int offsetY,
			int width, int height) {
		this.imageView = imageView;
		this.count = count;
		this.columns = columns;
		this.offsetX = offsetX;
		this.offsetY = offsetY;
		this.width = width;
		this.height = height;
		setCycleDuration(duration);
		setInterpolator(Interpolator.LINEAR);
	}

	protected void interpolate(double k) {
		final int index = Math.min((int) Math.floor(k * count), count - 1);
		if (index != lastIndex) {
			final int x = (index % columns) * width + offsetX;
			final int y = (index / columns) * height + offsetY;
			imageView.setViewport(new Rectangle2D(x, y, width, height));
			lastIndex = index;
		}
	}
}