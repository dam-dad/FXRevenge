package dad.fxrevenge.models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.image.Image;

//añadir seteo de apariencia en constructor
//añadir a RACE los bosses individuales
//añadir generacion de item o gear para posible dropeo
public class Enemy extends Attributes {
	private Race race;
	private IntegerProperty expDrop = new SimpleIntegerProperty();
	private IntegerProperty moneyDrop = new SimpleIntegerProperty();
	private Gear gearDrop;
	private Item itemdrop;
	private ObjectProperty<Image> appearance = new SimpleObjectProperty<Image>();
	private String description;
	private IntegerProperty exp = new SimpleIntegerProperty();
	private IntegerProperty money = new SimpleIntegerProperty();

	/**
	 * Constructor de los personajes enemigos donde se especifican varios valores
	 * 
	 * @param raza  Especifica la raza a la que pertenecera el enemigo creado
	 * @param nivel Especifica el nivel que tendra el enemigo generado
	 */
	public Enemy(Race raza, int nivel) {
		this.race = raza;
		this.setLevel(nivel);

		switch (race) {
		case Demon:
//			this.setName("Fernandinho el demoñoño");
			this.setName(race.toString());
			this.setHealth(90 * nivel);
			this.setPhysDamage(8 * nivel);
			this.setPhysDef(9 * nivel);
			this.setMagicDamage(8 * nivel);
			this.setMagicDef(9 * nivel);

			this.setAppearance(new Image(getClass().getResource("/image/monsters/monster_firebat.png").toString()));
			this.setDescription("A estos monstruos les gusta juntarse y danzar bajo el cielo nocturno.");

			this.setExp(35);
			this.setMoney(2);
			break;
		case Jelly:
//			this.setName("Mira como tiemblo");
			this.setName(race.toString());
			this.setHealth(30 * nivel);
			this.setPhysDamage(3 * nivel);
			this.setPhysDef(4 * nivel);
			this.setMagicDamage(3 * nivel);
			this.setMagicDef(4 * nivel);

			this.setAppearance(new Image(getClass().getResource("/image/monsters/monster_slime.png").toString()));
			this.setDescription("Monstruos comunes que se encuentran por todos lados. ");

			this.setExp(5);
			this.setMoney(0);
			this.setMoneyDrop(0);
			break;
		case Orc:
//			this.setName("Afterparty 5 a.m");
			this.setName(race.toString());
			this.setHealth(60 * nivel);
			this.setPhysDamage(7 * nivel);
			this.setPhysDef(8 * nivel);
			this.setMagicDamage(0);
			this.setMagicDef(3 * nivel);
			this.setDescription("Criaturas de enorme tamaño que pueden aplastar al enemigo con sus colosales mazas.");

			this.setExp(15);
			this.setMoney(9);
			break;
		case Skeleton:
//			this.setName("Huesitos");
			this.setName(race.toString());
			this.setHealth(40 * nivel);
			this.setPhysDamage(3 * nivel);
			this.setPhysDef(3 * nivel);
			this.setMagicDamage(5 * nivel);
			this.setMagicDef(8 * nivel);

			this.setAppearance(new Image(getClass().getResource("/image/monsters/monster_skeletonwarrior.png").toString()));
			this.setDescription(
					"Difuntos soldados que patrullan esperando pillarte.");

			this.setExp(25);
			this.setMoney(1);
		case Zombie:

//			this.setName("Me caigo a trozos");
			this.setName(race.toString());
			this.setHealth(50 * nivel);
			this.setPhysDamage(6 * nivel);
			this.setPhysDef(5 * nivel);
			this.setMagicDamage(0);
			this.setMagicDef(5 * nivel);
			this.setDescription("Cuando se empiezan a pudrir, su aliento y sus uñas de llenan de toxinas.");

			this.setExp(5);
			this.setMoney(15);

		default: // creacion de bosses

//			this.setName("Estoy mamadísimo");
//			this.setName(race.toString());
			this.setHealth(170 * nivel);
			this.setPhysDamage(8 * nivel);
			this.setPhysDef(8 * nivel);
			this.setMagicDamage(8 * nivel);
			this.setMagicDef(8 * nivel);

			this.setExp(150);
			this.setMoneyDrop(40 * nivel);
			break;
		}

		if (!raza.equals(Race.Boss) && !raza.equals(Race.Jelly))
			this.setMoneyDrop(getMoney() + nivel);
		this.setExpDrop(this.getExp() * nivel);
		this.setCurrentLife(this.getHealth());
	}

