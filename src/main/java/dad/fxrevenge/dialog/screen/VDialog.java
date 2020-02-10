package dad.fxrevenge.dialog.screen;

import dad.fxrevenge.dialog.character.Character;
import dad.fxrevenge.dialog.character.CharacterList;
import dad.fxrevenge.dialog.DialogScreen;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class VDialog extends DialogScreen {
	
	// Imagen de fondo
	private Image dialogBackground = new Image("/image/dialog/background/v.png");
	
	// Personajes
	private Character nullChar = new Character(null, null, false);
	
	private Character player = CharacterList.getPlayer();
	private Character v = CharacterList.getV();
	
	public VDialog(Stage stage, Canvas canvas, GraphicsContext graphicContext) {
		super(stage, canvas, graphicContext);
	}

	@Override
	public void start() {
		setGraphics(dialogBackground, player, v);
		super.start();
	}
	
	@Override
	protected void tickAndRender() {
		super.tickAndRender();

		// Diálogos
		switch (dialogNumber) {

		case 0:
			CharacterTalking(v, "¡Hola querido alumno! He preparado 9.999.999 ejercicios para que practique.");
			break;

		case 1:
			CharacterTalking(player, "(Sonríes escondiendo tu dolor)");
			break;
			
		case 2:
			CharacterTalking(v, "Venga, no ponga esa cara que son sencillitos.");
			break;
			
		case 3:
			CharacterTalking(player, "(Vuelves a sonrerir escondiendo aún más tu dolor)");
			break;
			
		case 4:
			CharacterTalking(v, "¡A trabajar!");
			break;
			
		default:
			CharacterTalking(nullChar, "FIN DEL DIÁLOGO");
			break;

		}
	}
}
