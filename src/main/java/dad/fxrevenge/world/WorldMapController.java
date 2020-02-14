package dad.fxrevenge.world;

import java.io.IOException;

import dad.fxrevenge.animations.AnimationMobs;
import dad.fxrevenge.animations.TestMove;
import dad.fxrevenge.scene.GameScene;
import dad.fxrevenge.scene.Parameters;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class WorldMapController extends Pane implements GameScene, Parameters {

	@FXML
	private Pane view;

	@FXML
	private Canvas rectWorldCanvas;

	private WorldMapModel model;
	private GraphicsContext gc;
	private Scene scene;

	private String[][] world = {
//			{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16"},
			{ "T1", "T2", "T1", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
			{ ".", "P", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
			{ ".", ".", ".", ".", ".", "T2", ".", ".", ".", ".", ".", ".", ".", ".", "." },
			{ ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "T1", ".", ".", "." },
			{ ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
			{ ".", "T1", ".", ".", ".", ".", "T2", ".", ".", ".", ".", ".", ".", ".", "T1" },
			{ ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "T1" },
			{ ".", ".", ".", ".", ".", ".", ".", ".", ".", "M", ".", ".", ".", ".", "." },
			{ ".", ".", ".", "T3", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "." },
			{ "T3", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "T2", ".", ".", "." },
			{ "T3", "T3", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "T3", "." },
			{ ".", ".", ".", ".", ".", ".", ".", "T1", ".", ".", ".", ".", ".", ".", "." } };

	private AnimationMobs skeleton;
	TestMove pj;

	public WorldMapController() {
		model = new WorldMapModel(GAME_RESOLUTION_WIDTH, GAME_RESOLUTION_HEIGHT, MAP_CELL_SIZE);
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
	public void start() {
		scene = new Scene(view, model.getWidth(), model.getHeigth());

		rectWorldCanvas.setWidth(model.getWidth());
		rectWorldCanvas.setHeight(model.getHeigth());
		gc = rectWorldCanvas.getGraphicsContext2D();
		int resto = 1;
		int cellX = 0, cellY = 0;
		for (int j = 0; j <= world.length; j++) {
			int cell = 0;
			if (resto == 0)
				resto = 1;
			else
				resto = 0;
			for (int i = 0; i <= world[0].length; i++) {

				if (i % 2 == resto)
					gc.setFill(Color.BLACK);
				else
					gc.setFill(Color.RED);

				gc.fillRect(cellX, cellY, model.getCell(), model.getCell());
				String x = String.valueOf(cell);
				gc.setFill(Color.WHITE);
				gc.fillText(x, cellX, cellY);
				cell++;
				cellX = cellX + model.getCell();
			}
			cellY = cellY + model.getCell();
			cellX = 0;
		}

		pj = new TestMove(world, model.getCell(), 900, new Image("/Image/characters/mage_f.png"), 0, 0, 32, 39,
				Orientation.EAST);
		view.getChildren().add(pj.getPjImage());
		paintWorld();
		scene.setOnKeyPressed((KeyEvent event) -> pj.move(event));
	}

	public Pane getView() {
		return view;
	}

	public void paintWorld() {
		// String url;
		Image image;
		int posX = 0, posY = 0;
		for (int j = 0; j < world.length; j++) {
			posX = 0;
			for (int i = 0; i < world[0].length; i++) {
				switch (world[j][i]) {
				case "T1":
					image = new Image(getClass().getResourceAsStream("/Image/vegetation/Tree1.png"));
					gc.drawImage(image, posX, posY);

					break;
				case "T2":
					image = new Image(getClass().getResourceAsStream("/Image/vegetation/Tree2.png"));
					gc.drawImage(image, posX, posY);
					break;
				case "T3":
					image = new Image(getClass().getResourceAsStream("/Image/vegetation/Tree3.png"));
					gc.drawImage(image, posX, posY);
					break;
				case "M":
					skeleton = new AnimationMobs("./Image/npc/maga_Evil.png");
					view.getChildren().add(skeleton.getImageMob());
					skeleton.getImageMob().setX(posX);
					skeleton.getImageMob().setY(posY - 50);
//					skeleton.staticAni(1, 4, 56, 0, 56, 84);
					break;
				case "P":

					pj.getPjImage().setX(i * model.getCell());
					pj.getPjImage().setY(j * model.getCell());
					System.out.println(pj.getPjImage().getX());
					System.out.println(pj.getPjImage().getY());
				default:
					break;

				}

				posX += model.getCell();
			}
			posY += model.getCell();
		}
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}
	
}
