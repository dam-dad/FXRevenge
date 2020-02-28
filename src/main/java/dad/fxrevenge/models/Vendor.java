package dad.fxrevenge.models;

import java.util.Arrays;

import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

public class Vendor {
	// añadir funciones de vender equipo y pociones

	private ObjectProperty<Image> shopSprite = new SimpleObjectProperty<Image>();
	private ObjectProperty<Image> worldSprite = new SimpleObjectProperty<Image>();;
	private ListProperty<Item> pots = new SimpleListProperty<Item>(this, "pots", FXCollections.observableArrayList());
	private ListProperty<Gear> equipment = new SimpleListProperty<Gear>(this, "equipment",
			FXCollections.observableArrayList());

	/**
	 * Constructor vacio
	 */
	public Vendor() {
		this.setShopSprite(new Image(getClass().getResource("/image/characters/vendor.png").toExternalForm()));
		Item i1 = new Item().generatePotion(Effect.MiniHealRestore),
				i2 = new Item().generatePotion(Effect.MiniManaRestore),
				i3 = new Item().generatePotion(Effect.HealRestore), i4 = new Item().generatePotion(Effect.ManaRestore);
		i1.setQuantity(99);
		i2.setQuantity(99);
		i3.setQuantity(99);
		i4.setQuantity(99);
		this.pots.addAll(Arrays.asList(i1, i2, i3, i4));
	}

	/**
	 * Constructor sobrecargado
	 * 
	 * @param shop  Imagen que tendra el vendedor en la pantalla de tienda
	 * @param world Imagen que tendra el vendedor en el mapa
	 */
	public Vendor(Image shop, Image world) {
		this.setShopSprite(shop);
		this.setWorldSprite(world);
		this.pots.addAll(Arrays.asList(new Item().generatePotion(Effect.MiniHealRestore),
				new Item().generatePotion(Effect.HealRestore), new Item().generatePotion(Effect.MaxiHealRestore),
				new Item().generatePotion(Effect.MiniManaRestore), new Item().generatePotion(Effect.ManaRestore),
				new Item().generatePotion(Effect.MaxiHealRestore)));
	}

	// getters-setters
	public final ListProperty<Item> potsProperty() {
		return this.pots;
	}

	public final ObservableList<Item> getPots() {
		return this.potsProperty().get();
	}

	public final void setPots(final ObservableList<Item> pots) {
		this.potsProperty().set(pots);
	}

	public final ListProperty<Gear> equipmentProperty() {
		return this.equipment;
	}

	public final ObservableList<Gear> getEquipment() {
		return this.equipmentProperty().get();
	}

	public final void setEquipment(final ObservableList<Gear> equipment) {
		this.equipmentProperty().set(equipment);
	}

	public final ObjectProperty<Image> shopSpriteProperty() {
		return this.shopSprite;
	}

	public final Image getShopSprite() {
		return this.shopSpriteProperty().get();
	}

	public final void setShopSprite(final Image shopSprite) {
		this.shopSpriteProperty().set(shopSprite);
	}

	public final ObjectProperty<Image> worldSpriteProperty() {
		return this.worldSprite;
	}

	public final Image getWorldSprite() {
		return this.worldSpriteProperty().get();
	}

	public final void setWorldSprite(final Image worldSprite) {
		this.worldSpriteProperty().set(worldSprite);
	}

}
