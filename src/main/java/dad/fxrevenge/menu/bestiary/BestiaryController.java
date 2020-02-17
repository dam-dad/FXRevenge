package dad.fxrevenge.menu.bestiary;

import java.io.IOException;

import dad.fxrevenge.models.Enemy;
import dad.fxrevenge.models.Item;
import dad.fxrevenge.scene.GameScene;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class BestiaryController extends BorderPane implements GameScene {

//QUITAR CAIDOS? POSIBLES DROPS?
	private Enemy enemy;
	
	@FXML
	private BorderPane view;

    @FXML
    private Spinner<Integer> level;
    
	@FXML
	private ImageView enemyImage;

	@FXML
	private VBox datosBox;

	@FXML
	private GridPane datosGrid;

	@FXML
	private TextField expTextField;

	@FXML
	private TextField oroTextField;

	@FXML
	private TextField caidosTextField;

	@FXML
	private ListView<Item> dropList;

	@FXML
	private TextArea descripiconArea;

	@FXML
	private HBox tituloHBox;

	@FXML
	private Label razaLabel;

	public BestiaryController(Enemy bichito) throws IOException {
		super();
		this.enemy=bichito;
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/BestiarioView.fxml"));
		loader.setController(this);
		loader.setRoot(this);
		loader.load();
	}

	public BorderPane getView() {
		return view;
	}

	@Override
	public void start() {

//		level = new Spinner<Integer>();
		
		SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 1);
		level.setValueFactory(valueFactory);
		
		//seteos de la informacion
		
		razaLabel.setText(enemy.getRace().toString());
		enemy.levelProperty().bind(level.valueProperty());
		expTextField.textProperty().bind(enemy.expProperty().multiply(enemy.levelProperty()).asString());
		oroTextField.textProperty().bind(enemy.moneyProperty().multiply(enemy.levelProperty()).asString());
//		setText(String.valueOf(enemy.getExpDrop()/enemy.getLevel()));
//REVISAR LISTA DE DROPS		dropList.setItems(enemy);
		descripiconArea.setText(enemy.getDescription());
		
		

	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}
}
