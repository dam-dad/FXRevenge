package dad.fxrevenge.boss.dialog;

import java.io.IOException;

import dad.fxrevenge.boss.fight.CFight;
import dad.fxrevenge.boss.map.CMap;
import dad.fxrevenge.dialog.Character;
import dad.fxrevenge.dialog.CharacterList;
import dad.fxrevenge.music.Musica;
import dad.fxrevenge.parameters.Backgrounds;
import dad.fxrevenge.scene.DialogScene;
import dad.fxrevenge.scene.SceneManager;

public class CDialog extends DialogScene {

	// Personajes
	private Character player = CharacterList.getPlayer();
	private Character c = CharacterList.getC();

	// music
	private Musica musica = Musica.c;

	@Override
	public void start() {
		setGraphics(player, c, Backgrounds.getC());
		musica.playInfiniteSound().play();
		super.start();
	}

	@Override
	public void update() {
		super.update();

		if (!CFight.isDefeated()) {

			// Diálogos
			switch (dialogNumber) {

			case 0:
				CharacterTalking(player,
						"(Estás pensado qué vas a almorzar cuando llegues a casa cuando de repente...)");
				break;

			case 1:
				CharacterTalking(c, "¡Buenos días chicos! Tienen 10 minutos para aprender a usar pyspell.");
				break;

			case 2:
				CharacterTalking(c, "Pasado ese tiempo tendrán que hacerme una demostración de lo que han conseguido.");
				break;

			case 3:
				CharacterTalking(player,
						"(Le rezas a la diosa Java que te dé su bendición para poder lograrlo a tiempo)");
				break;

			case 4:
				CharacterTalking(c,
						"El objetivo es que seáis capaces de aprender nuevos hechizos rápidamente. ¡Suerte!");
				break;

			case 5:
				CharacterTalking(player, "En fin, manos a la obra.");
				break;

			default:
				try {
					SceneManager.changeScene(new CFight());
				} catch (IOException e) {
					e.printStackTrace();
				}
				dialogNumber = 0;
				break;
			}

		} else {
			switch (dialogNumber) {

			case 0:
				CharacterTalking(c, "Has logrado superar esta prueba. ¡Enhorabuena!");
				break;

			default:
				SceneManager.changeScene(new CMap());
				dialogNumber = 0;
				break;
			}
		}
	}
}
