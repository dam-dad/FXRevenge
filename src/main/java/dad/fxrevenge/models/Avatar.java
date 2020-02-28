package dad.fxrevenge.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;

public class Avatar extends Attributes {

	private IntegerProperty currentExp = new SimpleIntegerProperty();
	private IntegerProperty totalLevelExp = new SimpleIntegerProperty();
	private IntegerProperty money = new SimpleIntegerProperty();
	private ObjectProperty<Image> combatSprite = new SimpleObjectProperty<Image>();
	private ObjectProperty<Image> worldSprite = new SimpleObjectProperty<Image>();
	private ClassType work;
	private ListProperty<Item> inventory = new SimpleListProperty<Item>(this, "inventory",
			FXCollections.observableArrayList());
	private ListProperty<Gear> equipped = new SimpleListProperty<Gear>(this, "equipped",
			FXCollections.observableArrayList());
	private ListProperty<Skill> skills = new SimpleListProperty<Skill>(this, "skills",
			FXCollections.observableArrayList());
	private ListProperty<Skill> learnedSkills = new SimpleListProperty<Skill>(this, "learnedSkills",
			FXCollections.observableArrayList());
	private IntegerProperty currentMana = new SimpleIntegerProperty();

	/**
	 * Constructor del personaje protagonista
	 * 
	 * @param appearance Imagen para el aspecto del personaje principal
	 * @param work       Clase del personaje
	 * @param skills     Lista de habilidades que podra aprender el personaje
	 * @param name       Nombre que tendra el personaje
	 */
	public Avatar(Image appearance, ClassType work, List<Skill> skills, String name) {
		this.setLevel(1);
		this.setWork(work);
		this.setCurrentExp(0);
		this.setMoney(0);
		this.setName(name);
		this.setLevel(1);
		this.setLuck(0);
		this.setTotalLevelExp(150);
		this.setCombatSprite(appearance);
		this.setCritChance(0);
		this.setSkills(FXCollections.observableArrayList(Skill.generateClassSkills(work)));
		skillchecker();

		Gear helm = new Gear("Casco de practicas");
		helm.setPos(GearPosition.Helmet);
		Gear chest = new Gear("Peto de practicas");
		chest.setPos(GearPosition.Chest);
		Gear gloves = new Gear("Guanteletes de practicas");
		gloves.setPos(GearPosition.Gloves);
		Gear leggings = new Gear("Pantalones de practicas");
		leggings.setPos(GearPosition.Leggings);
		Gear boots = new Gear("Botas de practicas");
		boots.setPos(GearPosition.Boots);
		Gear rightHand = new Gear("Arma de Practica");
		rightHand.setPos(GearPosition.RightHand);
		Gear leftHand = new Gear("Complemento de practica");
		leftHand.setPos(GearPosition.LeftHand);

		this.equipped.addAll(helm, chest, gloves, leggings, boots, rightHand, leftHand);

		if (work.equals(ClassType.Archmage)) {

			this.setHealth(920);
			this.setPhysDamage(72);
			this.setPhysDef(5);
			this.setMana(20);
			this.setMagicDamage(9);
			this.setMagicDef(7);
			this.inventory.addAll(new Item().generatePotion(Effect.MiniManaRestore),
					new Item().generatePotion(Effect.MiniManaRestore),
					new Item().generatePotion(Effect.MiniHealRestore));
			

		} else if (work.equals(ClassType.Hunter)) {

			this.setHealth(925);
			this.setPhysDamage(78);
			this.setPhysDef(5);
			this.setMana(15);
			this.setMagicDamage(0);
			this.setMagicDef(3);

			this.inventory.addAll(new Item().generatePotion(Effect.MiniManaRestore),
					new Item().generatePotion(Effect.MiniHealRestore),
					new Item().generatePotion(Effect.MiniHealRestore));

		} else if (work.equals(ClassType.Warlord)) {

			this.setHealth(930);
			this.setPhysDamage(75);
			this.setPhysDef(10);
			this.setMana(10);
			this.setMagicDamage(0);
			this.setMagicDef(10);
			this.inventory.addAll(new Item().generatePotion(Effect.MiniHealRestore),
					new Item().generatePotion(Effect.MiniHealRestore),
					new Item().generatePotion(Effect.MiniHealRestore));
		}

		this.ordenarInventario();
		
		this.setCurrentLife(this.getHealth());
		this.setCurrentMana(this.getMana());

	}

