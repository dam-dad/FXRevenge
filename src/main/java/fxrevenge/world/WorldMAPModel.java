package fxrevenge.world;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class WorldMAPModel {
	
	private static IntegerProperty widthCanvas=new SimpleIntegerProperty();
	private static IntegerProperty heightsCanvas=new SimpleIntegerProperty();
	private static DoubleProperty widthImage=new SimpleDoubleProperty();
	private static DoubleProperty heightsImage=new SimpleDoubleProperty();
	public WorldMAPModel(int widthCanvas, int heightsCanvas,double widthImage, double heightsImage) {
		this.widthCanvas.set(widthCanvas);
		this.heightsCanvas.set(heightsCanvas);
		this.widthImage.set(widthImage);
		this.heightsImage.set(heightsImage);
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
	
	public final IntegerProperty heightsCanvasProperty() {
		return this.heightsCanvas;
	}
	
	public final int getHeightsCanvas() {
		return this.heightsCanvasProperty().get();
	}
	
	public final void setHeightsCanvas(final int heightsCanvas) {
		this.heightsCanvasProperty().set(heightsCanvas);
	}
	
	public final DoubleProperty widthImageProperty() {
		return this.widthImage;
	}
	
	public final double getWidthImage() {
		return this.widthImageProperty().get();
	}
	
	public final void setWidthImage(final double widthImage) {
		this.widthImageProperty().set(widthImage);
	}
	
	public final DoubleProperty heightsImageProperty() {
		return this.heightsImage;
	}
	
	public final double getHeightsImage() {
		return this.heightsImageProperty().get();
	}
	
	public final void setHeightsImage(final double heightsImage) {
		this.heightsImageProperty().set(heightsImage);
	}
	

	
}