	/**
	 * Funcion de ataque de los personajes enemigos
	 * 
	 * @return El numero de daño que hara el ataque antes de aplicar los
	 *         modificadores defensivos del objetivo del ataque
	 */
	public int atacar() {

		int danyo = this.getPhysDamage();

		if (!this.race.equals(Race.Boss)) {
			return danyo;
		} else {
			return (int) (danyo * 1.1);
		}

	}

	/**
	 * Funcion encargada de calcular el daño que recibira el enemigo despues de
	 * aplicar sus parametros defensivos
	 * 
	 * @param danyo  Daño base del ataque que recibe
	 * @param fisico Tipo de daño, si es fisico(true) o magico(false)
	 * @return El daño que recibira despues de evaluar los parametros defensivos y
	 *         aplicarlos
	 */
	public int recibeDaño(int danyo, boolean fisico) {

		if (this.race.equals(Race.Boss))
			danyo *= 0.75;

		if (fisico) {
			danyo = (int) (danyo * (1 - (this.getPhysDef() / (100.0 + this.getPhysDef()))));

		} else {
			danyo = (int) (danyo * (1 - (this.getMagicDef() / (100.0 + this.getMagicDef()))));
		}

		if (this.getCurrentLife() < Math.abs(danyo)) {
			danyo = this.getCurrentLife();
			this.setCurrentLife(0);
		} else {
			this.setCurrentLife(
					(int) (this.getCurrentLife() - (danyo * (1 - (this.getPhysDef() / (100.0 + this.getPhysDef()))))));
		}

		return danyo;
	}

	// getters - setters
	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public Gear getGearDrop() {
		return gearDrop;
	}

	public void setGearDrop(Gear gearDrop) {
		this.gearDrop = gearDrop;
	}

	public Item getItemdrop() {
		return itemdrop;
	}

	public void setItemdrop(Item itemdrop) {
		this.itemdrop = itemdrop;
	}

	public void setExpDrop(IntegerProperty expDrop) {
		this.expDrop = expDrop;
	}

	public void setMoneyDrop(IntegerProperty moneyDrop) {
		this.moneyDrop = moneyDrop;
	}

	public final IntegerProperty expDropProperty() {
		return this.expDrop;
	}

	public final int getExpDrop() {
		return this.expDropProperty().get();
	}

	public final void setExpDrop(final int expDrop) {
		this.expDropProperty().set(expDrop);
	}

	public final IntegerProperty moneyDropProperty() {
		return this.moneyDrop;
	}

	public final int getMoneyDrop() {
		return this.moneyDropProperty().get();
	}

	public final void setMoneyDrop(final int moneyDrop) {
		this.moneyDropProperty().set(moneyDrop);
	}

	public Enemy getEnemy() {
		return this;
	}

	public final ObjectProperty<Image> appearanceProperty() {
		return this.appearance;
	}

	public final Image getAppearance() {
		return this.appearanceProperty().get();
	}

	public final void setAppearance(final Image appearance) {
		this.appearanceProperty().set(appearance);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setAppearance(ObjectProperty<Image> appearance) {
		this.appearance = appearance;
	}

	public final IntegerProperty expProperty() {
		return this.exp;
	}

	public final int getExp() {
		return this.expProperty().get();
	}

	public final void setExp(final int exp) {
		this.expProperty().set(exp);
	}

	public final IntegerProperty moneyProperty() {
		return this.money;
	}

	public final int getMoney() {
		return this.moneyProperty().get();
	}

	public final void setMoney(final int money) {
		this.moneyProperty().set(money);
	}

}