	/**
	 * Funcion que comprueba si al subir de nivel el personaje puede aprender nuevas
	 * habilidades y en caso positivo, las aprende
	 */
	private void skillchecker() {
		learnedSkills.clear();
		for (int i = 0; i < skills.size(); i++) {
			if (skills.get(i).getUnlockLevel() <= this.getLevel()) {
				learnedSkills.add(skills.get(i));
			}
		}
	}

	/**
	 * Funcion utilizada para añadir un objeto al inventario
	 * 
	 * @param item Objeto que se añadira al inventario
	 */
	public void addItemToInventory(Item item) {
		Boolean added = false;
		for (int i = 0; i < this.getInventory().size(); i++) {
			if (this.getInventory().get(i).getName().equals(item.getName())) {
				this.getInventory().get(i).setQuantity(this.getInventory().get(i).getQuantity() + 1);
				added = true;
			}
		}
		if (!added) {
			this.getInventory().add(item);
		}
	}

	/**
	 * Utilizar un objeto que se encuentre en el inventario
	 * 
	 * @param item El objeto que se utilizara
	 */
	public void useItem(Item item) {
		switch (item.getEffect()) {
		case MiniHealRestore:
			if (this.getCurrentLife() + this.getHealth() * 0.25 > this.getHealth()) {
				this.setCurrentLife(this.getHealth());
			} else {
				this.setCurrentLife(((int) (this.getCurrentLife() + this.getHealth() * 0.25)));
			}
			break;
		case HealRestore:
			if (this.getCurrentLife() + this.getHealth() * 0.5 > this.getHealth()) {
				this.setCurrentLife(this.getHealth());
			} else {
				this.setCurrentLife(((int) (this.getCurrentLife() + this.getHealth() * 0.5)));
			}
			break;
		case MaxiHealRestore:
			if (this.getCurrentLife() + this.getHealth() * 0.75 > this.getHealth()) {
				this.setCurrentLife(this.getHealth());
			} else {
				this.setCurrentLife(((int) (this.getCurrentLife() + this.getHealth() * 0.75)));
			}
			break;
		case MiniManaRestore:
			if (this.getCurrentMana() + this.getMana() * 0.25 > this.getMana()) {
				this.setCurrentMana(this.getMana());
			} else {
				this.setCurrentMana(((int) (this.getCurrentMana() + this.getMana() * 0.25)));
			}
			break;
		case ManaRestore:
			if (this.getCurrentMana() + this.getMana() * 0.5 > this.getMana()) {
				this.setCurrentMana(this.getMana());
			} else {
				this.setCurrentMana(((int) (this.getCurrentMana() + this.getMana() * 0.5)));
			}
			break;
		case MaxiManaRestore:
			if (this.getCurrentMana() + this.getMana() * 0.75 > this.getMana()) {
				this.setCurrentMana(this.getMana());
			} else {
				this.setCurrentMana(((int) (this.getCurrentMana() + this.getMana() * 0.75)));
			}
			break;
		default: 
			break;
		}
	}

	/**
	 * Funcion de ataque del personaje protagonista, donde se calcula el daño que
	 * realizara con un ataque basico
	 * 
	 * @return Numero de daño que haria el personaje al enemigo antes de aplicar
	 *         modificadores de defensa
	 */
	public int atacar() {
		int danyo = this.getPhysDamage();

		int proc = ((int) Math.random() * 100);

		if (proc < this.getCritChance()) {
			danyo *= 2;
		}

		return danyo;
	}

