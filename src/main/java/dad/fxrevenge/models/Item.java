package dad.fxrevenge.models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;
//constructor
public class Item {
	private Image icon;
	private StringProperty name = new SimpleStringProperty();
	private IntegerProperty quantity = new SimpleIntegerProperty();
	private IntegerProperty price = new SimpleIntegerProperty();
	private Effect effect;
	
	public Item() {
		
	}
	
	public Item(Image icon, String name, Integer quantity, Integer price, Effect effect) {
		super();
		this.icon = icon;
		this.setName(name);
		this.setQuantity(quantity);
		this.setPrice(price);
		this.effect = effect;
	}
	
	public Item generatePotion(Effect efect) {
		Item potion = new Item();
		
		switch (efect) {
		case MiniHealRestore:
			potion.setName("Mini-Pocion");
			potion.setQuantity(1);
			potion.setPrice(5);
			potion.effect=Effect.MiniHealRestore;
			break;
		case HealRestore:
			potion.setName("Pocion");
			potion.setQuantity(1);
			potion.setPrice(10);
			potion.effect=Effect.HealRestore;
			break;
		case ManaRestore:
			potion.setName("Elixir");
			potion.setQuantity(1);
			potion.setPrice(10);
			potion.effect=Effect.ManaRestore;
			break;
		case MaxiHealRestore:
			potion.setName("MaxiPocion");
			potion.setQuantity(1);
			potion.setPrice(15);
			potion.effect=Effect.MaxiHealRestore;
			break;
		case MaxiManaRestore:
			potion.setName("Maxi-Elixir");
			potion.setQuantity(1);
			potion.setPrice(15);
			potion.effect=Effect.MaxiManaRestore;
			break;
		case MiniManaRestore:
			potion.setName("Mini-Elixir");
			potion.setQuantity(1);
			potion.setPrice(5);
			potion.effect=Effect.MiniManaRestore;
			break;
		
		}
		return potion;
	}
	public String effectDescription(Item it) {
		if (it.effect.equals(Effect.HealRestore) || it.effect.equals(Effect.MaxiHealRestore) || it.effect.equals(Effect.MiniHealRestore) ) {
			return "Este objeto restaura una parte de tu salud"; 
		} else {
			return "Este objeto restaura una parte de tu maná";
		}
	}


	public Effect getEffect() {
		return effect;
	}

	public void setEffect(Effect effect) {
		this.effect = effect;
	}

	public final StringProperty nameProperty() {
		return this.name;
	}
	
	public final String getName() {
		return this.nameProperty().get();
	}
	
	public final void setName(final String name) {
		this.nameProperty().set(name);
	}
	
	public final IntegerProperty quantityProperty() {
		return this.quantity;
	}
	
	public final int getQuantity() {
		return this.quantityProperty().get();
	}
	
	public final void setQuantity(final int quantity) {
		this.quantityProperty().set(quantity);
	}
	
	public final IntegerProperty priceProperty() {
		return this.price;
	}
	
	public final int getPrice() {
		return this.priceProperty().get();
	}
	
	public final void setPrice(final int price) {
		this.priceProperty().set(price);
	}
	
	@Override
	public String toString() {
		return getName()+" x"+getQuantity();
	}
	
}
