package dad.fxrevenge.models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.image.Image;

//falta setear las apariencias
//añadir generacion de item o gear para posible dropeo
public class Enemy extends Attributes {
	private Race race;
	private IntegerProperty expDrop = new SimpleIntegerProperty();
	private IntegerProperty moneyDrop = new SimpleIntegerProperty();
	private Gear gearDrop;
	private Item itemdrop;
	private ObjectProperty<Image> appearance = new SimpleObjectProperty<Image>();

	public Enemy(Race raza, int nivel) {
		this.race = raza;
		switch (race) {
		case Demon:
//			this.setName("Fernandinho el demoñoño");
			this.setName(race.toString());
			this.setHealth(90 * nivel);
			this.setPhysDamage(8 * nivel);
			this.setPhysDef(9 * nivel);
			this.setMagicDamage(8 * nivel);
			this.setMagicDef(9 * nivel);

			this.setExpDrop(35 * nivel);
			this.setMoneyDrop(2 + nivel);
			break;
		case Jelly:
//			this.setName("Mira como tiemblo");
			this.setName(race.toString());
			this.setHealth(30 * nivel);
			this.setPhysDamage(3 * nivel);
			this.setPhysDef(4 * nivel);
			this.setMagicDamage(3 * nivel);
			this.setMagicDef(4 * nivel);

			this.setExpDrop(5 * nivel);
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

			this.setExpDrop(15 * nivel);
			this.setMoneyDrop(9 + nivel);
			break;
		case Skeleton:
//			this.setName("Huesitos");
			this.setName(race.toString());
			this.setHealth(40 * nivel);
			this.setPhysDamage(3 * nivel);
			this.setPhysDef(3 * nivel);
			this.setMagicDamage(5 * nivel);
			this.setMagicDef(8 * nivel);

			this.setExpDrop(25 * nivel);
			this.setMoneyDrop(1 + nivel);
		case Zombie:

//			this.setName("Me caigo a trozos");
			this.setName(race.toString());
			this.setHealth(50 * nivel);
			this.setPhysDamage(6 * nivel);
			this.setPhysDef(5 * nivel);
			this.setMagicDamage(0);
			this.setMagicDef(5 * nivel);

			this.setExpDrop(5 * nivel);
			this.setMoneyDrop(15 + nivel);
			
		default: // creacion de bosses
			
//			this.setName("Estoy mamadísimo");
//			this.setName(race.toString());
			this.setHealth(170 * nivel);
			this.setPhysDamage(8 * nivel);
			this.setPhysDef(8 * nivel);
			this.setMagicDamage(8 * nivel);
			this.setMagicDef(8 * nivel);
			

			this.setExpDrop(150 * nivel);
			this.setMoneyDrop(40 * nivel);
			break;
		}
		this.setCurrentLife(this.getHealth());
	}

	public int atacar() {

		int danyo = this.getPhysDamage();

		if (!this.race.equals(Race.Boss)) {
			return danyo;
		} else {
			return (int) (danyo * 1.1);
		}

	}

	public int recibeDaño(int danyo, boolean fisico) {

		if (this.race.equals(Race.Boss))
			danyo *= 0.75;

		if (fisico) {
			danyo = (int) (danyo * (1 - (this.getPhysDef() / (100.0 + this.getPhysDef()))));

		} else {
			danyo = (int) (danyo * (1 - (this.getMagicDef() / (100.0 + this.getMagicDef()))));
		}

		if(this.getCurrentLife()<Math.abs(danyo)) {
			danyo = this.getCurrentLife();
			this.setCurrentLife(0);
		}else {
			this.setCurrentLife(
					(int) (this.getCurrentLife() - (danyo * (1 - (this.getPhysDef() / (100.0 + this.getPhysDef()))))));
		}

		return danyo;
	}

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

}
