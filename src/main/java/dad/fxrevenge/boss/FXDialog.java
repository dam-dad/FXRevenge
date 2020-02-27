package dad.fxrevenge.boss;

import java.io.IOException;

import dad.fxrevenge.dialog.Character;
import dad.fxrevenge.dialog.CharacterList;
import dad.fxrevenge.scene.DialogScene;
import dad.fxrevenge.scene.SceneManager;
import javafx.scene.image.Image;

public class FXDialog extends DialogScene {
	
	// Imagen de fondo
	private Image dialogBackground = new Image("/image/background/fx.png");
	
	// Personajes
	private Character player = CharacterList.getPlayer();
	private Character fx = CharacterList.getFX();

	@Override
	public void start() {
		setGraphics(dialogBackground, player, fx);
		super.start();
	}
	
	@Override
	public void update() {
		super.update();

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
			try {
				SceneManager.changeScene(new FXFight());
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;

		}
	}
}
