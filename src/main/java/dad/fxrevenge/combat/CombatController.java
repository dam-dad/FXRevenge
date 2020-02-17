package dad.fxrevenge.combat;

import java.io.IOException;
import java.util.Collections;
import java.util.Optional;

import dad.fxrevenge.models.Avatar;
import dad.fxrevenge.models.Enemy;
import dad.fxrevenge.models.Item;
import dad.fxrevenge.models.Race;
import dad.fxrevenge.models.Skill;
import dad.fxrevenge.scene.GameScene;
import dad.fxrevenge.scene.Parameters;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.stage.Popup;

/**
 * Clase java, que actua como componente JavaFX que permite emular un combate
 * entre un avatar y un enemigo
 * 
 * @author Adan
 *
 */
public class CombatController extends BorderPane implements GameScene, Parameters {

	// model
	private Avatar pj;
	private Enemy enemy;

	@SuppressWarnings("unused")
	private Scene scene; // Scene necesaria para SceneManager

	// Imagen de fondo
	private Image backgroundImage;

	@FXML
	private BorderPane view;

	@FXML
	private TextArea eventArea;

	@FXML
	private Button attackButton;

	@FXML
	private Button habilitiesButton;

	@FXML
	private Button defenseButton;

	@FXML
	private Button inventoryButton;

	@FXML
	private Button exitButton;

	@FXML
	private Label playerLabel;

	@FXML
	private Label playerHealthLabel;

	@FXML
	private ProgressBar playerLifeBar;

	@FXML
	private Label playerManaLabel;

	@FXML
	private ImageView playerImage;

	@FXML
	private Label enemyLabel;

	@FXML
	private ProgressBar enemyLifeBar;

	@FXML
	private ProgressBar playerManaBar;

	@FXML
	private ImageView enemyImage;

	/**
	 * Función que maneja el ataque "básico" del avatar, es decir, cuando no usa
	 * alguna habilidad
	 * 
	 * @param evento que ocurre cuando se llama a la función
	 */
	@FXML
	void onAttackAction(ActionEvent event) {

		int damage = pj.atacar();
		boolean egoista = (Math.random() < 0.5) ? true : false;

		eventArea.setText("");

		if (egoista) {
			eventArea.setText(
					eventArea.getText() + "\nHas infligido " + enemy.recibeDaño(damage, true) + " puntos de daño.");
			enemyAttack();
		} else {
			enemyAttack();
			eventArea.setText(
					eventArea.getText() + "\nHas infligido " + enemy.recibeDaño(damage, true) + " puntos de daño.");
		}
//DROPEO DE ITEM Y GEAR		
		if (enemy.getCurrentLife() == 0) {
			if (enemy.getRace().equals(Race.Boss)) {
				pj.equipar(enemy.getGearDrop());
			} else {

			}

		}

	}

	/**
	 * Incrementa la defensa del avatar para minimizar el siguiente daño recibido
	 * 
	 * @param event evento que ocurre cuando se llama a la función
	 */
	@FXML
	void onDefenseAction(ActionEvent event) {
		eventArea.setText("");
		int defIn = pj.getPhysDef(), magIn = pj.getMagicDef();

		pj.setPhysDef((int) (defIn * 1.25));
		pj.setMagicDef((int) (magIn * 1.25));
		enemyAttack();
		pj.setPhysDef(defIn);
		pj.setMagicDef(magIn);

	}

	/**
	 * Permite al usuario huir del combate
	 * 
	 * @param event evento que ocurre cuando se llama a la función
	 */
	@FXML
	void onExitAction(ActionEvent event) {
		Platform.exit();
	}

	/**
	 * Permite el calculo de daño del enemigo cuando le toque atacar
	 */
	private void enemyAttack() {

		int damage = enemy.atacar();

		eventArea.setText(eventArea.getText() + "\n" + enemy.getName() + " ataca con " + pj.recibeDaño(damage, true)
				+ " puntos de daño.");

		if (pj.getCurrentLife() == 0) {

			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Vaya vaya...");
			alert.setHeaderText("Pues parece que");
			alert.setContentText("Te has llevado el cholazo...");
			alert.showAndWait();

			Platform.exit();
		}

	}

