package Models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Attributes {
	StringProperty id = new SimpleStringProperty();
	StringProperty name = new SimpleStringProperty();
	IntegerProperty level = new SimpleIntegerProperty();
	IntegerProperty Health = new SimpleIntegerProperty();
	IntegerProperty Agility = new SimpleIntegerProperty();
	IntegerProperty Luck = new SimpleIntegerProperty();
	IntegerProperty CritDamage = new SimpleIntegerProperty();
	IntegerProperty PhysDamage = new SimpleIntegerProperty();
	IntegerProperty PhysDef = new SimpleIntegerProperty();
	IntegerProperty Mana = new SimpleIntegerProperty();
	IntegerProperty MagicDamage = new SimpleIntegerProperty();
	IntegerProperty MagicDef = new SimpleIntegerProperty();
	

	public final StringProperty idProperty() {
		return this.id;
	}
	
	public final String getId() {
		return this.idProperty().get();
	}
	
	public final void setId(final String id) {
		this.idProperty().set(id);
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
	
	public final IntegerProperty levelProperty() {
		return this.level;
	}
	
	public final int getLevel() {
		return this.levelProperty().get();
	}
	
	public final void setLevel(final int level) {
		this.levelProperty().set(level);
	}
	
	public final IntegerProperty HealthProperty() {
		return this.Health;
	}
	
	public final int getHealth() {
		return this.HealthProperty().get();
	}
	
	public final void setHealth(final int Health) {
		this.HealthProperty().set(Health);
	}
	
	public final IntegerProperty AgilityProperty() {
		return this.Agility;
	}
	
	public final int getAgility() {
		return this.AgilityProperty().get();
	}
	
	public final void setAgility(final int Agility) {
		this.AgilityProperty().set(Agility);
	}
	
	public final IntegerProperty LuckProperty() {
		return this.Luck;
	}
	
	public final int getLuck() {
		return this.LuckProperty().get();
	}
	
	public final void setLuck(final int Luck) {
		this.LuckProperty().set(Luck);
	}
	
	public final IntegerProperty CritDamageProperty() {
		return this.CritDamage;
	}
	
	public final int getCritDamage() {
		return this.CritDamageProperty().get();
	}
	
	public final void setCritDamage(final int CritDamage) {
		this.CritDamageProperty().set(CritDamage);
	}
	
	public final IntegerProperty PhysDamageProperty() {
		return this.PhysDamage;
	}
	
	public final int getPhysDamage() {
		return this.PhysDamageProperty().get();
	}
	
	public final void setPhysDamage(final int PhysDamage) {
		this.PhysDamageProperty().set(PhysDamage);
	}
	
	public final IntegerProperty PhysDefProperty() {
		return this.PhysDef;
	}
	
	public final int getPhysDef() {
		return this.PhysDefProperty().get();
	}
	
	public final void setPhysDef(final int PhysDef) {
		this.PhysDefProperty().set(PhysDef);
	}
	
	public final IntegerProperty ManaProperty() {
		return this.Mana;
	}
	
	public final int getMana() {
		return this.ManaProperty().get();
	}
	
	public final void setMana(final int Mana) {
		this.ManaProperty().set(Mana);
	}
	
	public final IntegerProperty MagicDamageProperty() {
		return this.MagicDamage;
	}
	
	public final int getMagicDamage() {
		return this.MagicDamageProperty().get();
	}
	
	public final void setMagicDamage(final int MagicDamage) {
		this.MagicDamageProperty().set(MagicDamage);
	}
	
	public final IntegerProperty MagicDefProperty() {
		return this.MagicDef;
	}
	
	public final int getMagicDef() {
		return this.MagicDefProperty().get();
	}
	
	public final void setMagicDef(final int MagicDef) {
		this.MagicDefProperty().set(MagicDef);
	}
	
	
}
