package dad.fxrevenge.music;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

public class Musica {

	public static Media fondoInicio;
	public static Media sound;

	public Musica() {
		sound = new Media(new File(getClass().getResource("/music/pink-panther.mp3").toString()).toString());
		MediaPlayer mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.play();
	}
	
	public static void main(String[] args) {
		new Musica();
	}
}
