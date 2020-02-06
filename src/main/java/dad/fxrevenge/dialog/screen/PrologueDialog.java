package dad.fxrevenge.dialog.screen;

import dad.fxrevenge.dialog.character.Character;
import dad.fxrevenge.dialog.character.CharacterList;
import dad.fxrevenge.dialog.DialogScreen;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class PrologueDialog extends DialogScreen {
	
	// Imagen de fondo
	private Image dialogBackground = new Image("/image/dialog/background/prologue.jpg");
	
	// Personajes
	private Character nullCharacter = CharacterList.getNullChar();
	
	private Character mainCharacter = CharacterList.getPlayer();
	private Character javaGoddess = CharacterList.getJavaGoddess();
	
	public PrologueDialog(Stage stage, Canvas canvas, GraphicsContext graphicContext) {
		super(stage, canvas, graphicContext);
	}

	@Override
	public void start() {
		setGraphics(dialogBackground, mainCharacter, javaGoddess);
		super.start();
	}
	
	@Override
	protected void tickAndRender() {
		super.tickAndRender();

		// Diálogos
		switch (dialogNumber) {

		case 0:
			CharacterTalking(mainCharacter, "<< ¿Dónde estoy? >>");
			break;

		case 1:
			CharacterTalking(mainCharacter, "<< ¿Estaré soñando? Nunca había estado en un lugar como este >>");
			break;
			
		case 2:
			CharacterTalking(javaGoddess, "Este mundo es una manifestación de tus preocupaciones y temores");
			break;
			
		case 3:
			CharacterTalking(javaGoddess, "Corres un grave peligro, uno del que no podrás escapar cuando sea demasiado tarde");
			break;

		case 4:
			CharacterTalking(javaGoddess, "Por eso estás aquí, para fortalecerte y ser capaz de cambiar tu destino");
			break;
			
		case 5:
			CharacterTalking(mainCharacter, "¿Qué? ¿Que clase de peligro?");
			break;
			
		case 6:
			CharacterTalking(javaGoddess, "La chancla de tu madre como no apruebes el curso");
			break;
			
		case 7:
			CharacterTalking(nullCharacter, "...");
			break;
			
		case 8:
			CharacterTalking(mainCharacter, "<< ¿Qué demonios fue eso? >>");
			break;
			
		default:
			CharacterTalking(nullCharacter, "FIN DEL DIÁLOGO");
			break;

		}

	}

}
