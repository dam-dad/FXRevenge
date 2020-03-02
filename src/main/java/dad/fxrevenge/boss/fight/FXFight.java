package dad.fxrevenge.boss.fight;

import java.io.IOException;

import dad.fxrevenge.boss.dialog.FXDialog;
import dad.fxrevenge.combat.CombatController;
import dad.fxrevenge.music.Musica;
import dad.fxrevenge.parameters.Backgrounds;
import dad.fxrevenge.parameters.Bosses;
import dad.fxrevenge.parameters.Player;
import dad.fxrevenge.scene.SceneManager;

public class FXFight extends CombatController {

	private static boolean defeated = false;
	// music
	private Musica musica = Musica.fx;

	public FXFight() throws IOException {
		super(Player.getPlayer(), Bosses.getFX(), Backgrounds.getFX());
	}

	@Override
	protected void victory() {
		defeated = true;
		musica.getMediaPlayer().stop();
		SceneManager.changeScene(new FXDialog());
	}

	public static boolean isDefeated() {
		return defeated;
	}

	public static void setDefeated(boolean defeated) {
		FXFight.defeated = defeated;
	}

}
