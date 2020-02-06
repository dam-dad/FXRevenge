package dad.fxrevenge.combat;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Popup;
import models.Avatar;
import models.Enemy;
import models.Item;
import models.Skill;

public class EscenarioController extends BorderPane implements Initializable {

	// model
	private Avatar pj;
	private Enemy enemy;

//	private Stage stage = view.getScene().getWindow();

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

	@FXML
	private ListView<Object> objectList;

	@FXML
	void onAttackAction(ActionEvent event) {

		int damage = pj.atacar();
		enemy.recibeDaño(damage, true);
		enemyAttack();
		eventArea.setText(eventArea.getText()+"\nHas infligido "+damage+" puntos de daño al enemigo.");
		
	}

	@FXML
	void onDefenseAction(ActionEvent event) {

		int defIn = pj.getPhysDef(), magIn = pj.getMagicDef();
		
		pj.setPhysDef((int)(defIn*1.25));
		pj.setMagicDef((int)(magIn*1.25));
		enemyAttack();
		pj.setPhysDef(defIn);
		pj.setMagicDef(magIn);
		
	}

	@FXML
	void onExitAction(ActionEvent event) {

	}

	private void enemyAttack() {
		
		int damage = enemy.atacar();
		pj.recibeDaño(damage, true);
		eventArea.setText(enemy.getName()+" ataca con "+damage+" puntos de daño.");
	}
	
	@FXML
	void onOpenInventoryAction(ActionEvent event) {

		Popup popup = new Popup();

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
					System.out.println("OK Item");
				} else {
					popup.show(view.getScene().getWindow());
				}
			}
		};

		ListView<Item> list = new ListView<Item>();
		list.setItems(pj.getInventory());
		list.setOnMouseClicked(evento);

		popup.getContent().add(list);
		popup.setAutoHide(true);

		if (!popup.isShowing())
			popup.show(view.getScene().getWindow());

	}

	@FXML
	void onUseHabilitiesAction(ActionEvent event) {
		Popup popup = new Popup();

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
					System.out.println("OK Skill");
				} else {
					popup.show(view.getScene().getWindow());
				}
			}
		};

		ListView<Skill> list = new ListView<Skill>();
		list.setItems(pj.getSkills());
		list.setOnMouseClicked(evento);

		popup.getContent().add(list);
		popup.setAutoHide(true);

		if (!popup.isShowing())
			popup.show(view.getScene().getWindow());
	}

	@FXML
	void onUseItemClicked(MouseEvent event) {
		// mouseEvent.getClickCount()
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		//bindeos jugador
		playerLabel.textProperty().bind(pj.nameProperty());
		playerImage.imageProperty().bind(pj.appearanceProperty());
//		playerHealthLabel.textProperty(pj.currentLifeProperty());
//		playerManaLabel.textProperty(pj.currentManaProperty());
		playerLifeBar.progressProperty().bind(pj.currentLifeProperty().multiply(100.0).divide(pj.getHealth()));
		playerManaBar.progressProperty().bind(pj.currentManaProperty().multiply(100.0).divide(pj.getMana()));
		
		//bindeos bicho
		enemyLabel.textProperty().bind(enemy.nameProperty());
		enemyImage.imageProperty().bind(enemy.appearanceProperty());
		enemyLifeBar.progressProperty().bind(enemy.currentLifeProperty().multiply(100.0).divide(enemy.getHealth()));

		System.out.println(enemy.getCurrentLife());
		System.out.println(enemy.getHealth());
		System.out.println(enemy.getCurrentLife()*100.0/enemy.getHealth());
	}

	public EscenarioController(Avatar pj, Enemy enemy) throws IOException {
		// ANADIR QUE EL CONSTRUCTOR RECIBA UN PJ Y UN ENEMIGO PARA INICIAR EL COMBATE
		super();

		this.enemy = enemy;
		this.pj = pj;

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CombatView.fxml"));
		loader.setController(this);
		loader.setRoot(this);
		loader.load();

	}

	public BorderPane getView() {
		return view;
	}

}
