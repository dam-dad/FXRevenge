package dad.fxrevenge.models;

public class Gear extends Attributes {
	private GearPosition pos;
	
	public Gear(String name) {
		this.setName(name);
		this.setHealth(0);
		this.setPhysDamage(0);
		this.setPhysDef(0);
		this.setMana(0);
		this.setMagicDamage(0);
		this.setMagicDef(0);
		this.setLuck(0);
		this.setCritChance(0);
	}
	
	public Gear(String name, GearPosition pos) {
		this.setName(name);
		this.setPos(pos);
		this.setHealth(0);
		this.setPhysDamage(0);
		this.setPhysDef(0);
		this.setMana(0);
		this.setMagicDamage(0);
		this.setMagicDef(0);
		this.setLuck(0);
		this.setCritChance(0);
	}

	public Gear(String name, int level, GearPosition pos) {
		this.setName(name);
		this.setPos(pos);
		this.setHealth((int)(Math.random() * level *10));
		this.setMana((int)(Math.random() * level *6));
		this.setPhysDamage((int)(Math.random() * level));
		this.setPhysDef((int)(Math.random() * level));
		this.setMagicDamage((int)(Math.random() * level));
		this.setMagicDef((int)(Math.random() * level));
		this.setLuck((int)(Math.random() * level));
		this.setCritChance((int)(Math.random() * 6));
	}

	public GearPosition getPos() {
		return pos;
	}

	public void setPos(GearPosition pos) {
		this.pos = pos;
	}

	public String toString() {
		return this.getName() + "te otorga las siguientes estadísticas: \nVida: " + this.getHealth() + " Mana: "
				+ this.getMana() + " Daño fisico: " + this.getPhysDamage() + " \nDefensa fisica: " + this.getPhysDef()
				+ " Daño magico: " + this.getMagicDamage() + " Defensa magica: " + this.getMagicDef()
				+ " \nProbabilidad de critico: " + this.getCritChance() + " Suerte: " + this.getLuck();
	}
}
