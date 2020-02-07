package dad.fxrevenge.test;

import dad.fxrevenge.dialog.screen.PrologueDialog;
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
	private PrologueDialog introDialog;
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
		
		root = new Group();
		canvas = new Canvas(primaryStage.getWidth(), primaryStage.getHeight());
		root.getChildren().add(canvas);
		
		graphicsContext = canvas.getGraphicsContext2D();
		
		// Inicializar la pantalla / escena a probar
		//titleScreen = new TitleScreen(primaryStage, canvas, graphicsContext);
		//titleScreen.start();
		
		//introDialog = new PrologueDialog(primaryStage, canvas, graphicsContext);
		//introDialog.start();
		
		mDialog = new MDialog(primaryStage, canvas, graphicsContext);
		mDialog.start();
		
		//vDialog = new VDialog(primaryStage, canvas, graphicsContext);
		//vDialog.start();
		
		//cDialog = new CDialog(primaryStage, canvas, graphicsContext);
		//cDialog.start();
		
		//fxDialog = new FXDialog(primaryStage, canvas, graphicsContext);
		//fxDialog.start();
		
		primaryStage.setTitle("FX Revenge");
		
		// Colocar aquí la escena a iniciar
		primaryStage.setScene(mDialog.getScene());
		
		primaryStage.setResizable(false);
		primaryStage.show();

	}

}
