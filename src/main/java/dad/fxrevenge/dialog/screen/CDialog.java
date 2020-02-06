package dad.fxrevenge.dialog.screen;

import dad.fxrevenge.dialog.character.Character;
import dad.fxrevenge.dialog.character.CharacterList;
import dad.fxrevenge.dialog.DialogScreen;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class CDialog extends DialogScreen {
	
	// Imagen de fondo
	private Image dialogBackground = new Image("/image/dialog/background/c.jpg");
	
	// Personajes
	private Character nullChar = new Character(null, null, false);
	
	private Character player = CharacterList.getPlayer();
	private Character c = CharacterList.getC();
	
	public CDialog(Stage stage, Canvas canvas, GraphicsContext graphicContext) {
		super(stage, canvas, graphicContext);
	}

	@Override
	public void start() {
		setGraphics(dialogBackground, player, c);
		super.start();
	}
	
	@Override
	protected void tickAndRender() {
		super.tickAndRender();

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
			CharacterTalking(player, "Me quiero morir... en fin, manos a la obra.");
			break;
			
		default:
			CharacterTalking(nullChar, "FIN DEL DIÁLOGO");
			break;		
			
		}
	}
}
