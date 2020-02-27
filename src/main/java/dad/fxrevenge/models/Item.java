package dad.fxrevenge.models;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

//constructor
public class Item {
	private ObjectProperty<Image> icon = new SimpleObjectProperty<Image>();
	private StringProperty name = new SimpleStringProperty();
	private IntegerProperty quantity = new SimpleIntegerProperty();
	private IntegerProperty price = new SimpleIntegerProperty();
	private Effect effect;

	/**
	 * Constructor base
	 */
	public Item() {

	}

	/**
	 * Constructor sobrecargado con una serie de parametros
	 * 
	 * @param name     Nombre que tendra el objeto
	 * @param quantity Cantidad de usos del objeto
	 * @param price    Precio en tienda del objeto
	 * @param effect   Efecto que tendra el objeto al usarlo
	 */
	public Item(Image icon, String name, Integer quantity, Integer price, Effect effect) {
		this.setIcon(icon);
		this.setName(name);
		this.setQuantity(quantity);
		this.setPrice(price);
		this.effect = effect;
	}

	/**
	 * Genera una unidad de un determinado objeto con un tipo de efecto
	 * 
	 * @param efect El efecto que queremos que tenga el objeto generado
	 * @return El objeto con el efecto deseado
	 */
	public Item generatePotion(Effect efect) {
		Item potion = new Item();

		switch (efect) {
		case MiniHealRestore:
			potion.setName("Mini-Pocion");
			potion.setQuantity(1);
			potion.setPrice(5);
			potion.effect = Effect.MiniHealRestore;
			potion.setIcon(new Image(getClass().getResource("/image/items/MiniHeal.png").toExternalForm()));
			break;
		case HealRestore:
			potion.setName("Pocion");
			potion.setQuantity(1);
			potion.setPrice(10);
			potion.effect = Effect.HealRestore;
			potion.setIcon(new Image(getClass().getResource("/image/items/Heal.png").toExternalForm()));
			break;
		case ManaRestore:
			potion.setName("Elixir");
			potion.setQuantity(1);
			potion.setPrice(8);
			potion.effect = Effect.ManaRestore;
			potion.setIcon(new Image(getClass().getResource("/image/items/Mana.png").toExternalForm()));
			break;
		case MaxiHealRestore:
			potion.setName("MaxiPocion");
			potion.setQuantity(1);
			potion.setPrice(15);
			potion.effect = Effect.MaxiHealRestore;
			potion.setIcon(new Image(getClass().getResource("/image/items/MaxiHeal.png").toExternalForm()));
			break;
		case MaxiManaRestore:
			potion.setName("Maxi-Elixir");
			potion.setQuantity(1);
			potion.setPrice(12);
			potion.effect = Effect.MaxiManaRestore;
			potion.setIcon(new Image(getClass().getResource("/image/items/MaxiMana.png").toExternalForm()));
			break;
		case MiniManaRestore:
			potion.setName("Mini-Elixir");
			potion.setQuantity(1);
			potion.setPrice(4);
			potion.effect = Effect.MiniManaRestore;
			potion.setIcon(new Image(getClass().getResource("/image/items/MiniMana.png").toExternalForm()));
			break;

		}
		return potion;
	}

	/**
	 * Genera una pocion en base a unas determinadas probabilidades
	 * 
	 * @return Devuelve la pocion generada
	 */
	public Item generateRandomPotion() {
		int num = (int) (Math.random() * 100);
		Item pot;
		if (num >= 0 && num <= 5) {
			pot = new Item().generatePotion(Effect.MaxiManaRestore);
		} else if (num > 5 && num <= 35) {
			pot = new Item().generatePotion(Effect.MiniManaRestore);
		} else if (num > 35 && num <= 50) {
			pot = new Item().generatePotion(Effect.ManaRestore);
		} else if (num > 50 && num <= 65) {
			pot = new Item().generatePotion(Effect.HealRestore);
		} else if (num > 65 && num <= 95) {
			pot = new Item().generatePotion(Effect.MiniHealRestore);
		} else {
			pot = new Item().generatePotion(Effect.MaxiHealRestore);
		}
		return pot;
	}

	/**
	 * Funcion que devuelve un String explicativo del efecto del objeto que se le da
	 * 
	 * @param it El objeto del que queremos obtener la descripcion
	 * @return String explicativo del efecto del objeto
	 */

	public String effectDescription(Item it) {
		switch (it.getEffect()) {
		case MiniHealRestore:
			return "Este objeto restaura un 25% de tu salud maxima";
		case HealRestore:
			return "Este objeto restaura un 50% de tu salud maxima";
		case MaxiHealRestore:
			return "Este objeto restaura un 75% de tu salud maxima";
		case MiniManaRestore:
			return "Este objeto restaura un 25% de tu mana maximo";
		case ManaRestore:
			return "Este objeto restaura un 50% de tu mana maximo";	
		case MaxiManaRestore:
			return "Este objeto restaura un 75% de tu mana maximo";
		default:
			return "Efecto desconocido.";
		}
	}

	// setters - getters
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
		return getName() + " x" + getQuantity();
	}

	public final ObjectProperty<Image> iconProperty() {
		return this.icon;
	}

	public final Image getIcon() {
		return this.iconProperty().get();
	}

	public final void setIcon(final Image icon) {
		this.iconProperty().set(icon);
	}

}
