package dad.fxrevenge.dialog;

import javafx.scene.image.Image;

public class Character {
	
	private String name;
	private Image portrait;
	private Boolean isLeft;
	
	public Character(String name, Image portrait, Boolean isLeft) {
		this.name = name;
		this.portrait = portrait;
		this.isLeft = isLeft;
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

	public Boolean getIsLeft() {
		return isLeft;
	}

	public void setIsLeft(Boolean isLeft) {
		this.isLeft = isLeft;
	}
	
}
