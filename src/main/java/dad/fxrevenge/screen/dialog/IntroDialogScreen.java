package dad.fxrevenge.screen.dialog;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class IntroDialogScreen extends DialogScreen {
	
	// Imagen de fondo
	private Image dialogBackground = new Image("/image/dialog_screen/intro/background.jpg");
	
	// Personaje vacío para pruebas
	private Character nullCharacter = new Character(null, null, false);
	
	// Personajes
	private Character unknownCharacter = new Character("???", null, false);
	
	private Character mainCharacter = new Character("Protagonista genérico (tú)", new Image("/image/dialog_screen/intro/main_character.png"), true);
	private Character javaGoddess = new Character("Diosa Java", new Image("/image/dialog_screen/intro/java_goddess.png"), false);
	
	public IntroDialogScreen(Stage stage, Canvas canvas, GraphicsContext graphicContext) {
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
			CharacterTalking(unknownCharacter, "Este mundo es una manifestación de tus preocupaciones, sentimientos y deseos");
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
