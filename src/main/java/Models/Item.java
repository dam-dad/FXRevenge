package Models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;
//constructor
public class Item {
	Image icon;
	StringProperty name = new SimpleStringProperty();
	IntegerProperty quantity = new SimpleIntegerProperty();
	IntegerProperty price = new SimpleIntegerProperty();
	Effect effect;
	
	public Item() {
		
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
