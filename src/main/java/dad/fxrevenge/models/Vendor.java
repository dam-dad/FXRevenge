package dad.fxrevenge.models;

import java.util.Arrays;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

public class Vendor {
	//añadir funciones de vender equipo y pociones
	
	private Image shopSprite;
	private Image worldSprite;
	private ListProperty<Item> pots = new SimpleListProperty<Item>(this, "pots", FXCollections.observableArrayList());
	private ListProperty<Gear> equipment = new SimpleListProperty<Gear>(this, "equipment",
			FXCollections.observableArrayList());
	/**
	 * Constructor vacio
	 */
	public Vendor () {
		
	}
	/**
	 * Constructor sobrecargado
	 * @param shop Imagen que tendra el vendedor en la pantalla de tienda
	 * @param world Imagen que tendra el vendedor en el mapa
	 */
	public Vendor (Image shop,Image world) {
		this.shopSprite = shop;
		this.worldSprite = world;
		this.pots.addAll(Arrays.asList(new Item().generatePotion(Effect.MiniHealRestore),new Item().generatePotion(Effect.HealRestore),new Item().generatePotion(Effect.MaxiHealRestore),
				new Item().generatePotion(Effect.MiniManaRestore),new Item().generatePotion(Effect.ManaRestore),new Item().generatePotion(Effect.MaxiHealRestore)));
	}
	
	//getters-setters
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
	
	
	
}
