package Models;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
 //añadir constructor con gson
public class Skill {
	StringProperty name = new SimpleStringProperty();
	IntegerProperty cost = new SimpleIntegerProperty();
	IntegerProperty unlockLevel = new SimpleIntegerProperty();
	IntegerProperty Damage = new SimpleIntegerProperty();
	BooleanProperty DamageType = new SimpleBooleanProperty();
	IntegerProperty DamageMultiplier = new SimpleIntegerProperty();
	IntegerProperty AddCritChance = new SimpleIntegerProperty();
//	ClassType forjob;
	
	public Skill () {
		
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
	
	public final IntegerProperty costProperty() {
		return this.cost;
	}
	
	public final int getCost() {
		return this.costProperty().get();
	}
	
	public final void setCost(final int cost) {
		this.costProperty().set(cost);
	}
	
	public final IntegerProperty DamageProperty() {
		return this.Damage;
	}
	
	public final int getDamage() {
		return this.DamageProperty().get();
	}
	
	public final void setDamage(final int Damage) {
		this.DamageProperty().set(Damage);
	}
	
	public final BooleanProperty DamageTypeProperty() {
		return this.DamageType;
	}
	
	public final boolean getDamageType() {
		return this.DamageTypeProperty().get();
	}
	
	public final void setDamageType(final boolean DamageType) {
		this.DamageTypeProperty().set(DamageType);
	}
	
	public final IntegerProperty DamageMultiplierProperty() {
		return this.DamageMultiplier;
	}
	
	public final int getDamageMultiplier() {
		return this.DamageMultiplierProperty().get();
	}
	
	public final void setDamageMultiplier(final int DamageMultiplier) {
		this.DamageMultiplierProperty().set(DamageMultiplier);
	}
	
	public final IntegerProperty AddCritChanceProperty() {
		return this.AddCritChance;
	}
	
	public final int getAddCritChance() {
		return this.AddCritChanceProperty().get();
	}
	
	public final void setAddCritChance(final int AddCritChance) {
		this.AddCritChanceProperty().set(AddCritChance);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getName()+" ("+getCost()+")";
	}
	
}
