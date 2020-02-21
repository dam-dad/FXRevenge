package dad.fxrevenge.models;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Gear extends Attributes {
	private GearPosition pos;
	private IntegerProperty price = new SimpleIntegerProperty();
	//añadir una funcion que genere item aleatorio
	
	/**
	 * Constructor base de un equipo que setea todos su parametros a cero y solo
	 * añade un nombre al equipo
	 * 
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
		this.setPrice(0);
	}

	/**
	 * Constructor base sobrecargado, en el cual se puede indicar ademas de el
	 * nombre, la posicion del equipo
	 * 
	 * @param name Nombre del objeto
	 * @param pos  Posicion en la que irá el objeto, obtenida del enumerado
	 *             GearPosition
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
		this.setPrice(0);
	}

	/**
	 * Constructor sobrecargado que ademas de indicar nombre y posicion también se
	 * le puede indicar un nivel para que genere objetos acorde a un determinado
	 * nivel del personaje
	 * 
	 * @param name  Nombre del objeto
	 * @param level Modificador que aumenta la calidad del objeto asi como sus
	 *              estadisticas
	 * @param pos   Posicion del equipamiento que ocupa
	 */
	public Gear(String name, int level, GearPosition pos) {
		this.setName(name);
		this.setPos(pos);
		this.setLevel(level);
		this.setHealth((int) (Math.random() * level * 10));
		this.setMana((int) (Math.random() * level * 6));
		this.setPhysDamage((int) (Math.random() * level));
		this.setPhysDef((int) (Math.random() * level));
		this.setMagicDamage((int) (Math.random() * level));
		this.setMagicDef((int) (Math.random() * level));
		this.setLuck((int) (Math.random() * level));
		this.setCritChance((int) (Math.random() * 6));
		this.setPrice(level*15);
	}
	/**
	 * Funcion para generar nombres semi-aleatorios de equipamiento
	 * @param pos Posicion de la pieza a la que se quiere generar el nombre
	 * @param job Clase para la que se va a generar la pieza
	 * @return Nombre de la pieza de equipamiento
	 */
	public String generateGearName(GearPosition pos, ClassType job) {
		StringBuilder str = new StringBuilder();

		ArrayList<String> casco = new ArrayList<String>();
		casco.add("Casco");
		casco.add("Yelmo");
		casco.add("Sombrero");
		casco.add("Tiara");
		ArrayList<String> pechera = new ArrayList<String>();
		pechera.add("Pechera");
		pechera.add("Toga");
		pechera.add("Armadura");
		ArrayList<String> guantes = new ArrayList<String>();
		guantes.add("Guantes");
		guantes.add("Guanteletes");
		guantes.add("Brazales");
		ArrayList<String> pantalones = new ArrayList<String>();
		pantalones.add("Pantalones");
		pantalones.add("Perneras");
		pantalones.add("Musleras");
		ArrayList<String> botas = new ArrayList<String>();
		botas.add("Botines");
		botas.add("Botas");
		botas.add("Calzado");
		
		ArrayList<String> suffix = new ArrayList<String>();
		suffix.add("del Guardian");
		suffix.add("del Destructor");
		suffix.add("del Vigilante");
		suffix.add("del Acechador");
		suffix.add("del Abrecaminos");
		suffix.add("del Rompemundos");
		suffix.add("del Archimago");
		suffix.add("del Protector");
		suffix.add("del Infernal");
		suffix.add("del Celestial");
		suffix.add("del Caido");
		suffix.add("del Traidor");
		suffix.add("del Maldito");
		int auxFirst = (int) (Math.random() * 4);
		int auxSec = (int) (Math.random() * 14);
		switch (pos) {
		case Helmet:
			str.append(casco.get(auxFirst));
			break;
		case Chest:
			str.append(pechera.get(auxFirst));
			break;
		case Gloves:
			str.append(guantes.get(auxFirst));
			break;
		case Leggings:
			str.append(pantalones.get(auxFirst));
			break;
		case Boots:
			str.append(botas.get(auxFirst));
			break;
		case LeftHand:
			switch (job) {
			case Archmage:
				str.append("Varita");
				break;
			case Warlord:
				str.append("Escudo");
				break;
			case Hunter:
				str.append("Daga");
				break;
			default:
				break;
			}
			break;
		case RightHand:
			switch (job) {
			case Archmage:
				str.append("Baston");
				break;
			case Warlord:
				str.append("Espada");
				break;
			case Hunter:
				str.append("Gran arco");
				break;
			default:
				break;
			}
			break;
		default:
			break;
		}
		str.append(suffix.get(auxSec));
		return str.toString();
	}
	

	// getters - setters

	public GearPosition getPos() {
		return pos;
	}

	public void setPos(GearPosition pos) {
		this.pos = pos;
	}

	public final IntegerProperty priceProperty() {
		return this.price;
	}
	

	public final int getPrice() {
		return this.priceProperty().get();
	}
	

	public final void setPrice(final int price) {
		this.priceProperty().set(price);
	}
	
	/**
	 * Funcion que da formato de texto a un objeto de equipamiento, informando de
	 * todas sus estadisticas y atributos
	 */
	public String toString() {
		return this.getName() + "te otorga las siguientes estadísticas: \nVida: " + this.getHealth() + " Mana: "
				+ this.getMana() + " Daño fisico: " + this.getPhysDamage() + " \nDefensa fisica: " + this.getPhysDef()
				+ " Daño magico: " + this.getMagicDamage() + " Defensa magica: " + this.getMagicDef()
				+ " \nProbabilidad de critico: " + this.getCritChance() + " Suerte: " + this.getLuck();
	}
}
