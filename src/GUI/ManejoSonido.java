package GUI;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class ManejoSonido {
	
	private Clip clip;
	
	public void musica(String musicPath) {
		try {
			File music = new File(musicPath);
			if(music.exists()) {
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(music);
				clip = AudioSystem.getClip();
				clip.open(audioInput);
				clip.start();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void musicaDia() {
		musica("salio.wav");
	}
}
