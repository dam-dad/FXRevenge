package dad.fxrevenge.screen;

import dad.fxrevenge.scene.DialogScene;
import dad.fxrevenge.scene.SceneManager;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

public class TitleScreen extends DialogScene {
	
	// Imagen de fondo de la escena
	private Image background = new Image("/image/background/titlescreen.jpg");

	// Función que se ejecuta dentro del bucle principal
	@Override
	protected void update() {
		// Redimensionar canvas
		canvas.setWidth(scene.getWidth());
		canvas.setHeight(scene.getHeight());

		// Limpiar canvas
		graphicsContext.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

		// Dibujar fondo
		graphicsContext.drawImage(background, 0, 0, canvas.getWidth(), canvas.getHeight());

		// Fuente del texto
		Font titleFont = Font.font("Arial", FontWeight.BOLD, 100);
		Font pressKeyFont = Font.font("Arial", FontWeight.BOLD, 25);
		Font creditsFont = Font.font("Arial", FontWeight.NORMAL, 15);

		// Dibujar texto
		drawText(titleFont, "FX Revenge", true);
		drawText(pressKeyFont, "Pulsa ENTER para comenzar", false);

		graphicsContext.setFont(creditsFont);

		// Diálogo con el nombre de los creadores
		dialog.showDialog("Realizado por:", "Adán Jiménez Sacramento" + "\n" + "Andrés Galván García" + "\n"
				+ "Luis Adán Pérez Nazco" + "\n" + "Roberto González Linares");

		// Si se presiona la tecla ENTER carga el diálogo de introducción
		if (currentlyActiveKeys.contains("ENTER")) {
			currentlyActiveKeys.clear();
			SceneManager.changeScene(new IntroductionDialog());
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
