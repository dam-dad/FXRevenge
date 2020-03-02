package dad.fxrevenge.music;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class Musica {

	public static Musica end = new Musica("/music/end.mp3");
	public static Musica m = new Musica("/music/M.mp3");
	public static Musica c = new Musica("/music/C.mp3");
	public static Musica v = new Musica("/music/V.mp3");
	public static Musica fx = new Musica("/music/FX.mp3");
	
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
