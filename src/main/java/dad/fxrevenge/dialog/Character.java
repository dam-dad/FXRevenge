package dad.fxrevenge.dialog;

import javafx.scene.image.Image;

public class Character {

	private String name;
	private Image portrait;

	public Character(String name, Image portrait) {
		this.name = name;
		this.portrait = portrait;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Image getPortrait() {
		return portrait;
	}

	public void setPortrait(Image portrait) {
		this.portrait = portrait;
	}

}
