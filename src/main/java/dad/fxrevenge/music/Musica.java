package dad.fxrevenge.music;

import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class Musica {

	private Media sound;
	private MediaPlayer mediaPlayer;

	public Musica(String rutaArchivo) {
		try {
			sound = new Media(new File(getClass().getResource(rutaArchivo).toURI().toURL().toString()).toString().replace("\\", "/"));
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mediaPlayer = new MediaPlayer(sound);
	}

	public static void main(String[] args) {
//		new Musica();
	}
	
	public Media getSound() {
		return sound;
	}
	
	public MediaPlayer playInfiniteSound() {
		mediaPlayer.cycleCountProperty().set(MediaPlayer.INDEFINITE);
		return mediaPlayer;
	}
	
	public MediaPlayer playSound() {
		mediaPlayer.cycleCountProperty().set(1);
		return mediaPlayer;
	}
	
	public MediaPlayer getMediaPlayer() {
		return mediaPlayer;
	}
}