	/**
	 * Funcion que calcula el daño que recibira el personaje en funcion de un ataque
	 * realizado por un enemigo
	 * 
	 * @param danyo  Numero de daño que realiza el enemigo
	 * @param fisico Tipo de daño de ataque del enemigo, "true" es fisico y "false"
	 *               es magico
	 * @return El daño que recibira el personaje una vez aplicados los parametros
	 *         defensivos del personaje
	 */
	public int recibeDaño(int danyo, boolean fisico) {
		if (fisico) {
			danyo = (int) ((danyo * (1 - (this.getPhysDef() / (100.0 + this.getPhysDef())))));

		} else {
			danyo = (int) ((danyo * (1 - (this.getMagicDef() / (100.0 + this.getMagicDef())))));
		}

		if (this.getCurrentLife() < Math.abs(danyo)) {
			danyo = this.getCurrentLife();
			this.setCurrentLife(0);
		} else {
			this.setCurrentLife(
					(int) (this.getCurrentLife() - (danyo * (1 - (this.getPhysDef() / (100.0 + this.getPhysDef()))))));
		}

		return danyo;
	}

	/**
	 * Funcion de ataque sobrecargada para cuando el personaje utilice una habilidad
	 * para atacar, calculara el daño realizado por la habilidad
	 * 
	 * @param hability La habilidad de ataque que se utilizara
	 * @return Numero de daño que hace el ataque con habilidad antes de aplicar
	 *         modificadores de defensa enemigos
	 */
	public int atacar(Skill hability) {
		int danyo = hability.getDamage();
		if (danyo > 0) {
			if (hability.getDamageType()) {
				danyo += (hability.getDamageMultiplier() * this.getPhysDamage());
			} else {
				danyo += (hability.getDamageMultiplier() * this.getMagicDamage());
			}
		}

		// Calcula si se producira un impacto critico o no
		int proc = (int) (Math.random() * 100);
		if (proc <= this.getCritChance() + hability.getAddCritChance()) {
			danyo *= 2;
		}

		return danyo;

	}

	/**
	 * Funcion para subir de nivel, llamada en caso necesario desde la funcion
	 * {@link #sumarexp(int), sumarexp}
	 */
	private void levelUp() {

		this.setLevel(this.getLevel() + 1);
		this.setTotalLevelExp((int) (getTotalLevelExp() * 1.25));
		this.setCurrentExp(0);

		if (work.equals(ClassType.Archmage)) {
			this.setPhysDamage(this.getPhysDamage() + 1);
			this.setPhysDef(this.getPhysDef() + (int) (Math.random() * 2 + 1));
			this.setMana(this.getMana() + 20);
			this.setMagicDamage(this.getMagicDamage() + (int) (Math.random() * 6 + 4));
			this.setMagicDef(this.getMagicDef() + (int) (int) (Math.random() * 4 + 3));
			this.setHealth(this.getHealth() + (int) (Math.random() * 30 + 20));
		}
		if (work.equals(ClassType.Hunter)) {
			this.setPhysDamage(this.getPhysDamage() + (int) (Math.random() * 6 + 4));
			this.setPhysDef(this.getPhysDef() + (int) (Math.random() * 3 + 2));
			this.setMana(this.getMana() + 15);
			this.setMagicDef(this.getMagicDef() + (int) (int) (Math.random() * 3 + 2));
			this.setHealth(this.getHealth() + (int) (Math.random() * 40 + 30));
		}
		if (work.equals(ClassType.Warlord)) {
			this.setPhysDamage(this.getPhysDamage() + (int) (Math.random() * 4 + 2));
			this.setPhysDef(this.getPhysDef() + (int) (Math.random() * 6 + 4));
			this.setMana(this.getMana() + 10);
			this.setMagicDef(this.getMagicDef() + (int) (Math.random() * 6 + 4));
			this.setHealth(this.getHealth() + (int) (Math.random() * 60 + 40));

		}
		skillchecker();
	}

