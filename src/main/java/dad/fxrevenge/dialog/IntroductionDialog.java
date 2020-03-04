package dad.fxrevenge.dialog;

import dad.fxrevenge.boss.map.Overworld;
import dad.fxrevenge.music.Musica;
import dad.fxrevenge.parameters.Backgrounds;
import dad.fxrevenge.scene.DialogScene;
import dad.fxrevenge.scene.SceneManager;

public class IntroductionDialog extends DialogScene {

	// Personajes
	private Character nullCharacter = CharacterList.getNullChar();
	private Character mainCharacter = CharacterList.getPlayer();
	private Character javaGoddess = CharacterList.getJavaGoddess();

	@Override
	public void start() {
		setGraphics(mainCharacter, javaGoddess, Backgrounds.getIntro());
		super.start();
	}

	@Override
	public void update() {
		super.update();

		// Diálogos
		switch (dialogNumber) {

		case 0:
			CharacterTalking(mainCharacter, "<< ¿Dónde estoy? >>");
			break;

		case 1:
			CharacterTalking(mainCharacter, "<< ¿Estaré soñando? Nunca había estado en un lugar como éste >>");
			break;

		case 2:
			CharacterTalking(javaGoddess, "Este mundo es una manifestación de tus preocupaciones y temores.");
			break;

		case 3:
			CharacterTalking(javaGoddess,
					"Corres un grave peligro, uno del que no podrás escapar cuando sea demasiado tarde.");
			break;

		case 4:
			CharacterTalking(javaGoddess, "Por eso estás aquí, para fortalecerte y ser capaz de cambiar tu destino.");
			break;

		case 5:
			CharacterTalking(mainCharacter, "¿Qué? ¿Que clase de peligro?");
			break;

		case 6:
			CharacterTalking(javaGoddess, "La chancla de tu madre como no apruebes el curso.");
			break;

		case 7:
			CharacterTalking(nullCharacter, "(La diosa Java se ha esfumado...)");
			break;

		case 8:
			CharacterTalking(mainCharacter, "<< ¿Qué demonios fue eso? >>");
			break;

		default:
			Musica.getEnd().getMediaPlayer().stop();

			// Cambio de escena
			SceneManager.changeScene(new Overworld());
			break;
		}
	}
}
