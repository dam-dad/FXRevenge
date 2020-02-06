package fxrevenge.world;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import fxrevenge.animations.TestMove;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class WorldMAPController extends Pane implements Initializable {

	
	@FXML
    private Pane view;

    @FXML
    private Canvas rectWorldCanvas;

    private WorldMAPModel model;
    private GraphicsContext gc;
    private StageObjectGame[][] itemsWorldMap;
    private Scene scene;
    TestMove pj;
    
	public WorldMAPController() {
		model =new WorldMAPModel(1000,800,2000, 2000,100,100,1000,1000);
		FXMLLoader loader =new FXMLLoader(getClass().getResource("/fxml/WorldSceneView.fxml"));
		loader.setController(this);
		loader.setRoot(this);
		try {
			loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		view.prefHeightProperty().bind(model.heightProperty());
		view.prefWidthProperty().bind(model.widthProperty());
		rectWorldCanvas.widthProperty().bind(model.widthCanvasProperty());
		rectWorldCanvas.heightProperty().bind(model.heightsCanvasProperty());
		gc = rectWorldCanvas.getGraphicsContext2D();
		itemsWorldMap=new StageObjectGame[(int)(model.getHeightsCanvas()/model.getHeightsImage())][(int)(model.getWidthCanvas()/model.getWidthImage())];
		for (int j = 0; j <= model.getHeightsCanvas(); j+=model.getHeightsImage()*2) {
			for (int i = 0; i <= model.getWidthCanvas(); i+= model.getWidthImage() * 2) {
				
				if (j%2==0) {
				gc.setFill(Color.BLACK);
				} else gc.setFill(Color.BLUE);
				gc.fillRect(i, j, model.getWidthImage(),model.getHeightsImage());
				gc.setStroke(Color.GRAY);
				gc.strokeRect(model.getWidthImage(), model.getHeightsImage(), model.getWidthImage(), model.getHeightsImage());
			
				if (i > 0) {
					gc.setFill(Color.RED);
					gc.fillRect(i - model.getWidthImage(), j - model.getHeightsImage(), model.getWidthImage(), model.getHeightsImage());
				}
				
			}
		}
		int tamY=(int)(model.getHeightsCanvas()/model.getHeightsImage());
		int tamX=(int)(model.getWidthCanvas()/model.getWidthImage());
		System.out.println(tamY+"C"+tamX);
		boolean[][] mapColision=new boolean[tamY][tamX];
		for (int i = 0; i <tamY ; i++) {
			for (int j = 0; j <tamX; j++) {
				mapColision[i][j]=(true);
				
			}
		}
		//------------Fin de control de
	}
	
	public Pane getView() {
		return view;
	}
}
