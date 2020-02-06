package dad.fxrevenge.dialog.screen;

import dad.fxrevenge.dialog.character.Character;
import dad.fxrevenge.dialog.character.CharacterList;
import dad.fxrevenge.dialog.DialogScreen;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class FXDialog extends DialogScreen {
	
	// Imagen de fondo
	private Image dialogBackground = new Image("/image/dialog/background/fx.jpg");
	
	// Personajes
	private Character nullChar = new Character(null, null, false);
	
	private Character player = CharacterList.getPlayer();
	private Character fx = CharacterList.getFX();
	
	public FXDialog(Stage stage, Canvas canvas, GraphicsContext graphicContext) {
		super(stage, canvas, graphicContext);
	}

	@Override
	public void start() {
		setGraphics(dialogBackground, player, fx);
		super.start();
	}
	
	@Override
	protected void tickAndRender() {
		super.tickAndRender();

		// Diálogos
		switch (dialogNumber) {

		case 0:
			CharacterTalking(fx, "Separen las mesas, vamos a hacer un examen.");
			break;

		case 1:
			CharacterTalking(player, "(Aterrorizado) ¿Cómo? Vamos a morir.");
			break;
			
		case 2:
			CharacterTalking(fx, "¡Es broma! Hoy les voy a explicar la técnica secreta de Chuck Norris para derrotar a sus enemigos.");
			break;
			
		case 3:
			CharacterTalking(fx, "¡Bindeos! Gracias a ellos es capaz de predecir los movimientos de sus atacantes y responder eficazmente.");
			break;
			
		case 4:
			CharacterTalking(player, "(Te asustas aún más)");
			break;
			
		case 5:
			CharacterTalking(fx, "¿Algún voluntario para hacer una demostración?");
			break;
			
		case 6:
			CharacterTalking(player, "(Sientes tanto miedo que agachas la cabeza suplicando clemencia)");
			break;
			
		default:
			CharacterTalking(nullChar, "FIN DEL DIÁLOGO");
			break;

		}
	}
}
