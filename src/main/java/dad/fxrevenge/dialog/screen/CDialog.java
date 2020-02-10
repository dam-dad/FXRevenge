package dad.fxrevenge.dialog.screen;

import dad.fxrevenge.dialog.character.Character;
import dad.fxrevenge.dialog.character.CharacterList;
import dad.fxrevenge.scene.DialogScene;
import javafx.scene.image.Image;

public class CDialog extends DialogScene {
	
	// Imagen de fondo
	private Image dialogBackground = new Image("/image/dialog/background/c.png");
	
	// Personajes
	private Character nullChar = new Character(null, null, false);
	
	private Character player = CharacterList.getPlayer();
	private Character c = CharacterList.getC();

	@Override
	public void load() {
		setGraphics(dialogBackground, player, c);
		super.load();
	}
	
	@Override
	protected void update() {
		super.update();

		// Diálogos
		switch (dialogNumber) {

		case 0:
			CharacterTalking(player, "(Estás pensado qué vas a almorzar cuando llegues a casa cuando de repente...)");
			break;

		case 1:
			CharacterTalking(c, "¡Buenos días chicos! Tienen 10 minutos para aprender a usar pyspell.");
			break;
			
		case 2:
			CharacterTalking(c, "Pasado ese tiempo tendrán que hacerme una demostración de lo que han conseguido hacer con él.");
			break;
			
		case 3:
			CharacterTalking(player, "(Le rezas a la diosa Java que te dé su bendición para poder lograrlo a tiempo)");
			break;
			
		case 4:
			CharacterTalking(c, "El objetivo es que seáis capaces de aprender nuevos hechizos rápidamente. ¡Suerte!");
			break;
			
		case 5:
			CharacterTalking(player, "En fin, manos a la obra.");
			break;
			
		default:
			CharacterTalking(nullChar, "FIN DEL DIÁLOGO");
			break;		
			
		}
	}
}
