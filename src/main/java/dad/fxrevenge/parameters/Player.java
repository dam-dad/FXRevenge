package dad.fxrevenge.parameters;

import dad.fxrevenge.models.Avatar;
import dad.fxrevenge.models.ClassType;
import dad.fxrevenge.models.Skill;
import javafx.scene.image.Image;

public class Player {

	private static Avatar player;

	private static String name;
	private static Image portrait;
	private static ClassType role = ClassType.Warlord;

	public Player() {
		player = new Avatar(portrait, role, Skill.generateClassSkills(role), name);
	}

	public Player(String name, Image portrait, ClassType role) {
		Player.name = name;
		Player.portrait = portrait;
		Player.role = role;

		player = new Avatar(portrait, role, Skill.generateClassSkills(role), name);
	}

	public static Avatar getPlayer() {
		return player;
	}

	/**
	 * Funcion de testeo para el informe
	 * 
	 * @return
	 */
	public static Avatar getNewPlayer() {

		Avatar.class.getClassLoader();
//		ClassLoader classLoader = ClassLoader.getSystemClassLoader();

		Avatar x = new Avatar(ClassType.Warlord, Skill.generateClassSkills(ClassType.Warlord), "Chuk Norris");
		return x;
	}

	public static void setName(String name) {
		Player.name = name;
	}

	public static void setPortrait(Image portrait) {
		Player.portrait = portrait;
	}

	public static void setRole(ClassType role) {
		Player.role = role;
	}

}
