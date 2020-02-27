package dad.fxrevenge.boss.dialog;

import java.io.IOException;

import dad.fxrevenge.boss.fight.MFight;
import dad.fxrevenge.dialog.Character;
import dad.fxrevenge.dialog.CharacterList;
import dad.fxrevenge.models.Avatar;
import dad.fxrevenge.scene.DialogScene;
import dad.fxrevenge.scene.Parameters;
import dad.fxrevenge.scene.SceneManager;

public class MDialog extends DialogScene implements Parameters {

	// Personajes
	private Character player = CharacterList.getPlayer();
	private Character m = CharacterList.getM();

	public MDialog(Avatar avatar) {
		this.avatar=avatar;
	}

	@Override
	public void start() {
		setGraphics(player, m, BACKGROUND_M);
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
			CharacterTalking(m, "Aunque eso no significa que no haya que prestarles atención. Veamos un ejemplo.");
			break;

		case 3:
			CharacterTalking(player, "(Observas con cara de no entender qué está pasando)");
			break;

		case 4:
			CharacterTalking(player, "No termino de pillarlo, ¿puedes repetir eso último?");
			break;

		case 5:
			CharacterTalking(m, "Hagamos una prueba, ya verás que lo entiendes enseguida.");
			break;

		default:
			try {
				SceneManager.changeScene(new MFight(avatar));
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;

		}

	}

}