	/**
	 * Permite usar objetos del inventario
	 * 
	 * @param event evento que ocurre cuando se llama a la función
	 */
	@FXML
	void onOpenInventoryAction(ActionEvent event) {

		Popup popup = new Popup();
		ListView<Item> list = new ListView<Item>();

		EventHandler<MouseEvent> evento;
		evento = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("¿Seguro que quieres usarlo?");
				alert.setHeaderText("¿Seré invencible con esto?");
				alert.setContentText("Aún tengo mis dudas...");

				ButtonType elijoButton = new ButtonType("Decidido: ¡Te elijo a ti!");
				ButtonType meNiegoButton = new ButtonType("Otro día...");

				alert.getButtonTypes().setAll(elijoButton, meNiegoButton);

				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == elijoButton) {
					Item item = list.getSelectionModel().getSelectedItem();

					int mana = -1, cura = -1;
					if (item.getEffect() != null) {
						switch (item.getEffect()) {

						case HealRestore:
							cura = (int) (pj.getHealth() * 0.5);
							break;

						case ManaRestore:
							mana = (int) (pj.getMana() * 0.5);
							break;
						case MaxiHealRestore:
							cura = (int) (pj.getHealth() * 0.75);
							break;

						case MaxiManaRestore:
							mana = (int) (pj.getMana() * 0.75);
							break;
						case MiniHealRestore:
							cura = (int) (pj.getHealth() * 0.25);
							break;
						case MiniManaRestore:
							mana = (int) (pj.getMana() * 0.25);
							break;
						}

						if (cura + pj.getCurrentLife() > pj.getHealth()) {
							cura = pj.getHealth() - pj.getCurrentLife();
							pj.setCurrentLife(pj.getHealth());
						} else
							pj.setCurrentLife(cura);

						if (mana + pj.getCurrentMana() > pj.getMana()) {
							mana = pj.getMana() - pj.getCurrentMana();
							pj.setCurrentMana(pj.getMana());

						} else
							pj.setCurrentMana(mana);

						pj.getInventory().get(pj.getInventory().indexOf(item)).setQuantity(item.getQuantity() - 1);

						if (cura != -1) {
							eventArea.setText("Te has curado " + cura + " puntos de vida.");
						} else if (mana != -1) {
							eventArea.setText("Has recuperado " + mana + " puntos de mana.");
						}
						enemyAttack();

					} else {
						Alert alert2 = new Alert(AlertType.INFORMATION);
						alert2.setTitle("Vaya...");
						alert2.setContentText("Parece que no está implementado del todo el objeto, lo sentimos :(");
						alert2.show();

					}

//System.out.println(list.getSelectionModel().getSelectedItem().getName());

				} else {
					popup.show(view.getScene().getWindow());
				}
			}
		};
		list.setItems(pj.getInventory());
		list.setOnMouseClicked(evento);
		list.setMaxHeight(view.getHeight() / 3.0);

		popup.getContent().add(list);
		popup.setAutoHide(true);

		if (!popup.isShowing())
			popup.show(view.getScene().getWindow());

	}

	/**
	 * Permite al usuario ver las habilidades aprendidas del avatar y usar una
	 * 
	 * @param event evento que ocurre cuando se llama a la función
	 */
	@FXML
	void onUseHabilitiesAction(ActionEvent event) {
		Popup popup = new Popup();

		ListView<Skill> list = new ListView<Skill>();

		EventHandler<MouseEvent> evento;
		evento = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Mmmm, pensando");
				alert.setHeaderText("¿Acabaré con ellos?");
				alert.setContentText("Aún no lo tengo claro...");

				ButtonType elijoButton = new ButtonType("¡Yo te invoco!");
				ButtonType meNiegoButton = new ButtonType("No esta vez...");

				alert.getButtonTypes().setAll(elijoButton, meNiegoButton);

				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == elijoButton) {
					Skill hability = list.getSelectionModel().getSelectedItem();

					int nuevoMana = pj.getCurrentMana() - hability.getCost();
					if (nuevoMana < 0) {

						Alert alert2 = new Alert(AlertType.INFORMATION);
						alert2.setTitle("Vaya...");
						alert2.setHeaderText("Sin maná");
						alert2.setContentText("Parece que no tienes suficiente maná, un objeto podría ayudarte ;D");
						alert2.showAndWait();

						popup.show(view.getScene().getWindow());
					} else {
						pj.setCurrentMana(nuevoMana);

						int damage = pj.atacar(hability);
						boolean egoista = (Math.random() < 0.5) ? true : false;

						eventArea.setText("");

						if (egoista) {
							eventArea.setText(eventArea.getText() + "\nHas infligido "
									+ enemy.recibeDaño(damage, hability.getDamageType()) + " puntos de daño con "
									+ hability.getName() + ".");
							enemyAttack();
						} else {
							enemyAttack();
							eventArea.setText(eventArea.getText() + "\nHas infligido "
									+ enemy.recibeDaño(damage, hability.getDamageType()) + " puntos de daño con "
									+ hability.getName() + ".");
						}
					}
				} else {
					popup.show(view.getScene().getWindow());
				}
			}
		};

		list.setItems(pj.getLearnedSkills());
		list.setOnMouseClicked(evento);
		list.setMaxHeight(view.getHeight() / 3.0);

		popup.getContent().add(list);
		popup.setAutoHide(true);

		if (!popup.isShowing())
			popup.show(view.getScene().getWindow());

	}

	/**
	 * Permite crear el fondo a partir de una imagen
	 */
	private void setBackground() {
		view.setBackground(new Background(
				Collections.singletonList(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)),
				Collections.singletonList(new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT,
						BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT))));
	}

	@Override
	public void start() {

		scene = new Scene(view, GAME_RESOLUTION_WIDTH, GAME_RESOLUTION_HEIGHT); // Crea la escena con la resolución
																				// especificada en la interfaz
																				// Parameters

		setBackground();

		// bindeos jugador
		playerLabel.textProperty().bind(pj.nameProperty());
		playerImage.imageProperty().bind(pj.appearanceProperty());
		playerHealthLabel.textProperty()
				.bind(pj.currentLifeProperty().asString().concat("/").concat(pj.HealthProperty()));
		playerManaLabel.textProperty().bind(pj.currentManaProperty().asString().concat("/").concat(pj.ManaProperty()));

		playerLifeBar.progressProperty().bind((pj.currentLifeProperty().multiply(1.0).divide(pj.getHealth())));
		playerManaBar.progressProperty().bind(pj.currentManaProperty().multiply(1.0).divide(pj.getMana()));
		playerLifeBar.progressProperty().addListener((o, ov, nv) -> {
			Color color = interpolate(Color.RED, Color.YELLOW, Color.GREEN, nv.doubleValue());
			String web = color.toString().replace("0x", "#");
			Region r = (Region) playerLifeBar.lookup(".bar");
			r.setStyle("-fx-background-color:" + web + ";");
		});

		// bindeos bicho
		enemyLabel.textProperty().bind(enemy.nameProperty());
		enemyImage.imageProperty().bind(enemy.appearanceProperty());
		enemyLifeBar.progressProperty().bind(enemy.currentLifeProperty().multiply(1.0).divide(enemy.getHealth()));

		enemyLifeBar.progressProperty().addListener((o, ov, nv) -> {
			Color color = interpolate(Color.RED, Color.YELLOW, Color.GREEN, nv.doubleValue());
			String web = color.toString().replace("0x", "#");
			Region r = (Region) enemyLifeBar.lookup(".bar");
			r.setStyle("-fx-background-color:" + web + ";");
		});

	}

	/**
	 * 
	 * @param pj    avatar que se enfrentará al enemigo
	 * @param enemy enemigo al que se enfrentará el avatar
	 * @throws IOException En caso de no encontrar el archivo .fxml para la carga de
	 *                     la vista
	 */
	public CombatController(Avatar pj, Enemy enemy) throws IOException {
		super();

		this.enemy = enemy;
		this.pj = pj;

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CombatView.fxml"));
		loader.setController(this);
		loader.setRoot(this);
		loader.load();

	}

	/**
	 * 
	 * @param pj    avatar que se enfrentará al enemigo
	 * @param enemy enemigo al que se enfrentará el avatar
	 * @param fondo imagen que será el fondo del combate
	 * @throws IOException En caso de no encontrar el archivo .fxml para la carga de
	 *                     la vista
	 */
	public CombatController(Avatar pj, Enemy enemy, Image fondo) throws IOException {
		super();

		this.enemy = enemy;
		this.pj = pj;
		this.backgroundImage = fondo;

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CombatView.fxml"));
		loader.setController(this);
		loader.setRoot(this);
		loader.load();

	}

	/**
	 * 
	 * @param color1  primer color del progressbar
	 * @param color2  segundo color del progressbar
	 * @param percent valor numerico en el que se encuentra la barra del progressbar
	 * @return retorna el color necesario en base a cómo de cerca se encuentra el
	 *         color deseado con respecto a los extremos
	 */
	public Color interpolate(Color color1, Color color2, double percent) {
		double red = color1.getRed() + percent * (color2.getRed() - color1.getRed());
		double green = color1.getGreen() + percent * (color2.getGreen() - color1.getGreen());
		double blue = color1.getBlue() + percent * (color2.getBlue() - color1.getBlue());
		return Color.color(Math.abs(red), Math.abs(green), Math.abs(blue));
	}

	/**
	 * 
	 * @param color1  primer color del progressbar
	 * @param color2  segundo color del progressbar
	 * @param color3  tercer color del progressbar
	 * @param percent valor numerico en el que se encuentra la barra del progressbar
	 * @return llamada a interpolate {@link #interpolate(Color, Color, double)}
	 */
	public Color interpolate(Color color1, Color color2, Color color3, double percent) {
		if (percent <= 0.5) {
			return interpolate(color1, color2, percent * 2);
		} else {
			return interpolate(color2, color3, (percent - 0.5) * 2);
		}
	}

	/**
	 * 
	 * @return devuelve el elemento padre del componente
	 */
	public BorderPane getView() {
		return view;
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}

}
