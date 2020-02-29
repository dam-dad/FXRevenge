package dad.fxrevenge.charselect;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CharSelectControl2 extends VBox implements Initializable {
	private ToggleGroup sexo = new ToggleGroup();
	private ToggleGroup job = new ToggleGroup();

	@FXML
	private VBox root;

	@FXML
	private Label tituloLabel;

	@FXML
	private HBox nombreBox;

	@FXML
	private TextField nombreField;

	@FXML
	private HBox sexoBox;

	@FXML
	private RadioButton FemeninoRB;

	@FXML
	private RadioButton MasculinoRB;

	@FXML
	private HBox profesionBox;

	@FXML
	private RadioButton ArchmageRB;

	@FXML
	private RadioButton HunterRB;

	@FXML
	private RadioButton WarlordRB;

	@FXML
	private HBox resultadoBox;

	@FXML
	private Label nombreLabel;

	@FXML
	private ImageView playerImage;

	@FXML
	private Button FinalizarButton;

	public CharSelectControl2() throws IOException {
		super();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CharSelect2.fxml"));
		loader.setController(this);
		loader.setRoot(this);
		loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		MasculinoRB.setToggleGroup(sexo);
		FemeninoRB.setToggleGroup(sexo);

		HunterRB.setToggleGroup(job);
		WarlordRB.setToggleGroup(job);
		ArchmageRB.setToggleGroup(job);

		FinalizarButton.disableProperty()
				.bind(Bindings.when(nombreField.textProperty().isNotEmpty()
						.and(sexo.selectedToggleProperty().isNotNull()).and(job.selectedToggleProperty().isNotNull()))
						.then(false).otherwise(true));

		// bindeos del resultado
		nombreLabel.textProperty().bind(nombreField.textProperty());

		MasculinoRB.selectedProperty().addListener(e -> onChangeSelection());
		FemeninoRB.selectedProperty().addListener(e -> onChangeSelection());

		HunterRB.selectedProperty().addListener(e -> onChangeSelection());
		WarlordRB.selectedProperty().addListener(e -> onChangeSelection());
		ArchmageRB.selectedProperty().addListener(e -> onChangeSelection());

	}

	private void onChangeSelection() {
		playerImage
				.imageProperty().bind(
						getImage(
								new String("/image/characters/select/")
										.concat(Bindings
												.when(FemeninoRB.selectedProperty()
														.isEqualTo(new SimpleBooleanProperty(true)))
												.then("f").otherwise("m").getValue().concat("/"))
										.concat(Bindings
												.when(ArchmageRB
														.selectedProperty().isEqualTo(new SimpleBooleanProperty(true)))
												.then("mage")
												.otherwise(Bindings
														.when(HunterRB.selectedProperty()
																.isEqualTo(new SimpleBooleanProperty(true)))
														.then("range").otherwise("warrior"))
												.getValue().concat(".png"))));
	}

	@FXML
	private void onFinalizarButton(ActionEvent event) {
//		 this.sexo.getSelectedToggle();  obtiene el sexo seleccionado
//		 this.job.getSelectedToggle();  obtiene el togle seleccionado

		// aqui va el codigo para saltar a la siguiente pantalla
	}

	private ObjectProperty<Image> getImage(String path) {
		Image image = new Image(getClass().getResource(path).toExternalForm());

		ObjectProperty<Image> imageProperty = new SimpleObjectProperty<Image>(image);

		return imageProperty;
	}

	public VBox getView() {
		return root;
	}
}
