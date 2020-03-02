package dad.fxrevenge.boss.fight;

import java.io.IOException;

import dad.fxrevenge.boss.map.MMap;
import dad.fxrevenge.combat.CombatController;
import dad.fxrevenge.music.Musica;
import dad.fxrevenge.parameters.Backgrounds;
import dad.fxrevenge.parameters.Bosses;
import dad.fxrevenge.parameters.Player;
import dad.fxrevenge.scene.SceneManager;

public class MFight extends CombatController {
	// music
	private Musica musica = new Musica("/music/M.mp3");

	public MFight() throws IOException {
		super(Player.getPlayer(), Bosses.getM(), Backgrounds.getM());
		musica.playInfiniteSound().play();
	}

	@Override
	protected void victory() {
		musica.getMediaPlayer().stop();
		SceneManager.changeScene(new MMap());
	}

}
