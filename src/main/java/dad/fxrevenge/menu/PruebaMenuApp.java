package dad.fxrevenge.menu;

import dad.fxrevenge.menu.bestiary.BestiaryController;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Sphere;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PruebaMenuApp extends Application {

	private BestiaryController controller;

	@Override
	public void start(Stage primaryStage) throws Exception {

		// Drawing a Circle
		Circle circle = new Circle(300, 135, 100);
		circle.setFill(Color.DARKSLATEBLUE);
		circle.setStroke(Color.BLACK);

		// Drawing Sphere
		Sphere sphere = new Sphere(50);

		// Creating a text
		Text text = new Text("Hello how are you");

		// Setting the font of the text
		text.setFont(Font.font(null, FontWeight.BOLD, 15));

		// Setting the color of the text
		text.setFill(Color.CRIMSON);

		// setting the position of the text
		text.setX(20);
		text.setY(50);

		// Creating a Stackpane
		StackPane stackPane = new StackPane();

		// Setting the margin for the circle
		StackPane.setMargin(circle, new Insets(50, 50, 50, 50));

		// Retrieving the observable list of the Stack Pane
		ObservableList<Node> list = stackPane.getChildren();

		Button boton = new Button("Click");
		boton.setOnAction(e->{
			circle.setVisible(true);
		});
		// Adding all the nodes to tShe pane
		list.addAll(circle, sphere, text, boton);

		circle.setVisible(false);
		// Creating a scene object
		Scene scene = new Scene(stackPane);

		// Setting title to the Stage
		primaryStage.setTitle("Stack Pane Example");

		// Adding scene to the stage
		primaryStage.setScene(scene);

		// Displaying the contents of the stage
		primaryStage.show();
	}

	

	/**
	 * Ejecutamos para que la app aparezca y con ello el combate
	 * 
	 * @param args parametros necesario para el lanzamiento de la app
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
