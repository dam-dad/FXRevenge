package dad.fxrevenge.titlescreen;

import java.io.IOException;

import dad.fxrevenge.boss.map.CMap;
import dad.fxrevenge.boss.map.FXMap;
import dad.fxrevenge.boss.map.MMap;
import dad.fxrevenge.boss.map.Overworld;
import dad.fxrevenge.boss.map.VMap;
import dad.fxrevenge.charselect.CharSelectController;
import dad.fxrevenge.models.ClassType;
import dad.fxrevenge.parameters.Backgrounds;
import dad.fxrevenge.parameters.Player;
import dad.fxrevenge.scene.DialogScene;
import dad.fxrevenge.scene.SceneManager;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

public class TitleScreen extends DialogScene {

	// Función que se ejecuta dentro del bucle principal
	@Override
	public void update() {
		// Redimensionar canvas
		canvas.setWidth(scene.getWidth());
		canvas.setHeight(scene.getHeight());

		// Limpiar canvas
		graphicsContext.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

		// Dibujar fondo
		graphicsContext.drawImage(Backgrounds.getTitleScreen(), 0, 0, canvas.getWidth(), canvas.getHeight());

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

			try {
				SceneManager.changeScene(new CharSelectController());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		// DEBUG
		
		if (currentlyActiveKeys.contains("O")) {
			currentlyActiveKeys.clear();
			
			testPlayer();
			
			SceneManager.changeScene(new Overworld());
		}
		
		if (currentlyActiveKeys.contains("M")) {
			currentlyActiveKeys.clear();

			testPlayer();
			
			SceneManager.changeScene(new MMap());
		}
		
		if (currentlyActiveKeys.contains("V")) {
			currentlyActiveKeys.clear();

			testPlayer();
			
			SceneManager.changeScene(new VMap());
		}
			
		if (currentlyActiveKeys.contains("C")) {
			currentlyActiveKeys.clear();

			testPlayer();
			
			SceneManager.changeScene(new CMap());
		}
		
		if (currentlyActiveKeys.contains("FX")) {
			currentlyActiveKeys.clear();
			
			testPlayer();

			SceneManager.changeScene(new FXMap());
		}
		
		
		
		
		// DEBUG
		
	}
	
	private void testPlayer() {
		Player.setName("Player");
		Player.setPortrait(new Image("/image/dialog/character/player.png"));
		Player.setRole(ClassType.Warlord);
		
		new Player();

		Player.getPlayer().setWorldSprite(new Image("/image/characters/select/m/warriorW.png"));
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
