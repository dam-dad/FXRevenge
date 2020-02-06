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
			CharacterTalking(player, "...");
			break;

		case 1:
			CharacterTalking(m, "...");
			break;
			
		default:
			CharacterTalking(nullChar, "FIN DEL DIÁLOGO");
			break;

		}

	}

}
