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
	
	public Item generateHealPotion() {
		Item potion = new Item();
		potion.setName("Pocion");
		potion.setQuantity(1);
		potion.setPrice(5);
		potion.effect=Effect.HealRestore;
		return potion;
	}
	public Item generateManaPotion() {
		Item potion = new Item();
		potion.setName("Elixir");
		potion.setQuantity(1);
		potion.setPrice(5);
		potion.effect=Effect.ManaRestore;
		return potion;
	}
	public String effectDescription(Item it) {
		if (it.effect.equals(Effect.HealRestore)) {
			return "Este objeto restaura tu salud al máximo"; 
		} else {
			return "Este objeto restaura tu maná al máximo";
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
