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
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

/**
 * Componente que permite visualizar los enemigos que no son jefes
 * 
 */
public class MenuController extends BorderPane implements GameScene {

	//model
	private Avatar pj;
	
	//controladores
	private AbilitiesController habilidades;
	private BestiaryController bestiario;
	private InventoryController inventario;
	private PlayerController estadisticasJugador;
	
	@SuppressWarnings("unused")
	private Scene scene;

    @FXML
    private BorderPane view;

    @FXML
    private StackPane menuPane;

    @FXML
    private HBox tituloHBox;

    @FXML
    private Label tituloLabel;

    @FXML
    private Button backButton;

    @FXML
    void onBackAction(ActionEvent event) {

    }

	@Override
	public void start() {

		scene = new Scene(view);
		
		

	}

	/**
	 * Constructor que genera la lista de enemigos para visualizarlos
	 * 
	 * @throws IOException Si ocurre algún error durante la carga del archivo
	 */
	public MenuController(Avatar pj) throws IOException {
		super();

		this.pj=pj;
		bestiario = new BestiaryController();
		estadisticasJugador = new PlayerController(pj);
		habilidades = new AbilitiesController(pj);
		inventario = new InventoryController(pj);
		
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
