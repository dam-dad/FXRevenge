package dad.fxrevenge.screen;

import dad.fxrevenge.music.Musica;
import dad.fxrevenge.parameters.Backgrounds;
import dad.fxrevenge.scene.DialogScene;
import javafx.application.Platform;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

public class GameOverScreen extends DialogScene {

	// Función que se ejecuta dentro del bucle principal
	@Override
	public void update() {
		Musica.getEnd().playSound().play();

		// Redimensionar canvas
		canvas.setWidth(scene.getWidth());
		canvas.setHeight(scene.getHeight());

		// Limpiar canvas
		graphicsContext.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

		// Dibujar fondo
		graphicsContext.drawImage(Backgrounds.getGameover(), 0, 0, canvas.getWidth(), canvas.getHeight());

		// Fuente del texto
		Font titleFont = Font.font("Arial", FontWeight.BOLD, 100);
		Font pressKeyFont = Font.font("Arial", FontWeight.BOLD, 25);

		// Dibujar texto
		drawText(titleFont, "GAME OVER", true);
		drawText(pressKeyFont, "Pulsa ENTER para salir", false);

		// Si se presiona la tecla ENTER carga el diálogo de introducción
		if (currentlyActiveKeys.contains("ENTER")) {
			currentlyActiveKeys.clear();
			Platform.exit();
		}

	}

	// Función que dibuja el texto aplicándole estilos
	private void drawText(Font font, String text, Boolean isTitle) {

		Double x = canvas.getWidth() / 2;
		Double y = canvas.getHeight();
		Double offset = (double) 3;

		graphicsContext.setTextAlign(TextAlignment.CENTER);
		graphicsContext.setFont(font);
		graphicsContext.setStroke(Color.BLACK);
		graphicsContext.setFill(Color.BLACK);
		graphicsContext.setLineWidth(1);

		if (isTitle) {
			y = y / 3;
		} else {
			y = y / 1.75;
		}

		graphicsContext.strokeText(text, x, y);
		graphicsContext.fillText(text, x + offset, y + offset);

		graphicsContext.setFill(Color.WHITE);
		graphicsContext.fillText(text, x, y);

	}
}
