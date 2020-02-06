package models;

public class Gear extends Attributes {
	private GearPosition pos;

	public Gear(String name) {
		this.setHealth(0);
		this.setPhysDamage(0);
		this.setPhysDef(0);
		this.setMana(0);
		this.setMagicDamage(0);
		this.setMagicDef(0);
		this.setLuck(0);
		this.setCritChance(0);
	}
	
	public Gear(String name, int level) {
		
	}

	public GearPosition getPos() {
		return pos;
	}

	public void setPos(GearPosition pos) {
		this.pos = pos;
	}

	public String toString() {
		return this.getName()+"te otorga las siguientes estadísticas: \nVida: "+this.getHealth()
		+" Mana: "+this.getMana()+" Daño fisico: "+this.getPhysDamage()+" \nDefensa fisica: "+this.getPhysDef()+" Daño magico: "
				+this.getMagicDamage()+" Defensa magica: "+this.getMagicDef()+ " \nProbabilidad de critico: "+this.getCritChance()
				+" Suerte: "+this.getLuck();
	}
}
	