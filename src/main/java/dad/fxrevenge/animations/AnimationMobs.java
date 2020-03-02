package dad.fxrevenge.animations;

import javafx.animation.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 * Clase <code>AnimationMobs</code>.
  * Esta clase simple para mostrar mobs en el mapa 
  * (No permitirá movimiento ni animación ,para está 
  * versión devido a errores con el mapeado)
 */
public class AnimationMobs {
	private ImageView imageMob;

	/**
	 * Constructs an <code>TestMove</code> with the specified detail message.
	 *@param urlImage la imagen sprite que tendrán los objetos interacutables.
	 * @param width    ancho del fragmento de imagen a dibujar
	 * @param heigth   alto del fragmento de imagen a dibujar
	 * @param offsetX desplasamiento en columnas,
	 * @param offsetY desplasamiento por fila.
	 */
	public AnimationMobs(String urlImage, int offsetX, int offsetY, int width, int heigth) {
		imageMob = new ImageView(new Image(urlImage));
		imageMob.setViewport(new Rectangle2D(offsetX, offsetY, width, heigth));
	}

	public ImageView getImageMob() {
		return imageMob;
	}
}
