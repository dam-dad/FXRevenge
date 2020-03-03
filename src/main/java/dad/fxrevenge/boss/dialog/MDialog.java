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
	private Musica musica = Musica.m;

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
					"Hoy voy a explicar los hechizos sincronizados, son increíblemente prácticos.");
			break;

		case 2:
			CharacterTalking(player, "(Observas con cara de no entender qué está pasando)");
			break;

		case 3:
			CharacterTalking(m, "Veamos un ejemplo.");
			break;

		default:
			try {
				SceneManager.changeScene(new MFight());
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;

		}

	}

}
