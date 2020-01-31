package Models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
//constructor
public class Avatar extends Attributes{
	IntegerProperty currentExp = new SimpleIntegerProperty();
	IntegerProperty totalLevelExp = new SimpleIntegerProperty();
	IntegerProperty money = new SimpleIntegerProperty();
	Image appearance;
	ClassType work;
	ListProperty<Item> inventory = new SimpleListProperty<Item>();
	ListProperty<Gear> equipped = new SimpleListProperty<Gear>();
	
	public Avatar() {
		
	}
	
	public final IntegerProperty currentExpProperty() {
		return this.currentExp;
	}
	
	public final int getCurrentExp() {
		return this.currentExpProperty().get();
	}
	
	public final void setCurrentExp(final int currentExp) {
		this.currentExpProperty().set(currentExp);
	}
	
	public final IntegerProperty totalLevelExpProperty() {
		return this.totalLevelExp;
	}
	
	public final int getTotalLevelExp() {
		return this.totalLevelExpProperty().get();
	}
	
	public final void setTotalLevelExp(final int totalLevelExp) {
		this.totalLevelExpProperty().set(totalLevelExp);
	}

	public Image getAppearance() {
		return appearance;
	}

	public void setAppearance(Image appearance) {
		this.appearance = appearance;
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
	

	public final ListProperty<Item> inventoryProperty() {
		return this.inventory;
	}
	

	public final ObservableList<Item> getInventory() {
		return this.inventoryProperty().get();
	}
	

	public final void setInventory(final ObservableList<Item> inventory) {
		this.inventoryProperty().set(inventory);
	}
	

	public final ListProperty<Gear> equippedProperty() {
		return this.equipped;
	}
	

	public final ObservableList<Gear> getEquipped() {
		return this.equippedProperty().get();
	}
	

	public final void setEquipped(final ObservableList<Gear> equipped) {
		this.equippedProperty().set(equipped);
	}
	

}
