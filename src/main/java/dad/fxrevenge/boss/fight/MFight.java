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
	private Musica musica = Musica.m;

	public MFight() throws IOException {
		super(Player.getPlayer(), Bosses.getM(), Backgrounds.getM());
	}

	@Override
	protected void victory() {
		musica.getMediaPlayer().stop();
		SceneManager.changeScene(new MMap());
	}

}
