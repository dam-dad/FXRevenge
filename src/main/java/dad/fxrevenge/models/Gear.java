package dad.fxrevenge.models;

public class Gear extends Attributes {
	private GearPosition pos;
	/**
	 * Constructor base de un equipo que setea todos su parametros a cero y solo añade un nombre al equipo
	 * @param name Nombre de la pieza de equipamiento
	 */
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
	/**
	 * Constructor base sobrecargado, en el cual se puede indicar ademas de el nombre, la posicion del equipo
	 * @param name Nombre del objeto
	 * @param pos Posicion en la que irá el objeto, obtenida del enumerado GearPosition
	 */
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
	/**
	 * Constructor sobrecargado que ademas de indicar nombre y posicion también se le puede indicar un nivel para que 
	 * genere objetos acorde a un determinado nivel del personaje
	 * @param name Nombre del objeto
	 * @param level Modificador que aumenta la calidad del objeto asi como sus estadisticas
	 * @param pos Posicion del equipamiento que ocupa
	 */
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
	
	//getters - setters
	
	public GearPosition getPos() {
		return pos;
	}

	public void setPos(GearPosition pos) {
		this.pos = pos;
	}
	/**
	 * Funcion que da formato de texto a un objeto de equipamiento, informando de todas sus estadisticas y atributos
	 */
	public String toString() {
		return this.getName() + "te otorga las siguientes estadísticas: \nVida: " + this.getHealth() + " Mana: "
				+ this.getMana() + " Daño fisico: " + this.getPhysDamage() + " \nDefensa fisica: " + this.getPhysDef()
				+ " Daño magico: " + this.getMagicDamage() + " Defensa magica: " + this.getMagicDef()
				+ " \nProbabilidad de critico: " + this.getCritChance() + " Suerte: " + this.getLuck();
	}
}
