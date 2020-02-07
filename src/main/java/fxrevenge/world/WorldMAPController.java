package fxrevenge.world;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import fxrevenge.animations.AnimationMobs;
import fxrevenge.animations.TestMove;
import javafx.beans.Observable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
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
	private Scene scene;

	private String[][] world = {
//			{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16"},
			{ "T1", "T2", "T1", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
			{ ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
			{ ".", ".", ".", ".", ".", "T2", ".", ".", ".", ".", ".", ".", ".", "." },
			{ ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "T1", ".", "." },
			{ ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
			{ ".", "T1", ".", ".", ".", ".", "T2", ".", ".", ".", ".", ".", ".", "." },
			{ ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
			{ ".", ".", ".", ".", ".", ".", ".", ".", ".", "m1", ".", ".", ".", "." },
			{ ".", ".", ".", "T3", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
			{ "T3", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "T2", ".", "." },
			{ "T3", "T3", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "T3" },
			{ ".", ".", ".", ".", ".", ".", ".", "T1", ".", ".", ".", ".", ".", "." }, };
	
	private boolean[][] collision = new boolean[world.length][world[0].length];
	private AnimationMobs skeleton;
	TestMove pj;

	public WorldMAPController() {
		model = new WorldMAPModel(800, 600, 800, 600, 50);
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/WorldSceneView.fxml"));
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
		scene = new Scene(view);
		view.setPrefWidth(model.getWidth());
		view.setPrefHeight(model.getHeigth());
		rectWorldCanvas.setWidth(model.getWidthCanvas());
		rectWorldCanvas.setHeight(model.getHeigthCanvas());
		gc = rectWorldCanvas.getGraphicsContext2D();
		int resto = 1;
		for (int j = 0; j <= model.getHeigthCanvas(); j += model.getCell()) {
			int cell = 0;
			if (resto == 0)
				resto = 1;
			else
				resto = 0;
			for (int i = 0; i <= model.getWidthCanvas(); i += model.getCell()) {

				if ((i / 50) % 2 == resto)
					gc.setFill(Color.BLACK);
				else
					gc.setFill(Color.RED);

				gc.fillRect(i, j, model.getCell(), model.getCell());
				String x = String.valueOf(cell);
				gc.setFill(Color.WHITE);
				gc.fillText(x, i, j);
				cell++;
			}
		}
		paintWorld();
		pj=new TestMove(collision,0,1);
		view.getChildren().add(pj.getPjImage());
		pj.getPjImage().setX(0);
		pj.getPjImage().setY(50); 
		scene.setOnKeyPressed((KeyEvent event) -> pj.move(event));
	}

	public Pane getView() {
		return view;
	}

	public void paintWorld() {
		String url;
		Image image;
		int posX = 0, posY = 0;
		for (int j = 0; j < world.length; j++) {
			posX = 0;
			for (int i = 0; i < world[0].length; i++) {
				switch (world[j][i]) {
				case "T1":
					image = new Image(getClass().getResourceAsStream("/Image/vegetation/Tree1.png"));
					gc.drawImage(image, posX, posY);
					collision[j][i] = false;

					break;
				case "T2":
					image = new Image(getClass().getResourceAsStream("/Image/vegetation/Tree2.png"));
					gc.drawImage(image, posX, posY);
					collision[j][i] = false;
					break;
				case "T3":
					image = new Image(getClass().getResourceAsStream("/Image/vegetation/Tree3.png"));
					gc.drawImage(image, posX, posY);
					collision[j][i] = false;
					break;
				case ".":
					collision[j][i] = true;
					break;
					
				case "m1":
					skeleton=new AnimationMobs("./Image/npc/maga_Evil.png");
					view.getChildren().add(skeleton.getImageMob());
					skeleton.getImageMob().setX(posX);
					skeleton.getImageMob().setY(posY-50); 
//					skeleton.staticAni(1, 4, 56, 0, 56, 84);
					collision[j][i] = false;
					break;
				default:
					break;

				}

				posX += model.getCell();
			}
			posY += model.getCell();
		}
	}
}
