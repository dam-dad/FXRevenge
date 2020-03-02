package dad.fxrevenge.boss.dialog;

import java.io.IOException;

import dad.fxrevenge.boss.fight.MFight;
import dad.fxrevenge.dialog.Character;
import dad.fxrevenge.dialog.CharacterList;
import dad.fxrevenge.music.Musica;
import dad.fxrevenge.parameters.Backgrounds;
import dad.fxrevenge.scene.DialogScene;
import dad.fxrevenge.scene.SceneManager;

public class MDialog extends DialogScene {

	// Personajes
	private Character player = CharacterList.getPlayer();
	private Character m = CharacterList.getM();

	// music
	private Musica musica = new Musica("/music/M.mp3");

	@Override
	public void start() {
		setGraphics(player, m, Backgrounds.getM());
		musica.playInfiniteSound().play();
		super.start();
	}

	@Override
	public void update() {
		super.update();

		// Diálogos
		switch (dialogNumber) {

		case 0:
			CharacterTalking(player, "(Bostezas mientras maldices haber tenido que madrugar)");
			break;

		case 1:
			CharacterTalking(m,
					"Hoy voy a explicar los hechizos sincronizados, son muy prácticos pero no los más poderosos.");
			break;

		case 2:
			CharacterTalking(m, "Aunque eso no significa que no haya que prestarles atención.");
			break;

		case 3:
			CharacterTalking(player, "(Observas con cara de no entender qué está pasando)");
			break;

		case 4:
			CharacterTalking(m, "Veamos un ejemplo.");
			break;

		default:
			musica.getMediaPlayer().stop();
			try {
				SceneManager.changeScene(new MFight());
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;

		}

	}

}
