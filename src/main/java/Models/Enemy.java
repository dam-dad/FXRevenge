package Models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
//constructor
public class Enemy extends Attributes{
	Race race;
	IntegerProperty expDrop = new SimpleIntegerProperty();
	IntegerProperty moneyDrop = new SimpleIntegerProperty();
	Gear gearDrop;
	Item itemdrop;
	
	public Enemy(Race raza,int nivel) {
		this.race=raza;
		switch(race) {
		case Demon:
			this.setExpDrop(35*nivel);
			this.setMoneyDrop(2+nivel);
			break;
		case Jelly:
			this.setExpDrop(5*nivel);
			this.setMoneyDrop(0);
			break;
		case Orc:
			this.setExpDrop(15*nivel);
			this.setMoneyDrop(9+nivel);
			break;
		case Skeleton:
			this.setExpDrop(25*nivel);
			this.setMoneyDrop(1+nivel);
		case Zombie:
			this.setExpDrop(5*nivel);
			this.setMoneyDrop(15+nivel);
		default:
			this.setExpDrop(150*nivel);
			this.setMoneyDrop(40*nivel);
			break;
		}
	}
	
	public int atacar() {

		int danyo=this.getPhysDamage();
		
		if(!this.race.equals(Race.Boss)) {
			return danyo;
		}else {
			return (int) (danyo*1.1);
		}

	}
	
	public void recibeDaño(int danyo,boolean fisico) {
	
		if(this.race.equals(Race.Boss))
			danyo*=0.75;
		
		else {
			if(fisico)
				this.currentLife.set(this.getCurrentLife()-(danyo-this.getPhysDef()));
			else
				this.currentLife.set(this.getCurrentLife()-(danyo-this.getMagicDef()));
		}
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
}
