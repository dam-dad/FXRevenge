package dad.fxrevenge.screen.dialog;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class IntroDialogScreen extends DialogScreen {
	
	// Imagen de fondo
	private Image dialogBackground = new Image("/image/dialog_screen/intro/background.jpg");
	
	// Personaje vacío para pruebas
	private Character nullCharacter = new Character("???", null);
	
	// Personajes
	private Character mainCharacter = new Character("Alumno asustado (tú)", new Image("/image/dialog_screen/intro/main_character.png"));
	private Character javaGoddess = new Character("Diosa de la programación Java", new Image("/image/dialog_screen/intro/java_goddess.png"));
	
	public IntroDialogScreen(Canvas canvas, GraphicsContext graphicContext) {
		super(canvas, graphicContext);
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
			CharacterTalking(mainCharacter, "(¿Qué lugar es este?)", true);
			break;

		case 1:
			CharacterTalking(nullCharacter, "Tus preocupaciones te han traído aquí, no podrás salir hasta que no derrotes a la alianza MVC", false);
			break;
			
		case 2:
			CharacterTalking(javaGoddess, "¡Holiwis! :3", false);
			break;
			
		case 3:
			CharacterTalking(mainCharacter, "¿Una diosa saludando de esa manera? Cuanto daño han hecho las redes sociales... \n"
					+ " pero ya que estamos agregame al Messenger lol", true);
			break;

		default:
			CharacterTalking(nullCharacter, "(La diosa Java no quiere ser tu amiga... niiiinoooniiiiiii)", false);

		}

	}

}
