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

/**
 * Clase que define las habilidades de los personajes
 */
public class Skill {
	private StringProperty name = new SimpleStringProperty();
	private IntegerProperty cost = new SimpleIntegerProperty();
	private IntegerProperty unlockLevel = new SimpleIntegerProperty();
	private IntegerProperty Damage = new SimpleIntegerProperty();
	private BooleanProperty DamageType = new SimpleBooleanProperty(); // true = fisico false = magico
	private DoubleProperty DamageMultiplier = new SimpleDoubleProperty();
	private IntegerProperty AddCritChance = new SimpleIntegerProperty();
	private StringProperty Description = new SimpleStringProperty();

	/**
	 * Constructor vacio base de una habilidad
	 */
	public Skill() {

	}
	/**
	 * Constructor de una habilidad
	 * 
	 * @param name nombre
	 * @param cost coste
	 * @param unlockLevel nivel al que se desbloquea
	 * @param damage daño base
	 * @param damageType tipo de daño que inflige
	 * @param damageMultiplier daño adicional en base al daño del personaje
	 * @param addCritChance probabilidad base adicional para ser critico de la habilidad
	 * @param descript Describe el tipo de habilidad
	 */
	public Skill(String name, Integer cost, Integer unlockLevel, Integer damage,
			Boolean damageType, Double damageMultiplier, Integer addCritChance, String descript) {
		super();
		this.setName(name);
		this.setCost(cost);
		this.setUnlockLevel(unlockLevel);
		this.setDamage(damage);
		this.setDamageType(damageType);
		this.setDamageMultiplier(damageMultiplier);
		this.setAddCritChance(addCritChance);
		this.setDescription(descript);
	}


	//solo hay skills de prueba
	/**
	 * Funcion que permite generar las habilidades de un personaje en base a su clase
	 * 
	 * @param job clase del personaje
	 * @return lista de todas las habilidades que posee el personaje
	 */
	public static List<Skill> generateClassSkills(ClassType job) {
		ArrayList<Skill> habilidades = new ArrayList<Skill>();
		//skill(nombre,costemana,nivel de desbloqueo,daño base de la habilidad, tipo de daño (true=fisico / false=magico),
		//multiplicador de daño, porcentaje de critico extra)
		
		//Habilidades pendiente de testeo y ajustes una vez se prueben in-game
		switch (job) {
		case Archmage:
			habilidades.add(new Skill("Piro",3,1,5,false,1.1,0,"Generas una bola de fuego en tu mano y la lanzas hacia tu enemigo"));
			habilidades.add(new Skill("Electro",5,3,7,false,1.1,0,"Alzas tu arma al cielo para invocar una corriente eléctrica que daña a tu enemigo"));
			habilidades.add(new Skill("Icicle",7,5,9,false,1.2,0,"Condensas la humedad alrededor de tu mano, enfriándola para generar una estaca de hielo para lanzarla hacia tu enemigo"));
			habilidades.add(new Skill("Thunder",10,7,15,false,1.4,0,"Poderoso conjuro que hace caer un poderoso relámpago sobre tu enemigo"));
			habilidades.add(new Skill("Soul-Beam",20,9,35,false,1.7,30,"Extraes el poder mágico de tu alma y lo concentras en tu báculo para lanzar un poderoso laser que daña a tus enemigos"));
			habilidades.add(new Skill("Cataclsym",50,13,50,false,2.0,50,"Convocas las fuerzas de la naturaleza haciendo caer su ira sobre tus enemigos"));
			break;
		case Warlord:
			habilidades.add(new Skill("Slash",3,1,5,true,1.1,0,"Un poderoso tajo con tu arma hacia el enemigo"));
			habilidades.add(new Skill("Double-Slash",5,3,10,true,1.2,0,"Realiza dos poderosos y rápidos tajos sobre el enemigo"));
			habilidades.add(new Skill("Final Slash",7,5,12,true,1.4,10,"Te concentras para analizar a tu enemigo, buscando un punto debil al cual atacas con un poderoso tajo que causa mucho daño"));
			habilidades.add(new Skill("Shield-Slam",9,3,7,true,1.2,10,"Golpeas con el canto del escudo a tu enemigo haciendole un poco de daño"));
			habilidades.add(new Skill("Shield-Bash",11,5,10,true,1.3,15,"Agarras el escudo con ambas manos para golpear con fuerza al enemigo"));
			habilidades.add(new Skill("Shield-Crash",13,7,15,true,1.5,20,"Arremetes con ferocidad hacia el enemigo utilizando toda tu fuerza para ello"));
			break;
		default: //hunter
			habilidades.add(new Skill("Shot",3,1,10,true,1.2,0,"Dispara una flecha normal hacia tu enemigo"));
			habilidades.add(new Skill("Double-Shot",4,3,13,true,1.2,0,"Dispara dos flechas normales hacia tu enemigo"));
			habilidades.add(new Skill("Aimed-Shot",6,5,15,true,1.3,0,"Te concentras y apuntas hacia un organo vital de tu enemigo antes de disparar"));
			habilidades.add(new Skill("Heavy-Shot",8,7,17,true,1.5,10,"Dispara una flecha pesada a tu enemigo"));
			habilidades.add(new Skill("Dragon-Shot",10,9,20,true,1.7,30,"Disparas una flecha dracónica a tu enemigo, causando mucho daño"));
			habilidades.add(new Skill("Kill-Shot",15,11,25,true,2.0,80,"Te concentras totalmente en los puntos vitales de tu enemigo y disparas una flecha que perseguirá al enemigo hasta golpearlo"));
			
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
	public final StringProperty DescriptionProperty() {
		return this.Description;
	}
	
	public final String getDescription() {
		return this.DescriptionProperty().get();
	}
	
	public final void setDescription(final String Description) {
		this.DescriptionProperty().set(Description);
	}
	
	

}
