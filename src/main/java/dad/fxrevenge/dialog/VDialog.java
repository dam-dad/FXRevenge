package dad.fxrevenge.dialog;

import dad.fxrevenge.scene.DialogScene;
import javafx.scene.image.Image;

public class VDialog extends DialogScene {
	
	// Imagen de fondo
	private Image dialogBackground = new Image("/image/background/v.png");
	
	// Personajes
	private Character nullChar = new Character(null, null, false);
	
	private Character player = CharacterList.getPlayer();
	private Character v = CharacterList.getV();

	@Override
	public void start() {
		setGraphics(dialogBackground, player, v);
		super.start();
	}
	
	@Override
	public void update() {
		super.update();

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