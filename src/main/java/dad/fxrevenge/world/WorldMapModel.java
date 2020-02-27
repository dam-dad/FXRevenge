package dad.fxrevenge.world;

import java.util.ArrayList;
import java.util.Arrays;

import dad.fxrevenge.models.Avatar;
import dad.fxrevenge.models.Race;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class WorldMapModel {

	private IntegerProperty cell = new SimpleIntegerProperty();
	private IntegerProperty width = new SimpleIntegerProperty();
	private IntegerProperty heigth = new SimpleIntegerProperty();
	private IntegerProperty widthCanvas = new SimpleIntegerProperty();
	private IntegerProperty heigthCanvas = new SimpleIntegerProperty();
	private IntegerProperty maxLevel = new SimpleIntegerProperty();
	private IntegerProperty minLevel = new SimpleIntegerProperty();
	private ArrayList<Race> races=new ArrayList<Race>();
	private Avatar avatar;

	public WorldMapModel(int width, int heigth, int cell, Avatar avatar) {
		this.avatar=avatar;
		this.cell.set(cell);
		this.width.set(width);
		this.heigth.set(heigth);
		races.addAll(Arrays.asList(Race.Jelly,Race.Skeleton,Race.Orc,Race.Zombie,Race.Demon));
		System.out.println(races.size());
		// this.widthCanvas.set(widthCanvas);
		// this.heigthCanvas.set(heigthCanvas);
	}

	public final IntegerProperty cellProperty() {
		return this.cell;
	}

	public final int getCell() {
		return this.cellProperty().get();
	}

	public final void setCell(final int cell) {
		this.cellProperty().set(cell);
	}

	public final IntegerProperty widthProperty() {
		return this.width;
	}

	public final int getWidth() {
		return this.widthProperty().get();
	}

	public final void setWidth(final int width) {
		this.widthProperty().set(width);
	}

	public final IntegerProperty heigthProperty() {
		return this.heigth;
	}

	public final int getHeigth() {
		return this.heigthProperty().get();
	}

	public final void setHeigth(final int heigth) {
		this.heigthProperty().set(heigth);
	}

	public final IntegerProperty widthCanvasProperty() {
		return this.widthCanvas;
	}

	public final int getWidthCanvas() {
		return this.widthCanvasProperty().get();
	}

	public final void setWidthCanvas(final int widthCanvas) {
		this.widthCanvasProperty().set(widthCanvas);
	}

	public final IntegerProperty heigthCanvasProperty() {
		return this.heigthCanvas;
	}

	public final int getHeigthCanvas() {
		return this.heigthCanvasProperty().get();
	}

	public final void setHeigthCanvas(final int heigthCanvas) {
		this.heigthCanvasProperty().set(heigthCanvas);
	}

	public Avatar getAvatar() {
		return avatar;
	}

	public void setAvatar(Avatar avatar) {
		this.avatar = avatar;
	}

}
