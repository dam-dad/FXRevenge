package dad.fxrevenge.music;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class Musica {

	private static Musica end = new Musica("/music/end.mp3");
	private static Musica m = new Musica("/music/M.mp3");
	private static Musica c = new Musica("/music/C.mp3");
	private static Musica v = new Musica("/music/V.mp3");
	private static Musica fx = new Musica("/music/FX.mp3");
	private static Musica combat = new Musica("/music/combat.mp3");

	private static Duration combatTime = Duration.ZERO;
	
	private Media sound;
	private MediaPlayer mediaPlayer;

	public Musica(String rutaArchivo) {
		try {
			sound = new Media(new File(getClass().getResource(rutaArchivo).toURI().toURL().toString()).toString()
					.replace("\\", "/"));
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mediaPlayer = new MediaPlayer(sound);
	}

	public Media getSound() {
		return sound;
	}

	public MediaPlayer playInfiniteSound() {
		mediaPlayer.cycleCountProperty().set(MediaPlayer.INDEFINITE);
		return mediaPlayer;
	}
	
	public MediaPlayer playInfiniteSound(Duration time) {
		mediaPlayer.setStartTime(time);
		return playInfiniteSound();
	}

	public MediaPlayer playSound() {
		mediaPlayer.cycleCountProperty().set(1);
		return mediaPlayer;
	}

	public MediaPlayer playSound(Duration time) {
		mediaPlayer.setStartTime(time);
		return playSound();
	}
	
	public MediaPlayer startTime(Duration time) {
		mediaPlayer.setStartTime(time);
		return mediaPlayer;
	}

	public MediaPlayer getMediaPlayer() {
		return mediaPlayer;
	}

	public static Musica getEnd() {
		return end;
	}

	public static Musica getM() {
		return m;
	}

	public static Musica getC() {
		return c;
	}

	public static Musica getV() {
		return v;
	}

	public static Musica getFx() {
		return fx;
	}
	
	public static Musica getCombat() {
		return combat;
	}

	public static Duration getCombatTime() {
		return combatTime;
	}

	public static void setCombatTime(Duration combatTime) {
		Musica.combatTime = combatTime;
	}

}
