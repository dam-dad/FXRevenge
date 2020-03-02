package dad.fxrevenge.combat;

import java.io.IOException;

import dad.fxrevenge.models.Enemy;
import dad.fxrevenge.music.Musica;
import dad.fxrevenge.parameters.Player;
import dad.fxrevenge.scene.SceneManager;
import dad.fxrevenge.world.WorldMapController;
import javafx.event.ActionEvent;

/**
 * Clase <code>SimpleCombat</code>.
 * 
 * Esta clase simple hereda de CombatController y permite la generación de
 * combates, con enemigos de básicos.
 */
public class SimpleCombat extends CombatController {

	private Enemy enemy;
	WorldMapController world;

	// music
	private Musica musica = new Musica("/music/combat.mp3");

	/**
	 * Constructor <code>SimpleCombat</code>.
	 * 
	 * @param enemy Obtiene el enemy con el que se enfrentará el jugador
	 * @param world Almacena el mundo actual antes de realizar el combate.
	 * @throws devuelve como errror un IOException
	 */
	public SimpleCombat(Enemy enemy, WorldMapController world) throws IOException {
		super(Player.getPlayer(), enemy, world.getBackground());
		musica.playInfiniteSound().play();
		this.enemy = enemy;
		this.world = world;
	}

	/**
	 * Función <code>victory</code>.
	 * 
	 * En caso de victoria, se generá un número aleatorio, del cual obtendremos un
	 * objeto si es menor de 25
	 */
	@Override
	protected void victory() {
		int DropGearProc = (int) (Math.random() * 100);
		if (DropGearProc < 25) {
			Player.getPlayer().equipar(enemy.getGearDrop());
		} else {

		}

		// pendiente de comprobar si suma exp y dinero

		Player.getPlayer().sumarexp(enemy.getExpDrop());
		Player.getPlayer().setMoney(Player.getPlayer().getMoney() + enemy.getMoneyDrop());

		Player.getPlayer().ordenarInventario();

		musica.getMediaPlayer().stop();
		SceneManager.changeScene(world);
	}

	/**
	 * Función <code>onExitAction(</code>.
	 * 
	 * Vuelve al mapa que lo mando al combate.
	 */
	@Override
	protected void onExitAction(ActionEvent event) {
		musica.getMediaPlayer().stop();
		SceneManager.changeScene(world);
	}

}
