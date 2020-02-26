package dad.fxrevenge.menu.abilities;

import java.io.IOException;

import dad.fxrevenge.models.Avatar;
import dad.fxrevenge.models.Skill;
import dad.fxrevenge.scene.GameScene;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleBooleanProperty;
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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class AbilitiesController extends BorderPane implements GameScene {

	// model
	private SimpleListProperty<Skill> listaHabilidades = new SimpleListProperty<Skill>(this, "listaHabilidades",
			FXCollections.observableArrayList());

	private int ataque, magia;

	@SuppressWarnings("unused")
	private Scene scene;

	private Skill ability;

	@FXML
	private BorderPane view;

	@FXML
	private VBox decripcionBox;

	@FXML
	private TextArea descriptionArea;

	@FXML
	private VBox datosBox;

	@FXML
	private GridPane datosGrid;

	@FXML
	private TextField costeText;

	@FXML
	private TextField nivelText;

	@FXML
	private TextField danioText;

	@FXML
	private Label fisicoLabel;

	@FXML
	private Label tituloLabel;

	@FXML
	private Button previousButton;

	@FXML
	private Button nextButton;

	@FXML
	void onNextAction(ActionEvent event) {
		Skill nuevo = null;
		for (int i = 0; i < listaHabilidades.size(); i++) {
			if (ability.getName().equals(listaHabilidades.get(i).getName())) {
				if (i == listaHabilidades.size() - 1) {
					nuevo = listaHabilidades.get(0);
				} else {
					nuevo = listaHabilidades.get(i + 1);
				}
			}
		}
		ability = nuevo;
		bindeos();
	}

	@FXML
	void onPreviousAction(ActionEvent event) {
		Skill nuevo = null;
		for (int i = 0; i < listaHabilidades.size(); i++) {
			if (ability.getName().equals(listaHabilidades.get(i).getName())) {
				if (i == 0) {
					nuevo = listaHabilidades.get(listaHabilidades.size() - 1);
				} else {
					nuevo = listaHabilidades.get(i - 1);
				}
			}
		}
		ability = nuevo;
		bindeos();
	}

	private void bindeos() {

		tituloLabel.setText(ability.getName());
		costeText.textProperty().bind(ability.costProperty().asString());
		nivelText.textProperty().bind(ability.unlockLevelProperty().asString());
		danioText.textProperty().bind(
				ability.DamageProperty().asString().concat("+").concat(ability.DamageMultiplierProperty().asString()));

		fisicoLabel.textProperty()
				.bind(Bindings.when(ability.DamageTypeProperty().isEqualTo(new SimpleBooleanProperty(false))).then("No")
						.otherwise("Sí"));

//		descriptionArea.setText(ability.effectDescription(ability));
	}

	@Override
	public void start() {

		scene = new Scene(view);

		// seteos de la informacion

		tituloLabel.setText(ability.getName());
		costeText.textProperty().bind(ability.costProperty().asString());
		nivelText.textProperty().bind(ability.unlockLevelProperty().asString());
		danioText.textProperty().bind(
				
				Bindings.when(ability.DamageTypeProperty().isEqualTo(new SimpleBooleanProperty(false)))
				.then(ability.DamageProperty().add(ability.DamageMultiplierProperty().multiply(magia).intValue()))
				.otherwise(ability.DamageProperty().add(ability.DamageMultiplierProperty().multiply(ataque).intValue())).asString()
				
				);

		fisicoLabel.textProperty()
				.bind(Bindings.when(ability.DamageTypeProperty().isEqualTo(new SimpleBooleanProperty(false))).then("Mágico")
						.otherwise("Físico"));

//		descriptionArea.setText(ability.effectDescription(ability));
	}

	public AbilitiesController(Avatar pj) throws IOException {
		super();

		listaHabilidades = new SimpleListProperty<Skill>(pj.getLearnedSkills());
		ability = listaHabilidades.get(0);
		ataque = pj.getPhysDamage();
		magia = pj.getMagicDamage();

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/AbilitiesView.fxml"));
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

	public final SimpleListProperty<Skill> listaHabilidadesProperty() {
		return this.listaHabilidades;
	}

	public final ObservableList<Skill> getListaHabilidades() {
		return this.listaHabilidadesProperty().get();
	}

	public final void setListaHabilidades(final ObservableList<Skill> listaHabilidades) {
		this.listaHabilidadesProperty().set(listaHabilidades);
	}

}
