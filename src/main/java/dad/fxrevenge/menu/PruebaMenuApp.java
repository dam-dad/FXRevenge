package dad.fxrevenge.menu;

import dad.fxrevenge.menu.bestiary.BestiaryController;
import dad.fxrevenge.models.Enemy;
import dad.fxrevenge.models.Race;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Dialog;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PopupControl;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class PruebaMenuApp extends Application {

	private BestiaryController controller;
	private BorderPane pane;
	private Button popButton;

	@Override
	public void start(Stage primaryStage) throws Exception {

		 PopupControl popup = new PopupControl();

		EventHandler<ActionEvent> evento = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				 // if (!popup.isShowing()) popup.show(pane.getScene().getWindow());
				 
				  Scene scene2 = new Scene(controller.getView());
				  
				  Stage segundaEscena = new Stage();
				  segundaEscena.setTitle("Pruebita");
				  segundaEscena.setResizable(false);
				  segundaEscena.setScene(scene2);
				  segundaEscena.show();
				  
//				Dialog<Integer> dialog = new Dialog<>();
//				dialog.setTitle("Login Dialog");
//				dialog.setHeaderText("Look, a Custom Login Dialog");
//				dialog.getDialogPane().setContent(controller.getView());
//				
//				dialog.getDialogPane().getButtonTypes().addAll(ButtonType.CANCEL);
//				
//				dialog.showAndWait();

			}
		};
		
		controller = new BestiaryController();

		pane = new BorderPane();

		popButton = new Button("Click me");

		popButton.setOnAction(evento);

		pane.setCenter(popButton);

		
//		  popup.getScene().setRoot(controller.getView()); popup.setAutoHide(true);
		 

		Scene scene = new Scene(pane);

		primaryStage.setTitle("Menu TEST");
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
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
