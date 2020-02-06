package dad.fxrevenge.dialog.screen;

import dad.fxrevenge.dialog.character.Character;
import dad.fxrevenge.dialog.character.CharacterList;
import dad.fxrevenge.dialog.DialogScreen;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MDialog extends DialogScreen {
	
	// Imagen de fondo
	private Image dialogBackground = new Image("/image/dialog/background/m.jpg");
	
	// Personajes
	private Character nullChar = new Character(null, null, false);
	
	private Character player = CharacterList.getPlayer();
	private Character m = CharacterList.getM();
	
	public MDialog(Stage stage, Canvas canvas, GraphicsContext graphicContext) {
		super(stage, canvas, graphicContext);
	}

	@Override
	public void start() {
		setGraphics(dialogBackground, player, m);
		super.start();
	}
	
	@Override
	protected void tickAndRender() {
		super.tickAndRender();

		// Diálogos
		switch (dialogNumber) {

		case 0:
			CharacterTalking(player, "(Bostezas mientras maldices haber tenido que madrugar)");
			break;

		case 1:
			CharacterTalking(m, "Hoy voy a explicar los hechizos sincronizados, son muy prácticos pero no los más poderosos.");
			break;
			
		case 2:
			CharacterTalking(m, "Aunque eso no significa que no haya que prestarles atención. Veamos un ejemplo.");
			break;
			
		case 3:
			CharacterTalking(player, "(Observas con cara de no entender qué está pasando)");
			break;
			
		case 4:
			CharacterTalking(player, "¡Profe! No termino de pillarlo, ¿puedes repetir eso último?");
			break;
			
		case 5:
			CharacterTalking(m, "Hagamos una prueba, ya verás que lo entiendes enseguida.");
			break;
			
		default:
			CharacterTalking(nullChar, "FIN DEL DIÁLOGO");
			break;	

		}

	}

}
