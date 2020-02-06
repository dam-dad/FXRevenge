package dad.fxrevenge.screen.dialog;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class IntroDialogScreen extends DialogScreen {

	private Image dialogBackground = new Image("/image/dialog_screen/background.jpg");
	private Image leftCharacter = new Image("/image/dialog_screen/all_might.png");
	private Image rightCharacter = new Image("/image/dialog_screen/all_might.png");

	public IntroDialogScreen(Canvas canvas, GraphicsContext graphicContext) {
		super(canvas, graphicContext);
	}

	@Override
	public void start() {
		setGraphics(dialogBackground, leftCharacter, rightCharacter);
		super.start();
	}
	
	@Override
	protected void tickAndRender() {
		super.tickAndRender();

		// Diálogos
		switch (dialogNumber) {

		case 0:
			CharacterTalking(leftCharacter, "MVC", "Mi venganza será terrible", true);
			break;

		case 1:
			CharacterTalking(rightCharacter, "Mr. FX", "Y la mía también", false);
			break;

		default:
			CharacterTalking(null, "(...)", "(Nadie está hablando...)", false);

		}

	}

}
