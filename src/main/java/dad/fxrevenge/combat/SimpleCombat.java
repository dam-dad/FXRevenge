package dad.fxrevenge.combat;

import java.io.IOException;

import dad.fxrevenge.models.Enemy;
import dad.fxrevenge.parameters.Player;
import dad.fxrevenge.scene.SceneManager;
import dad.fxrevenge.world.WorldMapController;
import javafx.event.ActionEvent;

/**
 * Clase <code>SimpleCombat</code>.
 * 
 * @implNote Esta clase simple hereda de CombatController y permite la
 *           generación de combates, con enemigos de básicos.
 */
public class SimpleCombat extends CombatController {

	private Enemy enemy;
	WorldMapController world;

	/**
	 * Constructor <code>SimpleCombat</code>.
	 * 
	 * @param enemy Obtiene el enemy con el que se enfrentará el jugador
	 * @param world Almacena el mundo actual antes de realizar el combate.
	 * 
	 */
	public SimpleCombat(Enemy enemy, WorldMapController world) throws IOException {
		super(Player.getPlayer(), enemy, world.getBackground());
		this.enemy = enemy;
		this.world = world;
	}

	/**
	 * Función <code>victory</code>.
	 * @implNote En caso de victoria, se generá un número aleatorio, 
	 * del cual obtendremos un objeto si es menor de 25
	 */
	@Override
	protected void victory() {
		int DropGearProc = (int) (Math.random() * 100);
		if (DropGearProc < 25) {
			Player.getPlayer().equipar(enemy.getGearDrop());
		} else {

		}

		// pendiente de comprobar si suma exp y dinero
		System.out.println("Exp actual: " + Player.getPlayer().getCurrentExp() + " /Total: "
				+ Player.getPlayer().getTotalLevelExp());
		Player.getPlayer().sumarexp(enemy.getExpDrop());
		System.out.println("Enemy exp: " + enemy.getExp());
		System.out.println("After Exp actual: " + Player.getPlayer().getCurrentExp() + " /Total: "
				+ Player.getPlayer().getTotalLevelExp());
		System.out.println("Player money: " + Player.getPlayer().getMoney());
		System.out.println("Enemy money: " + enemy.getMoneyDrop());
		Player.getPlayer().setMoney(Player.getPlayer().getMoney() + enemy.getMoneyDrop());
		System.out.println("Player money after: " + Player.getPlayer().getMoney());

		Player.getPlayer().ordenarInventario();

		SceneManager.changeScene(world);
	}
	/**
	 * Función <code>onExitAction(</code>.
	 * @implNote Vuelve al mapa.
	 */
	@Override
	protected void onExitAction(ActionEvent event) {
		SceneManager.changeScene(world);
	}

}
