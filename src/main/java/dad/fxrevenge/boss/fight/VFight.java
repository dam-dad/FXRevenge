package dad.fxrevenge.boss.fight;

import java.io.IOException;

import dad.fxrevenge.boss.dialog.VDialog;
import dad.fxrevenge.combat.CombatController;
import dad.fxrevenge.music.Musica;
import dad.fxrevenge.parameters.Backgrounds;
import dad.fxrevenge.parameters.Bosses;
import dad.fxrevenge.parameters.Player;
import dad.fxrevenge.scene.SceneManager;

public class VFight extends CombatController {

	private static boolean defeated = false;
	// music
	private Musica musica = Musica.v;

	public VFight() throws IOException {
		super(Player.getPlayer(), Bosses.getV(), Backgrounds.getV());
	}

	@Override
	protected void victory() {
		defeated = true;
		musica.getMediaPlayer().stop();
		SceneManager.changeScene(new VDialog());
	}

	public static boolean isDefeated() {
		return defeated;
	}

	public static void setDefeated(boolean defeated) {
		VFight.defeated = defeated;
	}

}
