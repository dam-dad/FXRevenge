package dad.fxrevenge.menu.stats;

import java.io.IOException;

import dad.fxrevenge.models.Avatar;
import dad.fxrevenge.scene.GameScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Componente que visualiza los atributos del personaje
 *
 */
public class PlayerController extends BorderPane implements GameScene {

	//model
	private Avatar pj;
	
	@SuppressWarnings("unused")
	private Scene scene;

    @FXML
    private BorderPane view;

    @FXML
    private ImageView playerImage;

    @FXML
    private VBox datosBox;

    @FXML
    private GridPane datosGrid;

    @FXML
    private TextField nivelTextField;

    @FXML
    private TextField experienciaTextField;

    @FXML
    private TextField vidaTextField;

    @FXML
    private TextField manaTextField;

    @FXML
    private TextField ataqueFisTextField;

    @FXML
    private TextField ataqueMagTextField;

    @FXML
    private TextField defFisTextField;

    @FXML
    private TextField defMagTextField;

    @FXML
    private TextField criticoTextField;

    @FXML
    private TextField dineroTextField;

    @FXML
    private HBox tituloHBox;

    @FXML
    private Label tituloLabel;

    @FXML
    private Label notaLabel;
    
	@FXML
    private Button backButton;

    @FXML
    void onBackAction(ActionEvent event) {

    }

	@Override
	public void start() {

		scene = new Scene(view);

		// seteos de la informacion
		playerImage.imageProperty().bind(pj.combatSpriteProperty());
		
		tituloLabel.textProperty().bind(pj.nameProperty().concat(" ("+pj.getWork()+")"));
		nivelTextField.textProperty().bind(pj.levelProperty().asString());
		experienciaTextField.textProperty().bind(pj.currentExpProperty().asString().concat("/").concat(pj.totalLevelExpProperty().asString()));
		vidaTextField.textProperty().bind(pj.currentLifeProperty().asString().concat("/").concat(pj.HealthProperty().asString()));
		manaTextField.textProperty().bind(pj.currentManaProperty().asString().concat("/").concat(pj.ManaProperty().asString()));
		ataqueFisTextField.textProperty().bind(pj.PhysDamageProperty().asString());
		ataqueMagTextField.textProperty().bind(pj.MagicDamageProperty().asString());
		defFisTextField.textProperty().bind(pj.PhysDefProperty().asString());
		defMagTextField.textProperty().bind(pj.MagicDefProperty().asString());
		criticoTextField.textProperty().bind(pj.CritChanceProperty().asString());
		dineroTextField.textProperty().bind(pj.moneyProperty().asString());
		
	}

	/**
	 * Construtor que carga el fxml para la vista de la app con los datos del avatar
	 * 
	 * @param pj Personaje del que visualizamos los atributos
	 * @throws IOException Si ocurre algún error durante la carga del archivo
	 */
	public PlayerController(Avatar pj) throws IOException {
		super();

		this.pj=pj;

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PlayerView.fxml"));
		loader.setController(this);
		loader.setRoot(this);
		loader.load();
	}

	public BorderPane getView() {
		return view;
	}

	@Override
	public void stop() {
	}

}
