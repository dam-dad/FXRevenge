package dad.fxrevenge.menu.inventory;

import java.io.IOException;

import dad.fxrevenge.models.Avatar;
import dad.fxrevenge.models.Item;
import dad.fxrevenge.scene.GameScene;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Componente que permite ver los objetos del inventario de un personaje
 */
public class InventoryController extends BorderPane implements GameScene {

	// model
	private SimpleListProperty<Item> listaItems = new SimpleListProperty<Item>(this, "listaItems",
			FXCollections.observableArrayList());

	@SuppressWarnings("unused")
	private Scene scene;

	private Item item;

	@FXML
	private BorderPane view;

	@FXML
	private ImageView itemImage;

	@FXML
	private VBox datosBox;

	@FXML
	private GridPane datosGrid;

	@FXML
	private TextField precioTextField;

	@FXML
	private TextField cantidadTextField;

	@FXML
	private TextArea descripiconArea;

	@FXML
	private HBox tituloHBox;

	@FXML
	private Label tituloLabel;

	@FXML
	private Button previousButton;

	@FXML
	private Button nextButton;

	@FXML
	void onNextAction(ActionEvent event) {
		Item nuevo = null;
		for (int i = 0; i < listaItems.size(); i++) {
			if (item.getName().equals(listaItems.get(i).getName())) {
				if (i == listaItems.size() - 1) {
					nuevo = listaItems.get(0);
				} else {
					nuevo = listaItems.get(i + 1);
				}
			}
		}
		item = nuevo;
		bindeos();
	}

	@FXML
	void onPreviousAction(ActionEvent event) {
		Item nuevo = null;
		for (int i = 0; i < listaItems.size(); i++) {
			if (item.getName().equals(listaItems.get(i).getName())) {
				if (i == 0) {
					nuevo = listaItems.get(listaItems.size() - 1);
				} else {
					nuevo = listaItems.get(i - 1);
				}
			}
		}
		item = nuevo;
		bindeos();
	}

	/**
	 * Funcion para bindear de nuevo los datos tras el cambio de objeto
	 */
	private void bindeos() {
		tituloLabel.setText(item.getName());
		cantidadTextField.textProperty().bind(item.quantityProperty().asString());
		precioTextField.textProperty().bind(item.priceProperty().asString().concat(" / ").concat(item.priceProperty().divide(2).asString()));
		itemImage.imageProperty().bind(item.iconProperty());

		descripiconArea.setText(item.effectDescription(item));
	}

	@Override
	public void start() {

		scene = new Scene(view);

		// seteos de la informacion

		tituloLabel.setText(item.getName());
		cantidadTextField.textProperty().bind(item.quantityProperty().asString());
		precioTextField.textProperty().bind(item.priceProperty().asString().concat(" / ").concat(item.priceProperty().divide(2).asString()));
		itemImage.imageProperty().bind(item.iconProperty());

		descripiconArea.setText(item.effectDescription(item));
	}

	/**
	 * Constructor que carga el inventario a visualizar
	 * 
	 * @param pj Personaje de donde cogemos el inventario
	 * @throws IOException Si ocurre algún error durante la carga del archivo
	 */
	public InventoryController(Avatar pj) throws IOException {
		super();

		listaItems = new SimpleListProperty<Item>(pj.ordenarInventario());
		item = listaItems.get(0);

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/InventoryView.fxml"));
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

	public final SimpleListProperty<Item> listaItemsProperty() {
		return this.listaItems;
	}

	public final ObservableList<Item> getListaItems() {
		return this.listaItemsProperty().get();
	}

	public final void setListaItems(final ObservableList<Item> listaItems) {
		this.listaItemsProperty().set(listaItems);
	}

}
