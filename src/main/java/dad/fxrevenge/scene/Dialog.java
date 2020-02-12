package dad.fxrevenge.scene;

import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

public class Dialog {
	
	private Scene scene;
	private GraphicsContext graphicsContext;
	
	public Dialog(Scene scene, GraphicsContext graphicsContext) {
		this.scene = scene;
		this.graphicsContext = graphicsContext;
	}
	
	public void showDialog(String charName, String dialogText) {
    	
		double sceneHeight = scene.getHeight();
		double sceneWidth = scene.getWidth();
		
		double dialogMargin = 15;
		double dialogHeight = sceneHeight / 6;
		double dialogWidth = sceneWidth - (dialogMargin * 2);
    	
		graphicsContext.setTextAlign(TextAlignment.LEFT);
		
    	graphicsContext.setFill(Color.BLACK);
    	graphicsContext.fillRect(dialogMargin, sceneHeight - (dialogHeight + dialogMargin), dialogWidth, dialogHeight);
    	
    	graphicsContext.setFill(Color.WHITE);
    	graphicsContext.fillText(charName, dialogMargin + 5, sceneHeight - (dialogHeight - 5));
    	graphicsContext.fillText(dialogText, dialogMargin + 5, sceneHeight - (dialogHeight - 25));
    	
    }
	
	public Scene getScene() {
		return this.scene;
	}
	
	public void setScene(Scene scene) {
		this.scene = scene;
	}
	
	public GraphicsContext getGraphicsContext() {
		return this.graphicsContext;
	}
	
	public void setGraphicsContext(GraphicsContext graphicsContext) {
		this.graphicsContext = graphicsContext;
	}

}
