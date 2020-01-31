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
		model =new WorldMAPModel(1000, 800,100,100);
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
		scene=new Scene(view);
		view.setPrefWidth(1000);
		view.setPrefHeight(800);
		
		//----- Control de casillas Visual
		rectWorldCanvas.setWidth(model.getWidthCanvas()+0.00);
		rectWorldCanvas.setHeight(model.getHeightsCanvas());
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
		//------------Fin de control de casillas-----------
		
		for (int j = 0; j < tamY; j+=1) {
			StageObjectGame objectInMap=new StageObjectGame("/Image/vegetation/baumTree.png", false);
			itemsWorldMap[j][0]=objectInMap;
			double difference=12;
			itemsWorldMap[j][0].getImage().setY((model.getHeightsImage()*j)-difference);
			itemsWorldMap[j][0].getImage().setX(-5);
			mapColision[j][0]=false;
			view.getChildren().add(itemsWorldMap[j][0].getImage());
		}
		int pos=(int)(model.getWidthCanvas()/model.getWidthImage())-1;
		for (int j = 0; j <tamY; j+=1) {
			StageObjectGame objectInMap=new StageObjectGame("/Image/vegetation/baumTree.png", false);
			itemsWorldMap[j][pos]=objectInMap;
			double difference=12;
			itemsWorldMap[j][pos].getImage().setY((model.getHeightsImage()*j)-difference);
			itemsWorldMap[j][pos].getImage().setX(900.0);
			mapColision[j][pos]=false;
			view.getChildren().add(itemsWorldMap[j][pos].getImage());
		}
		pj=new TestMove(mapColision,1,0);
		view.getChildren().add(pj.getPjImage());
		pj.getPjImage().setX(100);
		pj.getPjImage().setY(0); 
		scene.setOnKeyPressed((KeyEvent event) -> pj.move(event));
		System.out.println(scene.getWidth() +" "+scene.getHeight());
	    }
	
	public Pane getView() {
		return view;
	}
}
