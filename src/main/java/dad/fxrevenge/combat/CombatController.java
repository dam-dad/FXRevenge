package dad.fxrevenge.combat;

import java.io.IOException;
import java.util.Collections;
import java.util.Optional;

import dad.fxrevenge.models.Avatar;
import dad.fxrevenge.models.Enemy;
import dad.fxrevenge.models.Item;
import dad.fxrevenge.models.Race;
import dad.fxrevenge.models.Skill;
import dad.fxrevenge.parameters.Parameters;
import dad.fxrevenge.scene.GameScene;
import dad.fxrevenge.scene.SceneManager;
import dad.fxrevenge.screen.GameOverScreen;
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
 */
public class CombatController extends BorderPane implements GameScene {

	@SuppressWarnings("unused")
	private Scene scene; // Scene necesaria para SceneManager

	private Avatar player;
	private Enemy enemy;
	private Image background; // Imagen de fondo

	private int turno = 0; // variable unica para el combate final
	private boolean bind = false; // variable unica para el combate final

	@FXML
	private BorderPane view;

	@FXML
	private TextArea eventArea;

	@FXML
	private Button attackButton, defenseButton, habilitiesButton, inventoryButton, exitButton;

	@FXML
	private Label playerLabel, playerHealthLabel, playerManaLabel, enemyLabel;

	@FXML
	private ProgressBar playerLifeBar, playerManaBar, enemyLifeBar;

	@FXML
	private ImageView playerImage, enemyImage;

	/**
	 * Función que maneja el ataque "básico" del avatar, es decir, cuando no usa
	 * alguna habilidad
	 * 
	 * @param evento que ocurre cuando se llama a la función
	 */
	@FXML
	void onAttackAction(ActionEvent event) {

		int damage = player.atacar();
		boolean egoista = (Math.random() < 0.5) ? true : false;

		eventArea.setText("");

		if (egoista) {
			eventArea.setText(
					eventArea.getText() + "\nHas infligido " + enemy.recibeDanyo(damage, true) + " puntos de daño.");
			enemyAttack();
		} else {
			enemyAttack();
			eventArea.setText(
					eventArea.getText() + "\nHas infligido " + enemy.recibeDanyo(damage, true) + " puntos de daño.");
		}
//DROPEO	
		if (enemy.getCurrentLife() <= 0) {
			victory();
		}

	}

	protected void victory() {
		// Enemigo derrotado. Hacer override al heredar. Cualquier cosa que deba pasar
		// al derrotar a un enemigo se pone en el victory de SimpleCombat
	}

	/**
	 * Incrementa la defensa del avatar para minimizar el siguiente daño recibido
	 * 
	 * @param event evento que ocurre cuando se llama a la función
	 */
	@FXML
	void onDefenseAction(ActionEvent event) {
		eventArea.setText("");
		int defIn = player.getPhysDef(), magIn = player.getMagicDef();

		player.setPhysDef((int) (defIn * 1.25));
		player.setMagicDef((int) (magIn * 1.25));
		enemyAttack();
		player.setPhysDef(defIn);
		player.setMagicDef(magIn);

	}

	/**
	 * Permite al usuario huir del combate
	 * 
	 * @param event evento que ocurre cuando se llama a la función
	 */
	@FXML
	void onExitAction(ActionEvent event) {

	}

