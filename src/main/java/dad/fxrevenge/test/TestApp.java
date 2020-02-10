package dad.fxrevenge.test;

import dad.fxrevenge.dialog.screen.IntroductionDialog;
import dad.fxrevenge.dialog.screen.VDialog;
import dad.fxrevenge.dialog.screen.CDialog;
import dad.fxrevenge.dialog.screen.FXDialog;
import dad.fxrevenge.dialog.screen.MDialog;
import dad.fxrevenge.screen.title.TitleScreen;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

public class TestApp extends Application {
	
	private Group root;
	private Canvas canvas;
	private GraphicsContext graphicsContext;
	
	private TitleScreen titleScreen;
	private IntroductionDialog introDialog;
	private MDialog mDialog;
	private VDialog vDialog;
	private CDialog cDialog;
	private FXDialog fxDialog;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.setWidth(800);
		primaryStage.setHeight(600);
		
		
		// Inicializar la pantalla / escena a probar
		//titleScreen = new TitleScreen(primaryStage, canvas, graphicsContext);
		//titleScreen.load();
		
		//introDialog = new PrologueDialog(primaryStage, canvas, graphicsContext);
		//introDialog.load();
		
		//mDialog = new MDialog(primaryStage, canvas, graphicsContext);
		//mDialog.load();
		
		vDialog = new VDialog();
		vDialog.load();
		
		//cDialog = new CDialog(primaryStage, canvas, graphicsContext);
		//cDialog.load();
		
		//fxDialog = new FXDialog(primaryStage, canvas, graphicsContext);
		//fxDialog.load();
		
		primaryStage.setTitle("FX Revenge");
		
		// Colocar aquí la escena a iniciar
		primaryStage.setScene(vDialog.getScene());
		
		primaryStage.setResizable(false);
		primaryStage.show();

	}

}
