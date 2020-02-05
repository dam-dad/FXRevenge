package Models;

import java.util.List;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

//constructor
public class Avatar extends Attributes {

	IntegerProperty currentExp = new SimpleIntegerProperty();
	IntegerProperty totalLevelExp = new SimpleIntegerProperty();
	IntegerProperty money = new SimpleIntegerProperty();
	Image appearance;
	ClassType work;
	ListProperty<Item> inventory = new SimpleListProperty<Item>();
	ListProperty<Gear> equipped = new SimpleListProperty<Gear>(this, "equipped", FXCollections.observableArrayList());
	ListProperty<Skill> skills = new SimpleListProperty<Skill>(this, "skills", FXCollections.observableArrayList());
	ListProperty<Skill> learnedSkills = new SimpleListProperty<Skill>(this, "learnedSkills",
			FXCollections.observableArrayList());
	IntegerProperty currentMana = new SimpleIntegerProperty();

	public Avatar() {
		// construir pj con stat base seteadas dependiendo de la clase

	}

	public Avatar(Image appearance, ClassType work, List<Skill> skills, String name) {

		this.work = work;
		this.setCurrentExp(0);
		this.setMoney(0);
		this.setName(name);
		this.setLevel(1);
		this.setLuck(0);
		this.setTotalLevelExp(150);
		this.appearance = appearance;
		this.setCritChance(0);

		if (work.equals(ClassType.Archmage)) {

			this.setSkills(FXCollections.observableArrayList(skills));
			this.setCurrentMana(30);

			this.setHealth(20);
			this.setPhysDamage(2);
			this.setPhysDef(5);
			this.setMana(20);
			this.setMagicDamage(9);
			this.setMagicDef(7);

		} else if (work.equals(ClassType.Hunter)) {

			this.setSkills(FXCollections.observableArrayList(skills));
			this.setCurrentMana(23);

			this.setHealth(25);
			this.setPhysDamage(8);
			this.setPhysDef(5);
			this.setMana(15);
			this.setMagicDamage(0);
			this.setMagicDef(3);

		} else if (work.equals(ClassType.Warlord)) {

			this.setSkills(FXCollections.observableArrayList(skills));
			this.setCurrentMana(15);

			this.setHealth(30);
			this.setPhysDamage(5);
			this.setPhysDef(10);
			this.setMana(10);
			this.setMagicDamage(0);
			this.setMagicDef(10);

		}

		this.setCurrentLife(this.getHealth());
		
	}

	public int atacar() {
		int danyo = this.getPhysDamage();

		int proc = ((int) Math.random() * 100);

		if (proc < this.getCritChance()) {
			danyo *= 2;
		}

		return danyo;
	}

	public void recibeDaño(int danyo, boolean fisico) {
		if (fisico)
			this.currentLife.set(this.getCurrentLife() - (danyo - this.getPhysDef()));
		else
			this.currentLife.set(this.getCurrentLife() - (danyo - this.getMagicDef()));
	}

	public int atacar(Skill hability) {
		int danyo = hability.getDamage();

		this.setCurrentMana(this.getCurrentMana() - hability.getCost());

		if (danyo > 0) {
			if (hability.getDamageType()) {
				danyo += (hability.getDamageMultiplier() * this.getPhysDamage());
			} else {
				danyo += (hability.getDamageMultiplier() * this.getMagicDamage());
			}

		} else {
			if ((this.getCurrentLife() - danyo) > this.getHealth())
				this.currentLife.set(this.getHealth());
			else
				this.currentLife.set(this.getCurrentLife() - danyo);

		}

		return danyo;

	}

	public void levelUp() {

		this.setLevel(this.getLevel() + 1);
		this.setTotalLevelExp((int)(getTotalLevelExp()*1.25));
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
	}

	public boolean sumarexp(int exp) {
		boolean lvlup = this.getCurrentExp() + exp > this.getTotalLevelExp();
		if (lvlup) {
			this.levelUp();
		}
		return lvlup;
	}

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

	public Image getAppearance() {
		return appearance;
	}

	public void setAppearance(Image appearance) {
		this.appearance = appearance;
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
}
