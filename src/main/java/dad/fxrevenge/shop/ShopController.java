package dad.fxrevenge.shop;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import dad.fxrevenge.models.Avatar;
import dad.fxrevenge.models.Item;
import dad.fxrevenge.models.Vendor;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class ShopController extends GridPane implements Initializable {

	// model

	private ListProperty<Item> leftItems = new SimpleListProperty<Item>(FXCollections.observableArrayList());
	private ListProperty<Item> rightItems = new SimpleListProperty<Item>(FXCollections.observableArrayList());
	private Vendor vendedor;
	private Avatar pj;
	private int cantidad;
	private Item objeto;

	@SuppressWarnings("unused")
	private Scene scene;

	@FXML
	private GridPane view;

	@FXML
	private VBox izquierdaBox;

	@FXML
	private Label leftLabel;

	@FXML
	private ListView<Item> leftList;

	@FXML
	private ImageView vendedorImage;

	@FXML
	private TextArea vendedorArea;

	@FXML
	private Button moveRightButton;

	@FXML
	private Button moveLeftButton;

	@FXML
	private Button salirButton;

	@FXML
	private VBox derechaBox;

	@FXML
	private Label rightLabel;

	@FXML
	private ListView<Item> rightList;

	@FXML
	private Label tituloLabel;

	@FXML
	void onComproAction(ActionEvent event) {

		for (int i = 0; i < rightList.getSelectionModel().getSelectedItems().size(); i++) {

			objeto = rightList.getSelectionModel().getSelectedItems().get(i);
			Item aux = new Item().generatePotion(objeto.getEffect());
			
			// Create the custom dialog.
			Dialog<String> dialog = new Dialog<>();
			dialog.setTitle("Compra");
			dialog.setHeaderText("Objeto (Nombre/Precio)");

			// Set the button types.
			ButtonType aceptButtonType = new ButtonType("Aceptar", ButtonData.OK_DONE);
			dialog.getDialogPane().getButtonTypes().addAll(aceptButtonType, ButtonType.CANCEL);

			// Create the username and password labels and fields.
			GridPane grid = new GridPane();
			grid.setHgap(10);
			grid.setVgap(10);
			grid.setPadding(new Insets(20, 100, 10, 10));

			TextField cantidadText = new TextField();

			grid.add(new Label(aux.getName() + "/" + aux.getPrice()), 0, 0);
			grid.add(cantidadText, 1, 0);

			Node aceptButton = dialog.getDialogPane().lookupButton(aceptButtonType);
			aceptButton.setDisable(true);

			cantidadText.textProperty().addListener((observable, oldValue, newValue) -> {
				if (!newValue.trim().isEmpty()) {
					aceptButton.setDisable(!newValue.matches("[0-9]*")
							|| Integer.valueOf(newValue) * aux.getPrice() > pj.getMoney());
				}
			});

			dialog.getDialogPane().setContent(grid);

			dialog.setResultConverter(dialogButton -> {
				if (dialogButton == aceptButtonType) {
					return cantidadText.getText();
				}
				return null;
			});

			Optional<String> result = dialog.showAndWait();

			result.ifPresent(usernamePassword -> {
				cantidad = Integer.valueOf(result.get());
System.out.println("Cantidad "+cantidad);
System.out.println("Objeto "+aux);
				pj.comprar(aux, cantidad);
				objeto = null;
			});


			
		}

	}

	@FXML
	void onVendoAction(ActionEvent event) {

		for (int i = 0; i < leftList.getSelectionModel().getSelectedItems().size(); i++) {

			objeto = leftList.getSelectionModel().getSelectedItems().get(i);
			Item aux = new Item().generatePotion(objeto.getEffect());
			
			// Create the custom dialog.
			Dialog<String> dialog = new Dialog<>();
			dialog.setTitle("Venta");
			dialog.setHeaderText("Objeto (Nombre/Precio)");

			// Set the button types.
			ButtonType aceptButtonType = new ButtonType("Aceptar", ButtonData.OK_DONE);
			dialog.getDialogPane().getButtonTypes().addAll(aceptButtonType, ButtonType.CANCEL);

			// Create the username and password labels and fields.
			GridPane grid = new GridPane();
			grid.setHgap(10);
			grid.setVgap(10);
			grid.setPadding(new Insets(20, 100, 10, 10));

			TextField cantidadText = new TextField();

			grid.add(new Label(aux.getName() + "/" + aux.getPrice() / 2), 0, 0);
			grid.add(cantidadText, 1, 0);

			// Enable/Disable login button depending on whether a username was entered.
			Node aceptButton = dialog.getDialogPane().lookupButton(aceptButtonType);
			aceptButton.setDisable(true);

			// Do some validation (using the Java 8 lambda syntax).
			cantidadText.textProperty().addListener((observable, oldValue, newValue) -> {
				if (!newValue.trim().isEmpty()) {
					aceptButton.setDisable(
							!newValue.matches("[0-9]*") || Integer.valueOf(newValue) > aux.getQuantity());
				}
			});

			dialog.getDialogPane().setContent(grid);

			dialog.setResultConverter(dialogButton -> {
				if (dialogButton == aceptButtonType) {
					return cantidadText.getText();
				}
				return null;
			});

			Optional<String> result = dialog.showAndWait();

			result.ifPresent(usernamePassword -> {
				cantidad = Integer.valueOf(result.get());
			});

			pj.vender(aux, cantidad);
			objeto = null;
		}
	}

	@FXML
	void onSalirAction(ActionEvent event) {

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		vendedorImage.imageProperty().bind(vendedor.shopSpriteProperty());

		leftList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		rightList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

		leftList.itemsProperty().bindBidirectional(pj.inventoryProperty());
		rightList.itemsProperty().bindBidirectional(vendedor.potsProperty());

		moveRightButton.disableProperty().bind(leftList.getSelectionModel().selectedItemProperty().isNull());
		moveLeftButton.disableProperty().bind(rightList.getSelectionModel().selectedItemProperty().isNull());

		vendedorArea.setText("Te doy la bienvenida a mi tienda");
	}

	public ShopController(Avatar pj, Vendor vendor) throws IOException {
		super();

		this.vendedor = vendor;
		this.pj = pj;

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ShopView.fxml"));
		loader.setController(this);
		loader.setRoot(this);
		loader.load();
	}

	public GridPane getView() {
		return view;
	}

	public final ListProperty<Item> leftItemsProperty() {
		return this.leftItems;
	}

	public final ObservableList<Item> getLeftItems() {
		return this.leftItemsProperty().get();
	}

	public final void setLeftItems(final ObservableList<Item> leftItems) {
		this.leftItemsProperty().set(leftItems);
	}

	public final ListProperty<Item> rightItemsProperty() {
		return this.rightItems;
	}

	public final ObservableList<Item> getRightItems() {
		return this.rightItemsProperty().get();
	}

	public final void setRightItems(final ObservableList<Item> rightItems) {
		this.rightItemsProperty().set(rightItems);
	}

}
