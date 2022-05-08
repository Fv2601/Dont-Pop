package game.engine;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * The class that controls all sounds and music.
 */
public class AudioManager {
	
	private static final Map<Music, MediaPlayer> MUSICS = new HashMap<>();
	private static final Map<Sound, AudioClip> SOUNDS = new HashMap<>();
	
	/**
	 * Each element of this enum represents a music, playable by the method playMusic.
	 * It's used for long audio files.
	 */
	public static enum Music {
		BALOON_GROOVE("audio/BalloonGroove.wav");

		private Music(final String path) {
			final Media media = new Media(getResPath(path));
			final MediaPlayer mp = new MediaPlayer(media);
			mp.setCycleCount(AudioClip.INDEFINITE);
			MUSICS.put(this, mp);	
		}
	}
	
	/**
	 * Each element of this enum represents a sound, playable by the method playSound.
	 * It's used for short audio clips.
	 */
	public static enum Sound {
		POP("audio/pop.wav"),
		SHIELD_GET("audio/shield_equip.wav"),
		SHIELD_HIT("audio/shield_hit.wav"),
		MULTIPLIER_GET("audio/2x_equip.wav"),
		SWEEPER_GET("audio/sweeper_use.wav");

		private Sound(final String path) {
			SOUNDS.put(this, new AudioClip(getResPath(path)));
		}
	}
	
	/**
	 * Converts a resource path to a URI path, for Audio loading.
	 * @param path
	 * @return correct path
	 */
	private static String getResPath(final String path) {
		return AudioManager.class.getClassLoader().getResource(path).toExternalForm();
	}
	
	/**
	 * Plays a sound using given volume. Volume is a number between 0.0 (muted) and 1.0 (full volume).
	 * @param sound
	 * @param volume
	 */
	public void playSound(final Sound sound, final double volume) {
		SOUNDS.get(sound).play(volume);
	}
	
	/**
	 * Plays a music using given volume. Volume is a number between 0.0 (muted) and 1.0 (full volume).
	 * An AudioManager can play only one music at time and is looped.
	 * @param music
	 * @param volume
	 */
	public void playMusic(final Music music, final double volume) {
		//System.out.println(this.musics.get(music) + " >> " + MUSICS.get(music));
		this.stopMusics();
		MUSICS.get(music).setVolume(volume);
		MUSICS.get(music).play();
	}
	
	/**
	 * Stops all the playing sounds.
	 */
	public void stopSounds() {
		SOUNDS.forEach((s, a) -> a.stop());
	}
	
	/**
	 * Stops all the playing musics.
	 */
	public void stopMusics() {
		MUSICS.forEach((s, m) -> m.stop());
	}
	
	/**
	 * Stops every audio playing.
	 */
	public void stopAll() {
		this.stopSounds();
		this.stopMusics();
	}
}