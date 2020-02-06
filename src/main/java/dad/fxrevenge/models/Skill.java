package dad.fxrevenge.models;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

//añadir funcion: generarSkills( recibe una clase) y genera las skills de esa clase
public class Skill {
	private StringProperty name = new SimpleStringProperty();
	private IntegerProperty cost = new SimpleIntegerProperty();
	private IntegerProperty unlockLevel = new SimpleIntegerProperty();
	private IntegerProperty Damage = new SimpleIntegerProperty();
	private BooleanProperty DamageType = new SimpleBooleanProperty(); // true = fisico false = magico
	private DoubleProperty DamageMultiplier = new SimpleDoubleProperty();
	private IntegerProperty AddCritChance = new SimpleIntegerProperty();

	public Skill() {

	}
	
	public Skill(String name, Integer cost, Integer unlockLevel, Integer damage,
			Boolean damageType, Double damageMultiplier, Integer addCritChance) {
		super();
		this.setName(name);
		this.setCost(cost);
		this.setUnlockLevel(unlockLevel);
		this.setDamage(damage);
		this.setDamageType(damageType);
		this.setDamageMultiplier(damageMultiplier);
		this.setAddCritChance(addCritChance);
	}


	//solo hay skills de prueba, añadir mas y ver como hacerlo desde json
	public List<Skill> generateClassSkills(ClassType job) {
		ArrayList<Skill> habilidades = new ArrayList<Skill>();
		//skill(nombre,costemana,nivel de desbloqueo,daño base de la habilidad, tipo de daño (true=fisico / false=magico),
		//multiplicador de daño, porcentaje de critico extra)
		switch (job) {
		case Archmage:
			habilidades.add(new Skill("Piro",3,1,5,false,0.1,0));
			habilidades.add(new Skill("Electro",3,1,5,false,0.1,0));
			habilidades.add(new Skill("Thunder",3,2,5,false,0.1,0));
			habilidades.add(new Skill("Icicle",3,1,5,false,0.1,0));
			break;
		case Warlord:
			habilidades.add(new Skill("Slash",3,1,5,true,0.1,0));
			habilidades.add(new Skill("Double-Slash",5,1,10,true,0.2,0));
			break;
		default: //hunter
			habilidades.add(new Skill("Shot",5,1,10,true,0.2,0));
			habilidades.add(new Skill("Double-Shot",5,1,10,true,0.2,0));
			habilidades.add(new Skill("Aimed-Shot",5,1,15,true,0.3,0));
			break;
		}
		return habilidades;
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

	public final DoubleProperty DamageMultiplierProperty() {
		return this.DamageMultiplier;
	}

	public final double getDamageMultiplier() {
		return this.DamageMultiplierProperty().get();
	}

	public final void setDamageMultiplier(final double DamageMultiplier) {
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
		return getName() + " (" + getCost() + ")";
	}

	public final IntegerProperty unlockLevelProperty() {
		return this.unlockLevel;
	}

	public final int getUnlockLevel() {
		return this.unlockLevelProperty().get();
	}

	public final void setUnlockLevel(final int unlockLevel) {
		this.unlockLevelProperty().set(unlockLevel);
	}
	

}
