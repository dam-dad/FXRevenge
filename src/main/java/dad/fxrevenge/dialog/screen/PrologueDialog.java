package dad.fxrevenge.dialog.screen;

import dad.fxrevenge.dialog.character.Character;
import dad.fxrevenge.dialog.character.CharacterList;
import dad.fxrevenge.models.Avatar;
import dad.fxrevenge.models.ClassType;
import dad.fxrevenge.models.Enemy;
import dad.fxrevenge.models.Item;
import dad.fxrevenge.models.Race;
import dad.fxrevenge.models.Skill;

import java.io.IOException;

import dad.fxrevenge.combat.EscenarioController;
import dad.fxrevenge.dialog.DialogScreen;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class PrologueDialog extends DialogScreen {

	// COSAS DEL CONTROLADOR DE COMBATE :D
	private EscenarioController combatController;
	private Avatar pj = new Avatar(new Image(getClass().getResource("/images/lightstream.png").toString()),
			ClassType.Archmage, FXCollections.observableArrayList(), "Rayo");
	Enemy bichito = new Enemy(Race.Jelly, 1);
	private Item item1 = new Item(), item2 = new Item(), item3 = new Item();
	private Skill skill1 = new Skill(), skill2 = new Skill(), skill3 = new Skill();

	// Imagen de fondo
	private Image dialogBackground = new Image("/image/dialog/background/prologue.jpg");

	// Personajes
	private Character nullCharacter = CharacterList.getNullChar();

	private Character mainCharacter = CharacterList.getPlayer();
	private Character javaGoddess = CharacterList.getJavaGoddess();

	public PrologueDialog(Stage stage, Canvas canvas, GraphicsContext graphicContext) {
		super(stage, canvas, graphicContext);
	}

	@Override
	public void start() {
		setGraphics(dialogBackground, mainCharacter, javaGoddess);
		super.start();
	}

	@Override
	protected void tickAndRender() {
		super.tickAndRender();

		// Diálogos
		switch (dialogNumber) {

		case 0:
			CharacterTalking(mainCharacter, "<< ¿Dónde estoy? >>");
			break;

		case 1:
			CharacterTalking(mainCharacter, "<< ¿Estaré soñando? Nunca había estado en un lugar como este >>");
			break;

		case 2:
			CharacterTalking(javaGoddess, "Este mundo es una manifestación de tus preocupaciones y temores.");
			break;

		case 3:
			CharacterTalking(javaGoddess,
					"Corres un grave peligro, uno del que no podrás escapar cuando sea demasiado tarde.");
			break;

		case 4:
			CharacterTalking(javaGoddess, "Por eso estás aquí, para fortalecerte y ser capaz de cambiar tu destino.");
			break;

		case 5:
			CharacterTalking(mainCharacter, "¿Qué? ¿Que clase de peligro?");
			break;

		case 6:
			CharacterTalking(javaGoddess, "La chancla de tu madre como no apruebes el curso.");
			break;

		case 7:
			CharacterTalking(nullCharacter, "(La diosa Java se ha esfumado...)");
			break;

		case 8:
			CharacterTalking(mainCharacter, "<< ¿Qué demonios fue eso? >>");
			break;

		default:
			
			// MÁS COSAS DEL CONTROLADOR DE COMBATE :DDD
			item1.setName("poti");
			item1.setQuantity(2);
			item2.setName("galleta");
			item2.setQuantity(5);
			item3.setName("orbe");
			item3.setQuantity(1);

			skill1.setName("miniataque igneo");
			skill2.setName("minihelada");
			skill3.setName("minirayo");

			ObservableList<Item> items = FXCollections.observableArrayList(item1, item2, item3);
			ObservableList<Skill> skills = FXCollections.observableArrayList(skill1, skill2, skill3);
			pj.setInventory(items);
			pj.setSkills(skills);

			bichito.setAppearance(new Image(getClass().getResource("/images/chest.png").toString()));

			try {
				combatController = new EscenarioController(pj, bichito);

				animationTimer.stop();

				Scene scene = new Scene(combatController.getView());
				stage.setScene(scene);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			CharacterTalking(nullCharacter, "FIN DEL DIÁLOGO");
			break;

		}

	}

}
