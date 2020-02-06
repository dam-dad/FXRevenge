package fxrevenge.world;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class WorldMAPModel {
	
	private static IntegerProperty width=new SimpleIntegerProperty();
	private static IntegerProperty height=new SimpleIntegerProperty();
	private static DoubleProperty widthCanvas=new SimpleDoubleProperty();
	private static DoubleProperty heightsCanvas=new SimpleDoubleProperty();
	private static DoubleProperty posXScroll=new SimpleDoubleProperty();
	private static DoubleProperty posYScroll=new SimpleDoubleProperty();
	private static DoubleProperty widthImage=new SimpleDoubleProperty();
	private static DoubleProperty heightsImage=new SimpleDoubleProperty();
	
	public WorldMAPModel(int width, int height,int widthCanvas, int heightsCanvas,double widthImage, double heightsImage,double posXScroll, double posYScroll) {
		this.widthCanvas.set(widthCanvas);
		this.heightsCanvas.set(heightsCanvas);
		this.widthImage.set(widthImage);
		this.heightsImage.set(heightsImage);
		this.posXScroll.set(posXScroll);
		this.posYScroll.set(posYScroll);
		this.width.set(width);
		this.height.set(height);
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
	

	public final IntegerProperty heightProperty() {
		return this.height;
	}
	

	public final int getHeight() {
		return this.heightProperty().get();
	}
	

	public final void setHeight(final int height) {
		this.heightProperty().set(height);
	}
	

	public final DoubleProperty widthCanvasProperty() {
		return this.widthCanvas;
	}
	

	public final double getWidthCanvas() {
		return this.widthCanvasProperty().get();
	}
	

	public final void setWidthCanvas(final double widthCanvas) {
		this.widthCanvasProperty().set(widthCanvas);
	}
	

	public final DoubleProperty heightsCanvasProperty() {
		return this.heightsCanvas;
	}
	

	public final double getHeightsCanvas() {
		return this.heightsCanvasProperty().get();
	}
	

	public final void setHeightsCanvas(final double heightsCanvas) {
		this.heightsCanvasProperty().set(heightsCanvas);
	}
	

	public final DoubleProperty posXScrollProperty() {
		return this.posXScroll;
	}
	

	public final double getPosXScroll() {
		return this.posXScrollProperty().get();
	}
	

	public final void setPosXScroll(final double posXScroll) {
		this.posXScrollProperty().set(posXScroll);
	}
	

	public final DoubleProperty posYScrollProperty() {
		return this.posYScroll;
	}
	

	public final double getPosYScroll() {
		return this.posYScrollProperty().get();
	}
	

	public final void setPosYScroll(final double posYScroll) {
		this.posYScrollProperty().set(posYScroll);
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