	/**
	 * Suma una determinada cantidad de experiencia a la experiencia actual del
	 * personaje
	 * 
	 * @param exp La cantidad de experiencia a sumar
	 * @return Booleano que indica si ha subido de nivel o no
	 */
	public boolean sumarexp(int exp) {
		boolean lvlup = this.getCurrentExp() + exp > this.getTotalLevelExp();
		if (lvlup) {
			this.levelUp();
		}
		return lvlup;
	}

	/**
	 * Funcion permite hacer una comparación previa entre una pieza de armadura
	 * recien adquirida y la ya equipada dejando que el jugador elija si quiere
	 * equipar la nueva pieza o mantener la antigua
	 * 
	 * @param equipment El nuevo objeto que se pretender comparar y en ultima
	 *                  instancia, equipar o no
	 */
	public void equipar(Gear equipment) {
		Gear current = new Gear("test");
		for (int i = 0; i < this.getEquipped().size(); i++) {
			if (this.getEquipped().get(i).getPos().equals(equipment.getPos())) {
				current = this.getEquipped().get(i);
			}
		}
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Equipamiento");
		alert.setHeaderText(
				"¿Quieres sustituir tu " + current.getName() + " por el recien obtenido " + equipment.getName()+" ?");
		alert.setContentText("Equipado: " + current.toString() + "\n o \n" + equipment.toString() + "\n ¿Qué decides?");
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get().equals(ButtonType.OK)) {
			cambiaequipo(equipment, false);
		} else {
			cambiaequipo(equipment, true);
		}

	}

	/**
	 * Funcion encargada de equipar una nueva pieza de armadura y eliminar la
	 * antigua
	 * 
	 * @param newequip Nueva pieza de armadura a equipar
	 * @param vender   Indica si la pieza de equipo se equipara(false) o se
	 *                 vendera(true)
	 */
	private void cambiaequipo(Gear newequip, boolean vender) {
		if (!vender) {
			for (int i = 0; i < this.getEquipped().size(); i++) {
				if (this.getEquipped().get(i).getPos().equals(newequip.getPos())) {
					Gear viejo = this.getEquipped().get(i);
					this.getEquipped().add(newequip);

					actualizarStats(viejo, newequip);
					this.getEquipped().remove(i);
				}
			}
		}
	}

	public void comprar(Item it, int cantidad) {

		this.setMoney(this.getMoney()-it.getPrice()*cantidad);
		it.setQuantity(cantidad);
		this.inventory.add(it);

		this.ordenarInventario();

	}

	public void vender(Item it, int cantidad) {

		this.setMoney(this.getMoney() + it.getPrice()/2*cantidad);
		
		for(int i=0; i<this.inventory.size(); i++) {
			if(this.inventory.get(i).getEffect().equals(it.getEffect())) {
				this.inventory.get(i).setQuantity(this.inventory.get(i).getQuantity()-cantidad);
			}	
		}
		
		this.ordenarInventario();

	}
	
	/**
	 * Funcion encargada de actualizar las estadísticas del personaje tras un cambio
	 * de equipamiento, restando las estadisticas de la equipacion antigua y sumando
	 * las nuevas
	 * 
	 * @param oldGear Pieza de armadura que sera desequipada y por tanto se perderan
	 *                sus estadisticas
	 * @param newGear Pieza de armadura que sera equipada y por tanto sus
	 *                estadisticas se añadiran al personaje
	 */
	private void actualizarStats(Gear oldGear, Gear newGear) {
		this.setHealth(this.getHealth() - oldGear.getHealth() + newGear.getHealth());
		this.setMana(this.getMana() - oldGear.getMana() + newGear.getMana());
		this.setLuck(this.getLuck() - oldGear.getLuck() + newGear.getLuck());
		this.setCritChance(this.getCritChance() - oldGear.getCritChance() + newGear.getCritChance());
		this.setPhysDamage(this.getPhysDamage() - oldGear.getPhysDamage() + newGear.getPhysDamage());
		this.setPhysDef(this.getPhysDef() - oldGear.getPhysDef() + newGear.getPhysDef());
		this.setMagicDamage(this.getMagicDamage() - oldGear.getMagicDamage() + newGear.getMagicDamage());
		this.setMagicDef(this.getMagicDef() - oldGear.getMagicDef() + newGear.getMagicDef());
	}

	public void ordenarInventario() {

		ArrayList<Item> objetosPj = new ArrayList<Item>(this.getInventory());
		ObservableList<Item> nuevos = new SimpleListProperty<Item>(this, "nuevos", FXCollections.observableArrayList());
		boolean hay = false;
		int pos = 0;

		for(int i=0; i<objetosPj.size(); i++) {
			if(objetosPj.get(i).getQuantity()==0) {
				objetosPj.remove(i);
			}
		}
		
		for (int i = 0; i < objetosPj.size(); i++) {
			for (int z = 0; z < nuevos.size(); z++) {
				if (objetosPj.get(i).getName().equals(nuevos.get(z).getName())) {
					hay = true;
					pos = z;
					break;
				}
			}

			if (hay) {
				Item obj = nuevos.get(pos);
				obj.setQuantity(obj.getQuantity() + objetosPj.get(i).getQuantity());
			} else {
				nuevos.add(objetosPj.get(i));
			}
			hay = false;
			pos = 0;

		}
		this.setInventory(nuevos);
	}

	// getters-setters

	public final IntegerProperty currentExpProperty() {
		return this.currentExp;
	}

	public final int getCurrentExp() {
		return this.currentExpProperty().get();
	}

	public final void setCurrentExp(final int currentExp) {
		this.currentExpProperty().set(currentExp);
	}

	public final IntegerProperty totalLevelExpProperty() {
		return this.totalLevelExp;
	}

	public final int getTotalLevelExp() {
		return this.totalLevelExpProperty().get();
	}

	public final void setTotalLevelExp(final int totalLevelExp) {
		this.totalLevelExpProperty().set(totalLevelExp);
	}

	public final IntegerProperty moneyProperty() {
		return this.money;
	}

	public final int getMoney() {
		return this.moneyProperty().get();
	}

	public final void setMoney(final int money) {
		this.moneyProperty().set(money);
	}

	public final ListProperty<Item> inventoryProperty() {
		return this.inventory;
	}

	public final ObservableList<Item> getInventory() {
		return this.inventoryProperty().get();
	}

	public final void setInventory(final ObservableList<Item> inventory) {
		this.inventoryProperty().set(inventory);
	}

	public final ListProperty<Gear> equippedProperty() {
		return this.equipped;
	}

	public final ObservableList<Gear> getEquipped() {
		return this.equippedProperty().get();
	}

	public final void setEquipped(final ObservableList<Gear> equipped) {
		this.equippedProperty().set(equipped);
	}

	public final ListProperty<Skill> skillsProperty() {
		return this.skills;
	}

	public final ObservableList<Skill> getSkills() {
		return this.skillsProperty().get();
	}

	public final void setSkills(final ObservableList<Skill> skills) {
		this.skillsProperty().set(skills);
	}

	public final IntegerProperty currentManaProperty() {
		return this.currentMana;
	}

	public final int getCurrentMana() {
		return this.currentManaProperty().get();
	}

	public final void setCurrentMana(final int currentMana) {
		this.currentManaProperty().set(currentMana);
	}

	public final ListProperty<Skill> learnedSkillsProperty() {
		return this.learnedSkills;
	}

	public final ObservableList<Skill> getLearnedSkills() {
		return this.learnedSkillsProperty().get();
	}

	public final void setLearnedSkills(final ObservableList<Skill> learnedSkills) {
		this.learnedSkillsProperty().set(learnedSkills);
	}

	public Avatar getAvatar() {
		return this;
	}

	public final ObjectProperty<Image> combatSpriteProperty() {
		return this.combatSprite;
	}

	public final Image getCombatSprite() {
		return this.combatSpriteProperty().get();
	}

	public final void setCombatSprite(final Image appearance) {
		this.combatSpriteProperty().set(appearance);
	}

	public ClassType getWork() {
		return work;
	}

	public void setWork(ClassType work) {
		this.work = work;
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
