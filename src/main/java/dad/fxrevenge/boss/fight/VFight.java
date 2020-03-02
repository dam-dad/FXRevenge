package dad.fxrevenge.boss.fight;

import java.io.IOException;

import dad.fxrevenge.boss.map.VMap;
import dad.fxrevenge.combat.CombatController;
import dad.fxrevenge.music.Musica;
import dad.fxrevenge.parameters.Backgrounds;
import dad.fxrevenge.parameters.Bosses;
import dad.fxrevenge.parameters.Player;
import dad.fxrevenge.scene.SceneManager;

public class VFight extends CombatController {
	// music
	private Musica musica = new Musica("/music/V.mp3");

	public VFight() throws IOException {
		super(Player.getPlayer(), Bosses.getV(), Backgrounds.getV());
		musica.playInfiniteSound().play();
	}

	@Override
	protected void victory() {
		musica.getMediaPlayer().stop();
		SceneManager.changeScene(new VMap());
	}

}
