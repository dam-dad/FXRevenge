package fxrevenge.world;


import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class StageObjectGame {
	  private ImageView image=new ImageView();
	  private BooleanProperty habitability =new SimpleBooleanProperty();
		 public StageObjectGame(String image, boolean habitability) {
			 this.image.setImage(new Image(image));
			 this.habitability.set(habitability);
		}
		 
		 
		public ImageView getImage() {
			return image;
		}


		public void setImage(ImageView image) {
			this.image = image;
		}


		public final BooleanProperty habitabilityProperty() {
			return this.habitability;
		}
		
		public final boolean isHabitability() {
			return this.habitabilityProperty().get();
		}
		
		public final void setHabitability(final boolean habitability) {
			this.habitabilityProperty().set(habitability);
		}
		
		
		
		
		
	 
}
