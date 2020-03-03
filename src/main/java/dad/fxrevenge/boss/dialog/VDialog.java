package dad.fxrevenge.boss.dialog;

import java.io.IOException;

import dad.fxrevenge.boss.fight.VFight;
import dad.fxrevenge.boss.map.VMap;
import dad.fxrevenge.dialog.Character;
import dad.fxrevenge.dialog.CharacterList;
import dad.fxrevenge.music.Musica;
import dad.fxrevenge.parameters.Backgrounds;
import dad.fxrevenge.scene.DialogScene;
import dad.fxrevenge.scene.SceneManager;

public class VDialog extends DialogScene {

	// Personajes
	private Character player = CharacterList.getPlayer();
	private Character v = CharacterList.getV();

	// music
	private Musica musica = Musica.v;

	@Override
	public void start() {
		setGraphics(player, v, Backgrounds.getV());
		musica.playInfiniteSound().play();
		super.start();
	}

	@Override
	public void update() {
		super.update();

		if (!VFight.isDefeated()) {

			// Diálogos
			switch (dialogNumber) {

			case 0:
				CharacterTalking(v, "¡Hola! Para hoy he preparado 9.999.999 ejercicios para que practiquen.");
				break;

			case 1:
				CharacterTalking(player, "(Sonríes escondiendo tu dolor)");
				break;

			case 2:
				CharacterTalking(v, "Venga, no pongan esa cara que son sencillitos.");
				break;

			case 3:
				CharacterTalking(player, "(Vuelves a sonrerir escondiendo aún más tu dolor)");
				break;

			case 4:
				CharacterTalking(v, "¡A trabajar!");
				break;

			default:
				try {
					SceneManager.changeScene(new VFight());
				} catch (IOException e) {
					e.printStackTrace();
				}
				dialogNumber = 0;
				break;

			}
		} else {
			switch (dialogNumber) {

			case 0:
				CharacterTalking(v, "Has logrado superar esta prueba. ¡Enhorabuena!");
				break;

			default:
				SceneManager.changeScene(new VMap());
				dialogNumber = 0;
				break;
			}
		}
	}
}