	/**
	 * Permite el calculo de daño del enemigo cuando le toque atacar
	 */
	private void enemyAttack() {

		turno++;
		System.out.println("Turno " + turno);
		int damage = enemy.atacar();
		if (turno % 3 == 0 && enemy.getRace().equals(Race.FX)) {
			eventArea.setText(eventArea.getText() + "\n" + enemy.getName() + " usa Bind con "
					+ player.recibeDanyo((int) (damage * 2), true) + " puntos de daño.");
		} else {
			eventArea.setText(eventArea.getText() + "\n" + enemy.getName() + " ataca con "
					+ player.recibeDanyo(damage, true) + " puntos de daño.");
		}
		if (turno % 3 == 2) {
			bind = true;
		} else {
			bind = false;
		}

		if (player.getCurrentLife() == 0) {
			SceneManager.changeScene(new GameOverScreen());
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

				Item item = list.getSelectionModel().getSelectedItem();

				if (item.getEffect() != null) {
					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle("¿Seguro que quieres usarlo?");
					alert.setHeaderText("¿Debería usar " + item.getName() + "?");
					alert.setContentText(item.effectDescription(item));

					ButtonType elijoButton = new ButtonType("Decidido: ¡Te elijo a ti!");
					ButtonType meNiegoButton = new ButtonType("Otro día...");

					alert.getButtonTypes().setAll(elijoButton, meNiegoButton);

					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == elijoButton) {

						int mana = -1, cura = -1;

						if (item.getQuantity() > 0) {
							switch (item.getEffect()) {

							case HealRestore:
								cura = (int) (player.getHealth() * 0.5);
								break;

							case ManaRestore:
								mana = (int) (player.getMana() * 0.5);
								break;
							case MaxiHealRestore:
								cura = (int) (player.getHealth() * 0.75);
								break;

							case MaxiManaRestore:
								mana = (int) (player.getMana() * 0.75);
								break;
							case MiniHealRestore:
								cura = (int) (player.getHealth() * 0.25);
								break;
							case MiniManaRestore:
								mana = (int) (player.getMana() * 0.25);
								break;
							}

							if (cura > 0) {
								if (cura + player.getCurrentLife() > player.getHealth()) {
									cura = player.getHealth() - player.getCurrentLife();
									player.setCurrentLife(player.getHealth());
								} else
									player.setCurrentLife(player.getCurrentLife() + cura);
							}
							if (mana > 0) {
								if (mana + player.getCurrentMana() > player.getMana()) {
									mana = player.getMana() - player.getCurrentMana();
									player.setCurrentMana(player.getMana());

								} else
									player.setCurrentMana(player.getCurrentMana() + mana);
							}
							player.getInventory().get(player.getInventory().indexOf(item))
									.setQuantity(item.getQuantity() - 1);

							if (cura != -1) {
								eventArea.setText("Te has curado " + cura + " puntos de vida.");
							} else if (mana != -1) {
								eventArea.setText("Has recuperado " + mana + " puntos de mana.");
							}
							enemyAttack();
						} else {
							Alert alert3 = new Alert(AlertType.INFORMATION);
							alert3.setTitle("Vaya...");
							alert3.setContentText(
									"Parece que te has quedado sin " + item.getName() + ", compra cuanto antes.");
							alert3.show();
						}
					}

				} else {
					popup.show(view.getScene().getWindow());
				}
			}
		};
		list.setItems(player.getInventory());
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

					eventArea.setText("");

					if (!hability.getName().equals("Unbind")) {
						int nuevoMana = player.getCurrentMana() - hability.getCost();
						if (nuevoMana < 0) {

							Alert alert2 = new Alert(AlertType.INFORMATION);
							alert2.setTitle("Vaya...");
							alert2.setHeaderText("Sin maná");
							alert2.setContentText("Parece que no tienes suficiente maná, un objeto podría ayudarte ;D");
							alert2.showAndWait();

							popup.show(view.getScene().getWindow());
						} else {
							player.setCurrentMana(nuevoMana);

							int damage = player.atacar(hability);
							boolean egoista = (Math.random() < 0.5) ? true : false;

							if (egoista) {
								eventArea.setText(eventArea.getText() + "\nHas infligido "
										+ enemy.recibeDanyo(damage, hability.getDamageType()) + " puntos de daño con "
										+ hability.getName() + ".");
								if (enemy.getCurrentLife() <= 0) {
									victory();
								}
								enemyAttack();
							} else {
								enemyAttack();
								eventArea.setText(eventArea.getText() + "\nHas infligido "
										+ enemy.recibeDanyo(damage, hability.getDamageType()) + " puntos de daño con "
										+ hability.getName() + ".");
								if (enemy.getCurrentLife() <= 0) {
									victory();
								}
							}
						}
					} else {
						if (bind) {
							int defIn = player.getPhysDef(), magIn = player.getMagicDef();

							player.setPhysDef((int) (defIn * 1.50));
							player.setMagicDef((int) (magIn * 1.50));
							enemyAttack();
							player.setPhysDef(defIn);
							player.setMagicDef(magIn);

							eventArea.setText(eventArea.getText() + "\nHas infligido "
									+ enemy.recibeDanyo((int) (enemy.getHealth() * 0.15), hability.getDamageType())
									+ " puntos de daño con " + hability.getName() + ".");
							if (enemy.getCurrentLife() <= 0) {
								victory();
							}
						} else {
							eventArea.setText(eventArea.getText() + "\nIntenas usar Unbind, pero no ha hecho efecto.");
							enemyAttack();
						}
					}
				} else {
					popup.show(view.getScene().getWindow());
				}
			}
		};

		list.setItems(player.getLearnedSkills());
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
				Collections.singletonList(new BackgroundImage(background, BackgroundRepeat.NO_REPEAT,
						BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT))));
	}

	@Override
	public void start() {

		scene = new Scene(view, Parameters.getResolutionWidth(), Parameters.getResolutionHeight()); // Crea la escena
																									// con la resolución
		// especificada en la interfaz
		// Parameters

		setBackground();

		if (enemy.getRace().equals(Race.FX)) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Nueva habilidad");
			alert.setHeaderText("Has aprendido Unbind");
			alert.setContentText("Será tu arma secreta contra el desafío final.");
			alert.show();

			player.getLearnedSkills().add(new Skill("Unbind", 0, 0, 0, false, 0.0, 0,
					"Te permitirá resistir el mayor ataque de FX: \"Bind\""));

		}
		// bindeos jugador
		playerLabel.textProperty()
				.bind(player.nameProperty().concat(" Lv. ").concat(player.levelProperty().asString()));
		playerImage.imageProperty().bind(player.combatSpriteProperty());
		playerHealthLabel.textProperty()
				.bind(player.currentLifeProperty().asString().concat("/").concat(player.HealthProperty()));
		playerManaLabel.textProperty()
				.bind(player.currentManaProperty().asString().concat("/").concat(player.ManaProperty()));

		playerLifeBar.progressProperty().bind((player.currentLifeProperty().multiply(1.0).divide(player.getHealth())));
		playerManaBar.progressProperty().bind(player.currentManaProperty().multiply(1.0).divide(player.getMana()));
		playerLifeBar.progressProperty().addListener((o, ov, nv) -> {
			Color color = interpolate(Color.RED, Color.YELLOW, Color.GREEN, nv.doubleValue());
			String web = color.toString().replace("0x", "#");
			Region r = (Region) playerLifeBar.lookup(".bar");
			r.setStyle("-fx-background-color:" + web + ";");
		});

		// bindeos bicho
		enemyLabel.textProperty().bind(enemy.nameProperty().concat(" Lv. ").concat(enemy.levelProperty().asString()));
		enemyImage.imageProperty().bind(enemy.combatSpriteProperty());
		enemyLifeBar.progressProperty().bind(enemy.currentLifeProperty().multiply(1.0).divide(enemy.getHealth()));

		enemyLifeBar.progressProperty().addListener((o, ov, nv) -> {
			Color color = interpolate(Color.RED, Color.YELLOW, Color.GREEN, nv.doubleValue());
			String web = color.toString().replace("0x", "#");
			Region r = (Region) enemyLifeBar.lookup(".bar");
			r.setStyle("-fx-background-color:" + web + ";");
		});

	}

	public CombatController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CombatView.fxml"));
		loader.setController(this);
		loader.setRoot(this);
		loader.load();
	}

	/**
	 * 
	 * @param pj    avatar que se enfrentará al enemigo
	 * @param enemy enemigo al que se enfrentará el avatar
	 * @throws IOException En caso de no encontrar el archivo .fxml para la carga de
	 *                     la vista
	 */
	public CombatController(Avatar pj, Enemy enemy) throws IOException {
		this();
		this.enemy = enemy;
		this.player = pj;
	}

	/**
	 * 
	 * @param pj         avatar que se enfrentará al enemigo
	 * @param enemy      enemigo al que se enfrentará el avatar
	 * @param background imagen que será el fondo del combate
	 * @throws IOException En caso de no encontrar el archivo .fxml para la carga de
	 *                     la vista
	 */
	public CombatController(Avatar pj, Enemy enemy, Image background) throws IOException {
		this(pj, enemy);
		this.background = background;
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

	}

}
