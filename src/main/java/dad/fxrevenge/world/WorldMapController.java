package dad.fxrevenge.world;

import java.io.IOException;
import java.util.Arrays;

import dad.fxrevenge.animations.AnimationMobs;
import dad.fxrevenge.animations.PlayerMove;
import dad.fxrevenge.combat.SimpleCombat;
import dad.fxrevenge.models.Enemy;
import dad.fxrevenge.models.Race;
import dad.fxrevenge.parameters.Parameters;
import dad.fxrevenge.scene.GameScene;
import dad.fxrevenge.scene.SceneManager;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

/**
 * Clase <code>WorldMapController</code>.
 * 
 * @implNote Esta clase se instancias todas las entidades del juego y se dibujan
 *           los mapas de formato de Sttrings.
 */
public class WorldMapController implements GameScene {

	// MODEL

	private WorldMapModel model = new WorldMapModel(Parameters.getResolutionWidth(), Parameters.getResolutionHeight(),
			Parameters.getMapCellSize());

	// VIEW

	private Group view;

	private Scene scene;

	private Canvas rectWorldCanvas;
	private GraphicsContext gc;

	private Image background;

	private AnimationMobs skeleton;
	PlayerMove pj;

	private String[][] world;

	private boolean safeZone;

	/**
	 * Cosntructor <code>WorldMapController</code> para developer.
	 * 
	 * @param map        de coliciones y entidades del nivel actual.
	 * @param backgorund Imagen de fondo a establecer en el mapa.
	 */
	public WorldMapController(String[][] map, Image background, Boolean safeZone) {
		this.world = map;
		this.background = background;
		this.safeZone = safeZone;
	}

	/**
	 * Función <code>start</code> para developer.
	 * 
	 * @implNote Pinta todas las celdas y indica el número de columnas que hay para
	 *           poder identificar de forma fácil las celdas. Si tiene imagen de
	 *           fondo esta sobrescribe las celddas;
	 */
	@Override
	public void start() {

		// Creamos el canvas y su graphics context asociado
		rectWorldCanvas = new Canvas(model.getWidth(), model.getHeigth());
		gc = rectWorldCanvas.getGraphicsContext2D();

		// Inicializamos el nodo que contendrá la vista, su escena y añadimos el canvas
		view = new Group();
		scene = new Scene(view, model.getWidth(), model.getHeigth());
		view.getChildren().add(rectWorldCanvas);

		// Pasamos las razas al modelo
		model.getRaces().addAll(Arrays.asList(Race.Jelly, Race.Skeleton, Race.Orc, Race.Zombie, Race.Demon));
		// Pintamos las celdas del mapa
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
		// Iniciamos el jugador.
		// Definimos los parametros de salto entre movimientos.
		int[][] diferenceImage = { { 0, 0 }, { 0, 36 }, { 0, 108 }, { 0, 72 } };
		pj = new PlayerMove(world, model.getCell(), 900, 32, 38, Orientation.EAST, 3, 3, diferenceImage);
		view.getChildren().add(pj.getPjImage());
		paintWorld();
		scene.setOnKeyPressed((KeyEvent event) -> update(event));
	}

	/**
	 * Función <code>update</code>.
	 * 
	 * @implNote se llama cuando el escuchador lee entradas por teclado. LLamando a
	 *           pj.move y enemy random si se ha movido el personaje.
	 */
	private void update(KeyEvent event) {

		System.out.println(safeZone);

		pj.move(event);
		if (pj.isNewPos() == true)
			enemyRandom();
	}

