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
	
	public Enemy() {
		
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
	
}
