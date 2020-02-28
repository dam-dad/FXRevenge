package dad.fxrevenge.charselect;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class charselectapp extends Application{
	private CharSelectControl charcont;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		charcont = new CharSelectControl();
		
		Scene scene = new Scene(charcont.getView(), 800, 600);
		primaryStage.setScene(scene);
		primaryStage.setTitle("charselecttest");
		primaryStage.setResizable(false);
		primaryStage.show();

	}

}
