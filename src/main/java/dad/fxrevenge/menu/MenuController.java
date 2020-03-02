package dad.fxrevenge.menu;

import java.io.IOException;

import dad.fxrevenge.menu.abilities.AbilitiesController;
import dad.fxrevenge.menu.bestiary.BestiaryController;
import dad.fxrevenge.menu.inventory.InventoryController;
import dad.fxrevenge.menu.stats.PlayerController;
import dad.fxrevenge.models.Avatar;
import dad.fxrevenge.scene.GameScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 * Componente que permite visualizar los enemigos que no son jefes
 * 
 */
public class MenuController extends BorderPane implements GameScene {

	private Avatar pj;
	
	private AbilitiesController habilidadesPane;
	private BestiaryController bestiarioPane;
	private InventoryController inventarioPane;
	private PlayerController estadisticasPane;

	@SuppressWarnings("unused")
	private Scene scene;

	@FXML
    private BorderPane view;

    @FXML
    private GridPane botonesGrid;

    @FXML
    private Button estadisticasButton;

    @FXML
    private Button habilidadesButton;

    @FXML
    private Button objetosButton;

    @FXML
    private Button bestiarioButton;

    @FXML
    private HBox tituloHBox;

    @FXML
    private Label tituloLabel;

    @FXML
    private Button backButton;
    
	@FXML
	void onBackAction(ActionEvent event) {
	}

	@FXML
	void onOpenAbilitiesButton(ActionEvent event) {
	}

	@FXML
	void onOpenBestiarioAction(ActionEvent event) {
	}

	@FXML
	void onOpenEstadisticasAction(ActionEvent event) {
	}

	@FXML
	void onOpenInventarioAction(ActionEvent event) {
	}

	@Override
	public void start() {

		scene = new Scene(view);

		try {
			bestiarioPane = new BestiaryController();
			estadisticasPane = new PlayerController(pj);
			habilidadesPane = new AbilitiesController(pj);
			inventarioPane = new InventoryController(pj);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Constructor que genera la lista de enemigos para visualizarlos
	 * @param pj se le pasa el objeto avatar(Hace referencia al jugador)
	 * @throws IOException Si ocurre algún error durante la carga del archivo
	 */
	public MenuController(Avatar pj) throws IOException {
		super();
		this.pj=pj;

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MenuView.fxml"));
		loader.setController(this);
		loader.setRoot(this);
		loader.load();
	}

	public BorderPane getView() {
		return view;
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}

}
