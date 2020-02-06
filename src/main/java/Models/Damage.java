package Models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
//sin uso de momento
public class Damage {
	private IntegerProperty danyo = new SimpleIntegerProperty();
	private DamageType type;
	
	
	public final IntegerProperty danyoProperty() {
		return this.danyo;
	}
	
	public final int getDanyo() {
		return this.danyoProperty().get();
	}
	
	public final void setDanyo(final int danyo) {
		this.danyoProperty().set(danyo);
	}

	public DamageType getType() {
		return type;
	}

	public void setType(DamageType type) {
		this.type = type;
	}
	
}
