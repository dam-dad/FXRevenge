package dad.fxrevenge.charselect;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

public class CharSelectControl extends GridPane implements Initializable{
	private ToggleGroup sexo = new ToggleGroup();
	private ToggleGroup job = new ToggleGroup();
	
	@FXML
    private GridPane CharSelectRoot;

    @FXML
    private RadioButton ArchmageRB;

    @FXML
    private RadioButton HunterRB;

    @FXML
    private RadioButton WarlordRB;

    @FXML
    private RadioButton MasculinoRB;

    @FXML
    private RadioButton FemeninoRB;  
    
    @FXML
    private Button FinalizarButton;
    
    @FXML
    private TextField NombreField;
    
    
    
    public CharSelectControl() throws IOException {
		super();
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CharSelect.fxml"));
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
		
		FinalizarButton.disableProperty().bind(
				Bindings.when(NombreField.textProperty().isNotEmpty().and(sexo.selectedToggleProperty().isNotNull()).and(job.selectedToggleProperty().isNotNull())).then(false).otherwise(true)
				);
	}
    
	 @FXML
	  private void onFinalizarButton(ActionEvent event) {
//		 this.sexo.getSelectedToggle();  obtiene el sexo seleccionado
//		 this.job.getSelectedToggle();  obtiene el togle seleccionado
		 
		 
		 //aqui va el codigo para saltar a la siguiente pantalla
	    }
    public GridPane getView() {
    	return this.CharSelectRoot;
    }
}