	/**
	 * Función <code>enemyRandom</code>.
	 * 
	 * @param min nivel minimo que se superarán los enemigos una vez sumado el el
	 *            nivel del personaje
	 * @param max nivel maximo que se no superarán los enemigos una vez sumado el el
	 *            nivel del personaje
	 * @implNote Encargada de crear enemigos aleatorios entre todas las razas
	 *           disponibles y partiendo de un nivel aleatorios entre los
	 *           paramnetros enviados y el nivel del personaje.
	 */
	private void enemyRandom() {
		if ((int) (Math.floor(Math.random() * 10)) <= 0.1) {
			int minLevel = model.getAvatar().getLevel() + 1;
			int maxLevel = model.getAvatar().getLevel() + 1;
			int randomRace = (int) (Math.floor(Math.random() * model.getRaces().size()));
			int randomLevel = (int) (Math.floor(Math.random() * (maxLevel - minLevel + 1) + minLevel));
			try {

				if (!safeZone) {
					SceneManager.changeScene(
							new SimpleCombat(new Enemy(model.getRaces().get(randomRace), randomLevel), auxWorld()));
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	/**
	 * Función <code>paintWorld</code>.
	 * 
	 * @implNote Recorre el mapa y instancia los objetos que pueden ser animimados.
	 *           En casos de que sea un entidad no sea animada Pintará
	 *           respectivamente las imagenes.
	 */
	public void paintWorld() {
		Image image;
		int posX = 0, posY = 0;

		// Dibujar el fondo
		gc.drawImage(background, 0, 0, rectWorldCanvas.getWidth(), rectWorldCanvas.getHeight());

		for (int j = 0; j < world.length; j++) {

			posX = 0;

			for (int i = 0; i < world[0].length; i++) {

				switch (world[j][i]) {
				case "T1":
					image = new Image(getClass().getResourceAsStream("/image/assets/tree_1.png"));
					gc.drawImage(image, posX, posY);

					break;
				case "T2":
					image = new Image(getClass().getResourceAsStream("/image/assets/tree_2.png"));
					gc.drawImage(image, posX, posY);

					break;
				case "T3":
					image = new Image(getClass().getResourceAsStream("/image/assets/tree_3.png"));
					gc.drawImage(image, posX, posY);

					break;

				case "R1":
					image = new Image(getClass().getResourceAsStream("/image/assets/rock_1.png"));
					gc.drawImage(image, posX, posY);
					break;
					
				case "R2":
					image = new Image(getClass().getResourceAsStream("/image/assets/rock_2.png"));
					gc.drawImage(image, posX, posY);
					break;

				case "M":
					skeleton = new AnimationMobs("./Image/npc/maga_Evil.png", 0, 0, 56, 84);
					view.getChildren().add(skeleton.getImageMob());
					skeleton.getImageMob().setX(posX);
					skeleton.getImageMob().setY(posY - 50);
//					skeleton.staticAni(1, 4, 56, 0, 56, 84);

					break;

				case "V":
					skeleton = new AnimationMobs("./Image/npc/maga_Evil.png", 0, 0, 56, 84);
					view.getChildren().add(skeleton.getImageMob());
					skeleton.getImageMob().setX(posX);
					skeleton.getImageMob().setY(posY - 50);

					break;

				case "C":
					skeleton = new AnimationMobs("./Image/npc/maga_Evil.png", 0, 0, 56, 84);
					view.getChildren().add(skeleton.getImageMob());
					skeleton.getImageMob().setX(posX);
					skeleton.getImageMob().setY(posY - 50);

					break;

				case "FX":
					skeleton = new AnimationMobs("./Image/npc/maga_Evil.png", 0, 0, 56, 84);
					view.getChildren().add(skeleton.getImageMob());
					skeleton.getImageMob().setX(posX);
					skeleton.getImageMob().setY(posY - 50);

					break;

				case "S":
					skeleton = new AnimationMobs("/image/characters/vendor.png", 0, 0, 56, 84);
					view.getChildren().add(skeleton.getImageMob());
					skeleton.getImageMob().setX(posX);
					skeleton.getImageMob().setY(posY - 25);

					break;

				case "L":
					skeleton = new AnimationMobs("./Image/npc/maga_Evil.png", 0, 0, 56, 84);
					view.getChildren().add(skeleton.getImageMob());
					skeleton.getImageMob().setX(posX);
					skeleton.getImageMob().setY(posY - 50);

					break;

				case "P":
					pj.getPjImage().setX(i * model.getCell());
					pj.getPjImage().setY(j * model.getCell());

					break;
				}

				posX += model.getCell();
			}

			posY += model.getCell();
		}
	}

	/**
	 * Función <code>auxWorld</code>.
	 * 
	 * @implNote Función para obetener el mundo/nivel actual para poder traspasarlo
	 *           a otra clase.
	 */
	public WorldMapController auxWorld() {
		return new WorldMapController(this.world, this.background, this.safeZone);
	}

	@Override
	public void stop() {

	}

	public Image getBackground() {
		return background;
	}

	@Override
	public Scene getScene() {
		return scene;
	}

}
